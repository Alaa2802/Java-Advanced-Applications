public class Book {
    private String title;
    private int totalPages;
    private int currentPage;
    private BookMark bookmark;

    public Book() {
        this.title = "Untitled";
        this.totalPages = 10;
        this.currentPage = 1;
        this.bookmark = new BookMark();
    }

    public Book(String title, int totalPages) {
        if (title == null || title.trim().isEmpty()) {
            this.title = "Untitled";
        } else {
            this.title = title;
        }

        if (totalPages < 10) {
            this.totalPages = 10;
        } else {
            this.totalPages = totalPages;
        }

        this.currentPage = 1;
        this.bookmark = new BookMark();
    }

    public void openToPage(int page) {
        if (page < 1 || page > totalPages) {
            System.out.println("Hatalı sayfa numarası! Sayfa aralığı: 1 - " + totalPages);
        } else {
            this.currentPage = page;
            System.out.println(page + ". sayfa açıldı.");
        }
    }

    public void placeBookmark() {
        bookmark.setPage(currentPage);
        System.out.println("Yer imi " + currentPage + ". sayfaya yerleştirildi.");
    }

    public void goToBookmark() {
        this.currentPage = bookmark.getPage();
        System.out.println("Yer imine gidildi. Şu anda " + currentPage + ". sayfadasınız.");
    }

    public void printInfo() {
        System.out.println("Kitap Adı: " + title);
        System.out.println("Toplam Sayfa: " + totalPages);
        System.out.println("Mevcut Sayfa: " + currentPage);
        bookmark.printInfo();
    }

    @Override
    protected void finalize() {
        System.out.println("Book nesnesi yok edildi.");
    }
}
