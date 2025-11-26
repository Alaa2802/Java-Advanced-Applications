public class Order {
    private int orderID;
    private String customerName;
    private String orderDate;
    private double totalAmount;
    public Order(int orderID, String customerName, String orderDate, double totalAmount) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }
    public int getOrderID() {
        return orderID;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", customerName='" + customerName + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }
}