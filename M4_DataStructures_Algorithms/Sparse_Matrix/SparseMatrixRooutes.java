public class SparseMatrixRooutes {
    private Node head;

    public SparseMatrixRooutes() {
        this.head = null;
    }

    public void addRoute(int source, int destination, int time) {
        Node newNode = new Node(source, destination, time);
        if (this.head == null) {
            this.head = newNode;
            return;
        }
        Node current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void removeRoute(int source, int destination) {
        if (this.head == null) {
            head = head.next;
            return;
        }
        Node temp = this.head;
        Node pre = null;
        while (temp != null) {
            if (temp.source == source && temp.destination == destination) {
                pre.next = temp.next;
                return;
            }
            pre = temp;
            temp = temp.next;
        }
    }

    public int getRoute(int source, int destination) {
        Node temp = this.head;
        while (temp != null) {
            if (temp.source == source && temp.destination == destination) {
                return temp.time;

            }
            temp = temp.next;
        }
        return -1;
    }

    public SparseMatrixRooutes transpose() {
        SparseMatrixRooutes transposed = new SparseMatrixRooutes();
        Node temp = this.head;
        while (temp != null) {
            transposed.addRoute(temp.destination, temp.source, temp.time);
            temp = temp.next;
        }
        return transposed;
    }

    public void PrintAllRoutes() {
        Node current = this.head;
        while (current != null) {
            System.out.println(current.source + " -> " + current.destination + " -> " + current.time);
            current = current.next;

        }
        System.out.println();
    }

    public SparseMatrixRooutes multiply(SparseMatrixRooutes other) {
        SparseMatrixRooutes result = new SparseMatrixRooutes();
        Node currentThis = this.head;
        while (currentThis != null) {
            Node currentOther = other.head;
            while (currentThis != null) {
                currentOther = other.head;
                while (currentOther != null) {
                    if (currentThis.destination == currentOther.source) {
                        int totalTime = currentThis.time + currentOther.time;
                        int existingTime = result.getRoute(currentThis.source, currentOther.destination);
                        if (existingTime == -1 || totalTime < existingTime) {
                            if (existingTime != -1) {
                                result.removeRoute(currentThis.source, currentOther.destination);
                            }
                            result.addRoute(currentThis.source, currentOther.destination, totalTime);
                        }
                    }
                    currentOther = currentOther.next;
                }
                currentThis = currentThis.next;
            }

            return result;
        }
        return result;
    }
    public class Node {
        int source;
        int destination;
        int time;
        Node next;
        public Node(int source, int destination, int time) {
            this.source = source;
            this.destination = destination;
            this.time = time;
            this.next =null;
        }

    }
}