

import java.util.Random;

public class Main4 {
    public static void main(String[] args) {
        Random output = new Random();
        for (int i = 0; i < 100; i++) {
            String password = "";

            // 1-2-3 characters random number
            for (int j = 0; j < 3; j++) {
                password += output.nextInt(10);
            }

            // 4-5-6 characters random uppercase
            for (int k = 0; k < 3; k++) {
                password += (char) (output.nextInt(26) + 'A');
            }

            // 7-8-9 characters random lowercase
            for (int v = 0; v < 3; v++) {
                password += (char) (output.nextInt(26) + 'a');
            }

            // 10-11-12 characters are among the 33rd-126th characters in the ASCII table
            for (int a = 0; a < 3; a++) {
                char x;
                do {
                    x = (char) (output.nextInt(94) + 33);
                } while (Character.isLetterOrDigit(x));
                password += x;
            }

            System.out.println((i + 1) + ". Password: " + password);
        }
    }
}