import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int secretNumber;
        do {
            secretNumber = (int) (Math.random() * 9000) + 1000;
        } while (!checkUniqueDigits(secretNumber));

        System.out.println("A 4-digit number has been chosen.. try to guess it.");

        int guessCount = 0;

        while (true) {
            guessCount++;
            System.out.print(guessCount + ".Your guess: ");
            int userGuess = scanner.nextInt();

            if ((!checkUniqueDigits(userGuess)) || (userGuess < 1000 || userGuess > 9999)) {
                System.out.println("Please enter a valid number!!");
                continue;
            }

            if (userGuess == secretNumber) {
                System.out.println("CONGRATULATIONS! You guessed it in " + guessCount + " guesses.");
                break;

            } else {

                int correctDigits = 0;
                int misplacedDigits = 0;

                String secretNumberStr = ""+secretNumber;
                String userGuessStr = ""+userGuess;

                for (int i = 0; i < 4; i++) {
                    if (secretNumberStr.charAt(i) == userGuessStr.charAt(i)) {
                        correctDigits++;
                    } else if (secretNumberStr.indexOf(userGuessStr.charAt(i)) != -1) {
                        misplacedDigits++;
                    }
                }

                System.out.println("+" + correctDigits + " -" + misplacedDigits);
            }
        }
    }

    public static boolean checkUniqueDigits(int number) {
        boolean[] digitList = new boolean[10];

        while (number > 0) {
            int digit = number % 10;
            if (digitList[digit]) {
                return false;
            }
            digitList[digit] = true;
            number /= 10;
        }

        return true;
    }
}
