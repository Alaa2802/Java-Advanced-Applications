import java.util.Scanner;

public class ZiplayanTopOyunu {
    public ZiplayanTopOyunu() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(" dizisinin uzunluğunu girin : ");
        int n = scanner.nextInt();
        scanner.nextLine();
        System.out.print("bu iki karakterlerinden ('<', '>') bir seçin: ");
        String input = scanner.nextLine();
        if (input.length() != n) {
            System.out.println("Gecersiz giris. uzunlugu " + n + " olmalidir.");
        } else {
            char[] carpanlar = input.toCharArray();
            int s = 0;
            boolean[] ze = new boolean[n];

            for(int i = 0; i < n; ++i) {
                int p= i;
                boolean oyunAlaniDisinaCikti = false;

                while(p >= 0 && p < n && !ze[p]) {
                    ze[p] = true;
                    if (carpanlar[p] == '>') {
                        ++p;
                    } else {
                        --p;
                    }

                    if (p < 0 || p>= n) {
                        oyunAlaniDisinaCikti = true;
                        break;
                    }
                }

                if (oyunAlaniDisinaCikti) {
                    ++s;
                }

                for(int j = 0; j < n; ++j) {
                    ze[j] = false;
                }
            }

            System.out.println("Oyun alanindan baslangic pozisyonlarinin sayisi: " + s);
        }
    }
}
