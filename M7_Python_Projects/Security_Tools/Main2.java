

import java.util.Random;

public class Main2 {
    public static void main(String[] args) {
        // Print the generated passwords to the screen
        System.out.println("The Passwords :");
        for (int i = 0; i < 100; i++) {
            char[] password = generatePassword();
            //password numbers;
            System.out.print("Passwords "+(i+1)+" : ");
            System.out.println(password);


        }
    }
    public static char[] generatePassword() {
        Random output = new Random();
        char[] password = new char[3];
        //generate random password containing 3 uppercase letters
        for (int i = 0; i < 3; i++) {
            password[i] = (char) (output.nextInt(26) + 'A');
        }

        return password;
    }
}