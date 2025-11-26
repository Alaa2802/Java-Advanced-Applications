import java.util.Scanner;

public class Mastermind2 {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Please think of a four-digit number and press ENTER after typing OK:");
        String confirmation = inputScanner.nextLine();
        if (!confirmation.equalsIgnoreCase("OK")) {
            System.out.println("Invalid input! Exiting the program.");
            return;
        }

        boolean[] possibleCodes = new boolean[9000];
        for (int i = 1023; i <= 9876; i++) {
            possibleCodes[i - 1023] = isValidCode(i);
        }
        boolean uniqueDigits;
        int currentAttempt;
        int attemptCount;
        do {
            attemptCount = 1;
            currentAttempt = (int) (Math.random() * 8853) + 1024;
            uniqueDigits = checkUniqueDigits(currentAttempt);
        } while (!uniqueDigits);
        while (true) {
            System.out.println(attemptCount + "th Attempt: " + currentAttempt);
            String feedback = inputScanner.nextLine();

            switch (feedback) {
                case "+4":
                    System.out.println("I found the number in " + attemptCount + " attempts.");
                    return;
                case "+0-0":
                case "+0-1":
                case "+0-2":
                case "+0-3":
                case "+0-4":
                case "+1-0":
                case "+1-1":
                case "+1-2":
                case "+1-3":
                case "+2-0":
                case "+2-1":
                case "+2-2":
                case "+3-0":
                case "+3-1":
                case "+4-0":
                    updatePossibleCodes(possibleCodes, currentAttempt, feedback);
                    break;
                default:
                    System.out.println("Invalid feedback!");
                    return;
            }

            currentAttempt = getNextAttempt(possibleCodes, currentAttempt);
            attemptCount++;
        }
    }

    public static boolean isValidCode(int code) {
        int[] digitCount = new int[10];
        while (code > 0) {
            int digit = code % 10;
            if (digitCount[digit] > 0) {
                return false;
            }
            digitCount[digit]++;
            code /= 10;
        }
        return true;
    }

    public static boolean isFeedbackMatching(int attempt, int code, String feedback) {
        int correctPlace = 0;
        int correctDigit = 0;
        String attemptStr = String.valueOf(attempt);
        String codeStr = String.valueOf(code);

        for (int i = 0; i < 4; i++) {
            if (attemptStr.charAt(i) == codeStr.charAt(i)) {
                correctPlace++;
            } else if (attemptStr.contains(String.valueOf(codeStr.charAt(i)))) {
                correctDigit++;
            }
        }

        return (feedback.equals("+" + correctPlace + "-" + correctDigit));
    }

    public static void updatePossibleCodes(boolean[] possibleCodes, int attempt, String feedback) {
        for (int i = 1023; i <= 9876; i++) {
            if (!isFeedbackMatching(attempt, i, feedback)) {
                possibleCodes[i - 1023] = false;
            }
        }
    }

    public static int getNextAttempt(boolean[] possibleCodes, int previousAttempt) {
        int nextAttempt = -1;
        for (int i = previousAttempt - 1023 + 1; i < possibleCodes.length; i++) {
            if (possibleCodes[i]) {
                nextAttempt = i + 1023;
                break;
            }
        }
        if (nextAttempt == -1) {
            for (int i = 0; i < previousAttempt - 1023; i++) {
                if (possibleCodes[i]) {
                    nextAttempt = i + 1023;
                    break;
                }
            }
        }
        return nextAttempt;
    }

    public static boolean checkUniqueDigits(int attempt) {
        String attemptStr = String.valueOf(attempt);

        for (int i = 0; i < attemptStr.length(); i++) {
            char currentDigit = attemptStr.charAt(i);

            for (int j = i + 1; j < attemptStr.length(); j++) {
                if (currentDigit == attemptStr.charAt(j)) {
                    return false;
                }
            }
        }

        return attemptStr.length() == 4;
    }
}
