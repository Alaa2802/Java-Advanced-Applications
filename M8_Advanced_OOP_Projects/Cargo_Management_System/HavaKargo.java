    class HavaKargo implements Kargo {
    @Override
    public double teslimatSuresiHesapla(double mesafe) {
        return Math.ceil(mesafe / 500);
    }

    @Override
    public double ucretHesapla(double agirlik) {
        return agirlik * 10;
    }

    @Override
    public void tasima() {
        System.out.println("Hava kargo taşınıyor....");
    }
}

