public class OrderHistory {
    private OrderNode head;

    public void addOrder(Order order) {
        OrderNode newNode = new OrderNode(order);
        if (head == null) {
            head = newNode;
        } else {
            OrderNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public  void removeOrder(int orderID) {
        if (head == null)
            return ;
        if (head.order.getOrderID() == orderID) {
            head = head.next;
            return;
        }
        OrderNode current = head;
        while (current.next != null && current.next.order.getOrderID() != orderID) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void displayOrderHistory() {
        OrderNode current = head;
        while (current != null) {
            System.out.println(current.order);
            current = current.next;
        }
    }

    public double calculateTotalSales() {
        double total = 0;
        OrderNode current = head;
        while (current != null) {
            total += current.order.getTotalAmount();
            current = current.next;
        }
        return total;
    }
}