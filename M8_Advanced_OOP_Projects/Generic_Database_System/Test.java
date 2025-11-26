public class Test {
    public static void main(String[] args) {
        // Öğrenci veritabanı
        GenericDatabase<Student> studentDatabase = new GenericDatabase<>();
        studentDatabase.addRecord(new Student("Ahmet", "1001"));
        studentDatabase.addRecord(new Student("Ayşe", "1002"));

        System.out.println("Öğrenci kayıtları:");
        studentDatabase.listRecords();

        // Kitap veritabanı
        GenericDatabase<Book> bookDatabase = new GenericDatabase<>();
        bookDatabase.addRecord(new Book("Java Programlama", "Mehmet Yıldız"));
        bookDatabase.addRecord(new Book("Veri Yapıları", "Ali Demir"));

        System.out.println("\nKitap kayıtları:");
        bookDatabase.listRecords();
    }
}

