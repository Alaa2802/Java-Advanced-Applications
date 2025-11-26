import java.util.Scanner;

public class Decoder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Şifreli bir mesajı giriniz:");
        String mesaji = scanner.nextLine();

        String binaryString = mesaji.replaceAll("zero", "0").replaceAll("ZERO", "0")
                .replaceAll("one", "1").replaceAll("ONE", "1")
                .replaceAll("[^01]", "");
        StringBuilder decodedMesaji = new StringBuilder();
        for (int i = 0; i < binaryString.length(); i += 8) {
            if (i + 8 <= binaryString.length()) {
                String byteString = binaryString.substring(i, i + 8);
                int charCode = Integer.parseInt(byteString, 2);
                decodedMesaji.append((char) charCode);
            }
        }
        System.out.println("Çözülen Mesaj: " + decodedMesaji.toString());
        scanner.close();
    }
}
