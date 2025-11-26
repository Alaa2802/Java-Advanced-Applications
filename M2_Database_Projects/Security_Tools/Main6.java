import java.util.Random;

public class Main6 {

    public static void main(String[] args) {
        int passwordCount = 100;
        for (int i = 0; i < passwordCount; i++) {
            String password = generateSecurePassword(15); // 15 karakterli güvenli şifre oluştur
            System.out.println(password);
        }
    }

    public static String generateSecurePassword(int length) {
        String password = "";

        password += generateRandomUpperCase(); // Rasgele büyük harf
        password += generateRandomUpperCase();
        password += generateRandomUpperCase();

        password += generateRandomLowerCase(); // Rasgele küçük harf
        password += generateRandomLowerCase();
        password += generateRandomLowerCase();

        password += generateRandomDigit(); // Rasgele rakam
        password += generateRandomDigit();
        password += generateRandomDigit();

        password += generateRandomSymbol(); // Rasgele sembol
        password += generateRandomSymbol();
        password += generateRandomSymbol();

        int remainingLength = length - 12; // 12 karakter zaten ekledik
        Random random = new Random();
        for (int i = 0; i < remainingLength; i++) {
            char randomChar = (char) (random.nextInt(94) + 33); // 33-126 arasındaki karakterler
            password += randomChar;
        }

        // Karakterlerin sırasını karıştır
        return shuffle(password);
    }

    public static char generateRandomUpperCase() {
        Random random = new Random();
        return (char) (random.nextInt(26) + 'A');
    }

    public static char generateRandomLowerCase() {
        Random random = new Random();
        return (char) (random.nextInt(26) + 'a');
    }

    public static char generateRandomDigit() {
        Random random = new Random();
        return (char) (random.nextInt(10) + '0');
    }

    public static char generateRandomSymbol() {
        Random random = new Random();
        return (char) (random.nextInt(15) + 33);
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
