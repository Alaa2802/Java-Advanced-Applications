import java.util.Random;
import java.util.Scanner;

public class Main7 {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Kaç karakterlik bir şifre oluşturmak istersiniz? ");
        int length = inputScanner.nextInt();

        System.out.print("Şifrede en az kaç rakam olmalı? ");
        int minDigitCount = inputScanner.nextInt();

        System.out.print("Şifrede en az kaç küçük harf olmalı? ");
        int minLowerCaseCount = inputScanner.nextInt();

        System.out.print("Şifrede en az kaç büyük harf olmalı? ");
        int minUpperCaseCount = inputScanner.nextInt();

        System.out.print("Şifrede en az kaç sembol olmalı? ");
        int minSymbolCount = inputScanner.nextInt();

        inputScanner.close();

        String errorMessage = checkInput(length, minDigitCount, minLowerCaseCount, minUpperCaseCount, minSymbolCount);
        if (errorMessage != null) {
            System.out.println("Hata Raporu:");
            System.out.println("-------------");
            System.out.println(errorMessage);
            System.out.println("-------------");
            return;
        }

        String password = generateSecurePassword(length, minDigitCount, minLowerCaseCount, minUpperCaseCount, minSymbolCount);
        System.out.println("Oluşturulan Şifre: " + password);
    }

    public static String checkInput(int length, int minDigitCount, int minLowerCaseCount, int minUpperCaseCount, int minSymbolCount) {
        if (length < minDigitCount + minLowerCaseCount + minUpperCaseCount + minSymbolCount) {
            return "Şifre uzunluğu, belirtilen rakam, küçük harf, büyük harf ve sembol sayılarının toplamından küçük olamaz.";
        }

        if (length < 0 || minDigitCount < 0 || minLowerCaseCount < 0 || minUpperCaseCount < 0 || minSymbolCount < 0) {
            return "Şifre uzunluğu veya belirtilen rakam, küçük harf, büyük harf veya sembol sayısı negatif olamaz.";
        }

        return null;
    }

    public static String generateSecurePassword(int length, int minDigitCount, int minLowerCaseCount, int minUpperCaseCount, int minSymbolCount) {
        Random random = new Random();
        String password = "";

        int remainingLength = length - minDigitCount - minLowerCaseCount - minUpperCaseCount - minSymbolCount;

        for (int i = 0; i < minDigitCount; i++) {
            password += (char) (random.nextInt(10) + '0');
        }

        for (int i = 0; i < minLowerCaseCount; i++) {
            password += (char) (random.nextInt(26) + 'a');
        }

        for (int i = 0; i < minUpperCaseCount; i++) {
            password += (char) (random.nextInt(26) + 'A');
        }

        for (int i = 0; i < minSymbolCount; i++) {
            password += (char) (random.nextInt(15) + 33);
        }

        for (int i = 0; i < remainingLength; i++) {
            password += (char) (random.nextInt(94) + 33);
        }

        return shuffle(password);
    }

    public static String shuffle(String string) {
        char[] array = string.toCharArray();
        Random random = new Random();

        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }

        return new String(array);
    }
}