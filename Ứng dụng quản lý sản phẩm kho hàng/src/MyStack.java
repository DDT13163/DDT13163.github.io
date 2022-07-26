import java.util.EmptyStackException;

public class MyStack<T> {
    Node<Product> head;
    Node<Product> tail;
    public MyStack() {
        head = null;
    }

    //Hàm đẩy một phần tử vào stack
    public void push(T info) {
        Node newNode = new Node(info);
        Node oldHead = head;
        head = newNode;
        newNode.next = oldHead;
    }

    //Hàm lấy một phần tử ra khỏi stack
    public void pop() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("Stack is empty!");
        }
        head = head.next;
    }

    //Hàm trả về giá trị phần tử trên cùng của stack
    public void top() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        System.out.println(head.getInfo());
    }

    //Hàm hiển thị toàn bộ các giá trị của stack
    public String display() {
        Node currentHead = head;
        String value = "";
        while (currentHead != null) {
            value += currentHead.getInfo() + "\n";
            currentHead = currentHead.next;
        }
        return value;
    }

    //Hàm kiểm tra stack rỗng hay không
    boolean isEmpty() {
        return head == null;
    }
}

