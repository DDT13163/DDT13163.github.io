import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    //Phương thức hiển thị bảng chức năng
    public static void showMenu() {
        System.out.println("Choose one of this option:");
        System.out.println("Product list:");
        System.out.println("1. Load data from file and display");
        System.out.println("2. Input & add to the end.");
        System.out.println("3. Display data");
        System.out.println("4. Save product list to file.");
        System.out.println("5. Search by ID");
        System.out.println("6. Delete by ID");
        System.out.println("7. Sort by ID");
        System.out.println("8. Convert to Binary");
        System.out.println("9. Load to stack and display");
        System.out.println("10. Load to queue and display");
        System.out.println("0. Exit");
    }

    public static void main(String[] args) {
        OperationToProduct t = new OperationToProduct();
        MyList<String>newList = new MyList<>();
        MyStack<String>newStack = new MyStack<>();
        MyQueue<String>newQueue = new MyQueue<>();
        int input = 0;
        do {
            showMenu();
            Scanner in = new Scanner(System.in);
            System.out.print("Ban chon chuc nang so may? ");
            try {
                input = in.nextInt();
                switch (input) {
                    case 1:
                        t.getAllItemsFromFile("data", newList);
                        break;
                    case 2:
                        t.addLast(newList);
                        break;
                    case 3:
                        t.displayAll(newList);
                        break;
                    case 4:
                        t.writeAllItemsToFile("data1", newList);
                        break;
                    case 5:
                        System.out.println(t.searchByCode(newList));
                        break;
                    case 6:
                        t.deleteByCode(newList);
                        break;
                    case 7:
                        t.sortByCode(newList);
                        break;
                    case 8:
                        System.out.println(t.convertToBinary(newList));
                        break;
                    case 9:
                        t.getAllItemsFromFile("data1",newStack);
                        break;
                    case 10:
                        t.getAllItemsFromFile("data1",newQueue);
                        break;
                    default:
                        System.out.println("Thank for using!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Wrong input data! Please input again!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            if (input < 0 || input > 10) {
               System.out.println("Wrong input data! Please input again!");
            }
        } while (input != 0);
    }
}
