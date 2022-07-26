import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class OperationToProduct {
    Product p;
    MyList<Product> list;

    //Phương thức đọc dữ liệu từ file có sẵn và lưu vào linkedlist rồi hiển thị linkedlist ra màn hình
    public void getAllItemsFromFile(String filename, MyList<String> list) {
        try {
            File file = new File(filename);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                list.addTail(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured!");
            e.printStackTrace();
        }
        System.out.println(list.display());
    }

    //Phương thức lưu dữ liệu từ file vào stack và hiển thị stack ra màn hình
    public void getAllItemsFromFile(String filename, MyStack<String> stack) {
        try {
            File file = new File(filename);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                stack.push(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured!");
            e.printStackTrace();
        }
        System.out.println(stack.display());
    }

    //Phương thức lưu dữ liệu từ file vào queue và hiển thị queue ra màn hình
    public void getAllItemsFromFile(String filename, MyQueue<String> queue) {
        try {
            File file = new File(filename);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                queue.enQueue(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured!");
            e.printStackTrace();
        }
        System.out.println(queue.display());
    }

    //Phương thức thêm phần tử vào linkedlist
    public void addLast(MyList<String> list) {
        Scanner sc = new Scanner(System.in);
        System.out.print("input Product's id: ");
        String id = sc.next();
        System.out.print("input Product's title: ");
        String title = sc.next();
        System.out.print("input Product's quantity: ");
        int quantity = sc.nextInt();
        System.out.print("input Product's price: ");
        double price = sc.nextDouble();
        Product newProduct = new Product(id, title, quantity, price);
        list.addTail(newProduct.toString());
    }

    //Phương thức hiển thị thông tin các sản phẩm trong linkedlist
    public void displayAll(MyList<String> list) {
        System.out.println(list.display());
    }

    //Phương thức lưu thông tin trong linkedlist vào file
    public void writeAllItemsToFile(String fileName, MyList<String> list) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(list.display());
            fileWriter.close();
            System.out.println("Successfully wrote to the file!");
        } catch (IOException e) {
            System.out.println("An error occurred!");
            e.printStackTrace();
        }
    }

    //Phương thức tìm kiếm thông tin sản phẩm trong linkedlist theo id
    public String searchByCode(MyList<String> list) {
        list = new MyList<>(list.head, list.tail);
        Node current = list.head;
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the id to search = ");
        String idSearch = sc.next();
        while (current != null) {
            if (current.getInfo().toString().contains(idSearch)) {
                return current.getInfo().toString();
            }
            current = current.next;
        }
        return "Nothing found!";
    }

    //Phương thức xóa phần tử trong linkedlist
    public void deleteByCode(MyList<String> list) {
        list = new MyList<>(list.head, list.tail);
        Node current = list.head;
        Scanner sc = new Scanner(System.in);
        System.out.print("Input id to delete = ");
        String idDelete = sc.next();
        int positionDelete = 0;
        int count = 0;
        while (current != null) {
            if (current.getInfo().toString().contains(idDelete)) {
                list.deleteElement(positionDelete);
                System.out.println("Deleted successfully!");
                count++;
            }
            positionDelete++;
            current = current.next;
        }
        if (count == 0) {
            System.out.println("Nothing delete!");
        }
    }

    //Phương thức sắp xếp các phần tử trong linkedlist theo id
    public void sortByCode(MyList<String> list) {
        Node current = list.head;
        Node currentPos1 = current.next;
        Node currentPos2 = currentPos1.next;
        int count = 0;
        while (currentPos2 != null) {
            Node next = currentPos2.next;
            while (next != null) {
                if (currentPos2.info.toString().compareTo(next.info.toString()) > 0) {
                    var temp = currentPos2.info;
                    currentPos2.info = next.info;
                    next.info = temp;
                    count++;
                }
                next = next.getNext();
            }
            currentPos2 = currentPos2.getNext();
        }
        if (count != 0) {
            System.out.println("Sort by id successfully!");
        }
    }

    //Phương thức chuyển đổi 1 số từ hệ đếm cơ số 10 ra hệ đếm nhị phân
    public int decimalTobinary(int decimal) {
        if (decimal == 0) {
            return 0;
        } else {
            return (decimal % 2 + 10 * decimalTobinary(decimal / 2));
        }
    }

    //Phương thức chuyển đổi số lượng sản phẩm (đang ở cơ số 10) của phần tử đầu tiên trong linkedlist ra hệ đếm nhị phân
    public int convertToBinary(MyList<String> list) {
        list = new MyList<>(list.head, list.tail);
        Node current = list.head;
        Node currentPos1 = current.next;
        Node currentPos2 = currentPos1.next;
        String newString = currentPos2.info.toString().substring(5, 25);
        char[] chars = newString.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        int valueToconvert = Integer.parseInt(sb.toString());
        return decimalTobinary(valueToconvert);
    }
}
