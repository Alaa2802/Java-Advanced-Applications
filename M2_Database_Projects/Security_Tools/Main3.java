import java.util.Random;

public class Main3 {
    public static void main(String[] args) {
        Random output = new Random();
        for (int i = 0; i < 100; i++) {
            String password = "";

            // İlk üç karakter rastgele büyük harf
            for (int j = 0; j < 3; j++) {
                password += (char) (output.nextInt(26) + 'A');
            }

            // Sonraki üç karakter rastgele küçük harf
            for (int k = 0; k < 3; k++) {
                password += (char) (output.nextInt(26) + 'a');
            }

            // Son üç karakter rastgele rakam
            for (int a = 0; a < 3; a++) {
                password += output.nextInt(10);
            }

            System.out.println((i + 1) + ". Şifre: " + password);
        }
    }
}