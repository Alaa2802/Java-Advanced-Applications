import java.util.LinkedList;
import java.util.Queue;

class AcilServisKuyrugu {
    private Queue<Hasta> yesilAlan = new LinkedList<>();
    private Queue<Hasta> sariAlan = new LinkedList<>();
    private Queue<Hasta> kirmiziAlan = new LinkedList<>();

    public void hastaEkle(Hasta hasta) {
        switch (hasta.getCiddiyet()) {
            case 3 -> kirmiziAlan.add(hasta);
            case 2 -> sariAlan.add(hasta);
            case 1 -> yesilAlan.add(hasta);
        }
    }

    public void hastaIsle() throws InterruptedException {
        System.out.println("\n Hasta İşleme Başladı...");

        while (!kirmiziAlan.isEmpty() || !sariAlan.isEmpty() || !yesilAlan.isEmpty()) {
            for (int i = 0; i < 3; i++) {
                if (!kirmiziAlan.isEmpty()) {
                    System.out.println("Kırmızı Alan'da işlenen: " + kirmiziAlan.poll());
                    Thread.sleep(1000);
                }
            }

            for (int i = 0; i < 2; i++) {
                if (!sariAlan.isEmpty()) {
                    System.out.println("Sarı Alan'da işlenen: " + sariAlan.poll());
                    Thread.sleep(1000);
                }
            }
            if (!yesilAlan.isEmpty()) {
                System.out.println("Yeşil Alan'da işlenen: " + yesilAlan.poll());
                Thread.sleep(1000);
            }
        }
        System.out.println(" Tüm hastalar işlendi :)");
    }

    public static void main(String[] args) throws InterruptedException {
        AcilServisKuyrugu servis = new AcilServisKuyrugu();

        for (int i = 1; i <= 20; i++) {
            Hasta yeniHasta = new Hasta("Hasta " + i);
            servis.hastaEkle(yeniHasta);
            System.out.println("Eklendi: " + yeniHasta);
        }

        servis.hastaIsle();
    }
}