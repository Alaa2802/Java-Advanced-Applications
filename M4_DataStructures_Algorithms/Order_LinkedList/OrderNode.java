public class OrderNode {
    Order order;
    OrderNode next;
    public OrderNode(Order order) {
        this.order = order;
        this.next = null;
    }
}