import java.util.Scanner;
public class Department {
    private String id, name;
    private int numberStaff;
    public Department() {}
    public Department(String id, String name, int numberStaff) {
        this.id = id;
        this.name = name;
        this.numberStaff = numberStaff;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getNumberStaff() {
        return numberStaff;
    }
    public void setNumberStaff(int numberStaff) {
        this.numberStaff = numberStaff;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    /*
    public void display() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập mã bộ phận: ");
        id = input.nextInt();
        input.nextLine();
        System.out.print("Nhập tên bộ phận: ");
        name = input.nextLine();
        System.out.print("Nhập số lượng nhân viên trong bộ phận: ");
        numberStaff = input.nextInt();
    }

     */
    @Override
    public String toString() {
        return "Mã bộ phận: " + this.id + ". Tên bộ phận: " + this.name + ". Số lượng nhân viên trong bộ phận là: " + this.numberStaff;
    }
}
