import java.util.Random;

public class Hasta {
    private String ad;
    private int ciddiyet;

    public Hasta(String ad) {
        this.ad = ad;
        this.ciddiyet = new Random().nextInt(3) + 1;
    }

    public String getAd() {
        return ad;
    }

    public int getCiddiyet() {
        return ciddiyet;
    }

    @Override
    public String toString() {
        return ad + " (Ciddiyet: " + ciddiyet + ")";
    }
}
