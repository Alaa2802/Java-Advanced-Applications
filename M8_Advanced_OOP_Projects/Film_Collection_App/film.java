    abstract class Film {
    protected String filmAdi;
    protected String yonetmen;
    protected int yayinYili;
    protected double puan;

    public Film (String filmAdi, String yonetmen, int yayinYili, double puan) {
        this.filmAdi = filmAdi;
        this.yonetmen = yonetmen;
        this.yayinYili = yayinYili;
        this.puan = puan;
    }

    public final void temelBilgi() {
        System.out.println("Film Adı: " + filmAdi);
        System.out.println("Yönetmen: " + yonetmen);
        System.out.println("Yayın Yılı: " + yayinYili);
        System.out.println("Puan: " + puan);
    }

    public abstract void bilgiGoster();
}

    final class BelgeselFilm extends Film {
        private String konu;

        public BelgeselFilm(String filmAdi, String yonetmen, int yayinYili, double puan, String konu) {
            super(filmAdi, yonetmen, yayinYili, puan);
            this.konu = konu;
        }

        @Override
        public void bilgiGoster() {
            System.out.println("Belgesel Konusu: " + konu);
        }
    }

    class AksiyonFilmi extends Film {
        private String aksiyonTuru;

        public AksiyonFilmi(String filmAdi, String yonetmen, int yayinYili, double puan, String aksiyonTuru) {
            super(filmAdi, yonetmen, yayinYili, puan);
            this.aksiyonTuru = aksiyonTuru;
        }

        @Override
        public void bilgiGoster() {
            System.out.println("Aksiyon Türü: " + aksiyonTuru);
        }
    }

    class KomediFilmi extends Film {
        private int sakaSayisi;

        public KomediFilmi(String filmAdi, String yonetmen, int yayinYili, double puan, int sakaSayisi) {
            super(filmAdi, yonetmen, yayinYili, puan);
            this.sakaSayisi = sakaSayisi;
        }

        @Override
        public void bilgiGoster() {
            System.out.println("Şaka Sayısı: " + sakaSayisi);
        }
    }

    class FantastikFilm extends Film {
        private String fantastikDunya;

        public FantastikFilm(String filmAdi, String yonetmen, int yayinYili, double puan, String fantastikDunya) {
            super(filmAdi, yonetmen, yayinYili, puan);
            this.fantastikDunya = fantastikDunya;
        }

        @Override
        public void bilgiGoster() {
            System.out.println("Fantastik Dünya: " + fantastikDunya);
        }
    }

