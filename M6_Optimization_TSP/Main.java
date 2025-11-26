import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
// Ogrenci: Alaa Aljarad
// No: 240404969
public class Main {
    private static Object sayac;
    public static void main(String[] args) {
        DosyaIslemleri dosya = new DosyaIslemleri();
        Algoritmalar algo = new Algoritmalar();
        Random r = new Random();
        String dosyaYolu = "src/att48.tsp";
        ArrayList<Sehir> veriler = dosya.oku(dosyaYolu);
        if (veriler.size() == 0) {
            System.out.println("Veri yok.");
        } else {
            ArrayList<ArrayList<Sehir>> pop = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                ArrayList<Sehir> temp = new ArrayList<>(veriler);
                Collections.shuffle(temp);
                pop.add(temp);
            }
            double globalBest = 999999999;
            int sayac = 0;
            int nesil = 0;
            while (nesil < 100 && sayac < 5) {
                algo.sirala(pop);
                double mevcutBest = algo.hesaplaMesafe(pop.get(0));
                System.out.println("Nesil: " + nesil + " En iyi: " + (int)mevcutBest);
                if (mevcutBest < globalBest) {
                    globalBest = mevcutBest;
                    sayac = 0;
                } else {
                    sayac++;
                }
                ArrayList<ArrayList<Sehir>> yeniPop = new ArrayList<>();
                yeniPop.add(new ArrayList<>(pop.get(0))); // elitizm
                while (yeniPop.size() < 100) {
                    ArrayList<Sehir> p1, p2;
                    if (r.nextDouble() > 0.5) {
                        p1 = algo.rankSecim(pop);
                        p2 = algo.rankSecim(pop);
                    } else {
                        p1 = algo.ruletSecim(pop);
                        p2 = algo.ruletSecim(pop);
                    }
                    ArrayList<Sehir> cocuk = algo.cycleCross(p1, p2);
                    if (r.nextDouble() < 0.5) algo.mutasyonInsert(cocuk);
                    else algo.mutasyonSwap(cocuk);
                    yeniPop.add(cocuk);
                }
                pop = yeniPop;
                nesil++;
            }
            System.out.println("Bitti sukur :)");
            System.out.println("En iyi sonuc: " + (int)globalBest);// bonusu calistir
            ArrayList<Sehir> son = algo.opt2(pop.get(0));
            System.out.println("Bonus (2-opt) sonrasi: " + (int)algo.hesaplaMesafe(son));
        }

    }
}