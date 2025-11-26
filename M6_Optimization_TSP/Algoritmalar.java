import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Algoritmalar {
    Random rnd = new Random();
    public double hesaplaMesafe(ArrayList<Sehir> rota) {
        double toplam = 0;
        for (int i = 0; i < rota.size(); i++) {
            Sehir s1 = rota.get(i);
            Sehir s2 = rota.get((i + 1) % rota.size());
            toplam += s1.uzaklik(s2);
        }
        return toplam;
    }
    public void sirala(ArrayList<ArrayList<Sehir>> pop) {
        pop.sort((o1, o2) -> Double.compare(hesaplaMesafe(o1), hesaplaMesafe(o2)));
    }
    public ArrayList<Sehir> rankSecim(ArrayList<ArrayList<Sehir>> pop) {
        // ilk %30 luk kisimdan rastgele al
        int sinir = (int)(pop.size() * 0.3);
        if (sinir < 1) sinir = 1;
        return pop.get(rnd.nextInt(sinir));
    }
    public ArrayList<Sehir> ruletSecim(ArrayList<ArrayList<Sehir>> pop) {
        double toplamFit = 0;
        double[] fitDegerleri = new double[pop.size()];
        for (int i = 0; i < pop.size(); i++) {
            double yol = hesaplaMesafe(pop.get(i));
            fitDegerleri[i] = 1.0 / yol;
            toplamFit += fitDegerleri[i];
        }
        double sans = rnd.nextDouble() * toplamFit;
        double kosu = 0;
        for (int i = 0; i < pop.size(); i++) {
            kosu += fitDegerleri[i];
            if (kosu >= sans) {
                return pop.get(i);
            }
        }
        return pop.get(0);
    }
    public ArrayList<Sehir> cycleCross(ArrayList<Sehir> p1, ArrayList<Sehir> p2) {
        int boyut = p1.size();
        ArrayList<Sehir> cocuk = new ArrayList<>(Collections.nCopies(boyut, null));
        int i = 0;
        while (cocuk.get(i) == null) {
            cocuk.set(i, p1.get(i));
            Sehir hedef = p2.get(i);
            for (int k = 0; k < boyut; k++) {
                if (p1.get(k).no == hedef.no) {
                    i = k;
                    break;
                }
            }
        }
        for (int k = 0; k < boyut; k++) {
            if (cocuk.get(k) == null) {
                cocuk.set(k, p2.get(k));
            }
        }
        return cocuk;
    }
    public void mutasyonInsert(ArrayList<Sehir> r) {
        int a = rnd.nextInt(r.size());
        int b = rnd.nextInt(r.size());
        Sehir tmp = r.remove(a);
        r.add(b, tmp);
    }
    public void mutasyonSwap(ArrayList<Sehir> r) {
        int a = rnd.nextInt(r.size());
        int b = rnd.nextInt(r.size());
        Collections.swap(r, a, b);
    }
    public ArrayList<Sehir> opt2(ArrayList<Sehir> gelen) {
        ArrayList<Sehir> enIyi = new ArrayList<>(gelen);
        boolean gelisme = true;
        int limit = 0;
        while (gelisme && limit < 80) {
            gelisme = false;
            double bestMesafe = hesaplaMesafe(enIyi);
            for (int i = 1; i < enIyi.size() - 2; i++) {
                for (int j = i + 1; j < enIyi.size(); j++) {
                    if (j - i == 1) continue;
                    ArrayList<Sehir> yeni = swap2(enIyi, i, j);
                    double yeniMesafe = hesaplaMesafe(yeni);

                    if (yeniMesafe < bestMesafe) {
                        enIyi = yeni;
                        bestMesafe = yeniMesafe;
                        gelisme = true;
                    }
                }
            }
            limit++;
        }
        return enIyi;
    }
    private ArrayList<Sehir> swap2(ArrayList<Sehir> r, int i, int j) {
        ArrayList<Sehir> yeni = new ArrayList<>();
        for (int k = 0; k < i; k++) yeni.add(r.get(k));
        for (int k = j; k >= i; k--) yeni.add(r.get(k));
        for (int k = j + 1; k < r.size(); k++) yeni.add(r.get(k));
        return yeni;
    }
}