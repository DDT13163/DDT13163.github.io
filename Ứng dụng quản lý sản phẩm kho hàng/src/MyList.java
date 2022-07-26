import java.util.List;
import java.util.Scanner;

public class MyList<T> {
    Node<Product>head;
    Node<Product>tail;
    public MyList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    public MyList() {

    }

    // Hàm kiểm tra danh sách có rỗng hay không
    public boolean isEmpty() {
        return head == null;
    }

    // Hàm xác định độ dài của danh sách
    public int length() {
        int length = 0;
        Node current = this.head;
        while (current != null) {
            length++;
            current = current.getNext();
        }
        return length;
    }

    // Hàm thêm 1 phần tử vào đầu danh sách
    public void addHead(T item) {
        Node newnode = new Node(item);
        newnode.setNext(this.head);
        this.head = newnode;
    }

    //Hàm thêm 1 phần tử vào đuôi danh sách
    void addTail(T item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.next = null;
    }

    // Hàm thêm 1 phần tử vào vị trí bất kì trong danh sách
    public void insertAfterPosition(int position, T item) {
         if (position < 1) {
             System.out.println("Invalid position");
         }
         if (position == 1) {
             Node newNode = new Node(item);
             newNode.next = head;
             head = newNode;
         } else {
             while (position != 0) {
                 if (position == 1) {
                   Node newNode = new Node(item);
                   newNode.next = head.next;
                   head.next = newNode;
                   break;
                 }
                 head = head.next;
             }
             if (position != 1) {
                 System.out.print("Position out of range");
             }
         }
    }

    // Hàm hiển thị thông tin của danh sách
    public String display() {
        String result = "";
        Node current = head;
        while (current != null) {
            result += current.getInfo() + "\n";
            current = current.next;
        }
        return result;
    }

    // Hàm xóa 1 phần tử ở đầu danh sách
    public void deleteHead() {
        this.head = this.head.getNext();
    }

    // Hàm xóa 1 phần tử ở đuôi danh sách
    public void deleteTail() {
        if (this.head != null) {
            if (this.head.next == null) {
                this.head = null;
            } else {
                Node current = this.head;
                while (current.next.next != null) {
                    current = current.next;
                }
                Node tail = current.next;
                current.next = null;
                tail = null;
            }
        }
    }

    //Hàm xóa 1 phần tử ở vị trí bất kì trong danh sách
    public void deleteElement(int position) {
          if (head == null) {
              return;
          }
          Node current = head;
          if (position == 0) {
              head = current.next;
              return;
          }
          for (int i = 0; current != null && i < position - 1; i++) {
              current = current.next;
          }
          if (current == null || current.next == null) {
              return;
          }
          Node nextNode = current.next.next;
          current.next = nextNode;
    }
}

