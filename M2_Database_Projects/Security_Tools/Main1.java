
import java.util.Random;

public class Main1 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] uniquePasswords = new int[100];
        int count = 0;

        System.out.println("Unique Passwords:");
        while (count < 100) {
            int password = random.nextInt(900) + 100; // Generate a random three-digit password
            boolean isUnique = true;
            for (int i = 0; i < count; i++) {
                if (uniquePasswords[i] == password) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                uniquePasswords[count] = password; // Add the generated password to the array
                System.out.println("Password " + (count + 1) + ": " + password);
                count++;
            }
        }
    }
}