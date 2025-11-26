import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DosyaIslemleri {
    public ArrayList<Sehir> oku(String yol) {
        ArrayList<Sehir> liste = new ArrayList<>();
        try {BufferedReader br = new BufferedReader(new FileReader(yol));
            String hat;
            boolean veriBasladi = false;
            while ((hat = br.readLine()) != null) {
                if (hat.contains("NODE_COORD_SECTION")) {
                    veriBasladi = true;
                    continue;}
                if (hat.contains("EOF")) break;
                if (veriBasladi) {String[] parca = hat.trim().split("\\s+");
                    if (parca.length >= 3) {
                        try {int id = Integer.parseInt(parca[0]);
                            double k1 = Double.parseDouble(parca[1]);
                            double k2 = Double.parseDouble(parca[2]);
                            liste.add(new Sehir(id, k1, k2));}
                        catch (Exception e) {
                        }
                    }
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Dosya hatasi: " + e.getMessage());
        }
        return liste;
    }
}