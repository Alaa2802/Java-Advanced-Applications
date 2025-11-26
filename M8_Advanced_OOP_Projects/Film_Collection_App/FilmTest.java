public class FilmTest {
        public static void main(String[] args) {
            BelgeselFilm belgesel = new BelgeselFilm(" the vietnam war ", "sherman beck", 2017, 9.1, " vietnam savaşı ");
            AksiyonFilmi aksiyon = new AksiyonFilmi("extraction", "rosn", 2020, 6.9, "mafia");
            KomediFilmi komedi = new KomediFilmi("Kahkaha Zamanı", "Jane Smith", 2018, 6.9, 70);
            FantastikFilm fantastik = new FantastikFilm("stranger things", "the duffer brothers", 2003, 8.7, "ozel güç");

            belgesel.temelBilgi();
            belgesel.bilgiGoster();

            System.out.println();

            aksiyon.temelBilgi();
            aksiyon.bilgiGoster();

            System.out.println();

            komedi.temelBilgi();
            komedi.bilgiGoster();

            System.out.println();

            fantastik.temelBilgi();
            fantastik.bilgiGoster();
        }
    }

