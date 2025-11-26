import java.util.Random;

public class Main5 {

    public static void main(String[] args) {
        int passwordCount = 100;
        for (int i = 0; i < passwordCount; i++) {
            generateSecurePassword(15); // 15 karakterli güvenli şifre oluştur
        }
    }

    public static void generateSecurePassword(int length) {
        String password = "";
        Random random = new Random();
        int upperCount = 0;
        int lowerCount = 0;
        int digitCount = 0;
        int symbolCount = 0;

        // En az 3 büyük harf
        for (int i = 0; i < 3; i++) {
            char upper = (char) (random.nextInt(26) + 'A');
            password += upper;
            upperCount++;
        }

        // En az 3 küçük harf
        for (int i = 0; i < 3; i++) {
            char lower = (char) (random.nextInt(26) + 'a');
            password += lower;
            lowerCount++;
        }

        // En az 3 rakam
        for (int i = 0; i < 3; i++) {
            char digit = (char) (random.nextInt(10) + '0');
            password += digit;
            digitCount++;
        }

        // En az 3 sembol (ASCII tablosunda 33-126 arasında)
        for (int i = 0; i < 3; i++) {
            char symbol = (char) (random.nextInt(94) + 33);
            password += symbol;
            symbolCount++;
        }

        // Geri kalan karakterler
        int remainingLength = length - 12; // 12 karakter zaten ekledik
        for (int i = 0; i < remainingLength; i++) {
            char randomChar = (char) (random.nextInt(94) + 33); // 33-126 arasındaki karakterler
            password += randomChar;
            // Karakter tipini say
            if (randomChar >= 'A' && randomChar <= 'Z') {
                upperCount++;
            } else if (randomChar >= 'a' && randomChar <= 'z') {
                lowerCount++;
            } else if (randomChar >= '0' && randomChar <= '9') {
                digitCount++;
            } else {
                symbolCount++;
            }
        }

        // Karakterlerin sırasını karıştır
        password = shuffle(password);

        System.out.println(password + " (Büyük: " + upperCount + ", Küçük: " + lowerCount
                + ", Rakam: " + digitCount + ", Sembol: " + symbolCount + ")");
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
