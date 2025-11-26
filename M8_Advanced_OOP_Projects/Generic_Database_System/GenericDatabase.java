import java.util.ArrayList;
import java.util.List;

public class GenericDatabase<T> {
    private List<T> records;

    public GenericDatabase() {
        records = new ArrayList<>();
    }

    public void addRecord(T record) {
        records.add(record);
        System.out.println("Kayıt eklendi: " + record);
    }

    public void listRecords() {
        for (T record : records) {
            System.out.println(record);
        }
    }
}