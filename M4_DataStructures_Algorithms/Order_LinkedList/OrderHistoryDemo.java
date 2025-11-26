import java.util.Scanner;

public class OrderHistoryDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderHistory orderHistory = new OrderHistory();

        while (true) {
            System.out.println("1. Yeni sipariş ekle");
            System.out.println("2. Siparişi kaldır");
            System.out.println("3. Sipariş geçmişini görüntüle");
            System.out.println("4. Toplam satışları hesapla");
            System.out.println("5. Çıkış");
            System.out.print("Seçiminizi yapın: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Satır sonu karakterini temizle

            switch (choice) {
                case 1:
                    System.out.print("Sipariş ID: ");
                    int orderID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Müşteri Adı: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Sipariş Tarihi: ");
                    String orderDate = scanner.nextLine();
                    System.out.print("Toplam Tutar: ");
                    double totalAmount = scanner.nextDouble();
                    Order newOrder = new Order(orderID, customerName, orderDate, totalAmount);
                    orderHistory.addOrder(newOrder);
                    break;
                case 2:
                    System.out.print("Kaldırılacak Sipariş ID: ");
                    int removeID = scanner.nextInt();
                    orderHistory.removeOrder(removeID);
                    break;
                case 3:
                    orderHistory.displayOrderHistory();
                    break;
                case 4:
                    double totalSales = orderHistory.calculateTotalSales();
                    System.out.println("Toplam Satışlar: " + totalSales);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }
}