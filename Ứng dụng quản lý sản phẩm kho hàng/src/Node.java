public class Node<T> {
   T info;
   Node next;
   public Node(T info) {
       this.info = info;
   }
   public Node(T info, Node next) {
       this.info = info;
       this.next = next;
   }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String toString() {
       return info + "";
   }
}
