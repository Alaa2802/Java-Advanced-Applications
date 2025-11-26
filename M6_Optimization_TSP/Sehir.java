public class Sehir {
    int no;
    double x;
    double y;

    public Sehir(int no, double x, double y) {
        this.no = no;
        this.x = x;
        this.y = y;
    }
    public double uzaklik(Sehir diger) {
        double farkX = this.x - diger.x;
        double farkY = this.y - diger.y;
        return Math.sqrt(farkX * farkX + farkY * farkY);
    }
}