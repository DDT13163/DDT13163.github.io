public class MyQueue<T> {
    Node<Product>head;
    Node<Product>tail;
    public MyQueue() {
       head = tail = null;
    }

    //Hàm kiểm tra Queue có rỗng hay không
    public boolean isEmpty() {
        return head == null;
    }

    //Hàm trả về phần tử ở đằng trước Queue
    public void front() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        System.out.println(head.info);
    }

    //Hàm xóa phần tử từ Queue (mặc định sẽ xóa từ đằng trước)
    public void deQueue() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        head = head.next;
        if (head == null) tail = null;
    }

    //Hàm thêm phần tử vào Queue (mặc định sẽ thêm vào đằng sau)
    public void enQueue(T info) {
        if (isEmpty()) {
            head = tail = new Node(info);
        } else {
            tail.next = new Node(info);
            tail = tail.next;
        }
    }

    //Hàm hiển thị toàn bộ giá trị của Queue
    public String display() {
        Node currentHead = head;
        String value = "";
        while (currentHead != null) {
            value += currentHead.getInfo() + "\n";
            currentHead = currentHead.next;
        }
        return value;
    }
}
