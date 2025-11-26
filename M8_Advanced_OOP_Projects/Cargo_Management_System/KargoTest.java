
    import java.util.Scanner;

    public class KargoTest {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Kargo türünü seçiniz (1: Karasal, 2: Hava): ");
            int kargoTipi = scanner.nextInt();

            System.out.println("Mesafeyi giriniz (km): ");
            double mesafe = scanner.nextDouble();

            System.out.println("Ağırlığı giriniz (kg): ");
            double agirlik = scanner.nextDouble();

            Kargo kargo;

            if (kargoTipi == 1) {
                kargo = new KarasalKargo();
            } else {
                kargo = new HavaKargo();
            }

            double teslimatSuresi = kargo.teslimatSuresiHesapla(mesafe);
            double ucret = kargo.ucretHesapla(agirlik);

            kargo.tasima();
            System.out.printf("Teslimat Süresi: %.0f gün%n", teslimatSuresi);
            System.out.printf("Kargo Ücreti: %.2f TL%n", ucret);

            scanner.close();
        }
    }

