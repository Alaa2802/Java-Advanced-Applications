
     class KarasalKargo implements Kargo {
        @Override
        public double teslimatSuresiHesapla(double mesafe) {
            return Math.ceil(mesafe / 100); // 100 km için 1 gün
        }

        @Override
        public double ucretHesapla(double agirlik) {
            return agirlik * 5; // 1 kg için 5 TL
        }

        @Override
        public void tasima() {
            System.out.println("Karasal kargo taşınıyor...");
        }
    }


