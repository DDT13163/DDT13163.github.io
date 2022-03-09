import java.util.Scanner;
public class Department {
    private String id, name;
    private int numberStaff;
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

    @Override
    public String toString() {
        return "Mã bộ phận: " + this.id + ". Tên bộ phận: " + this.name + ". Số lượng nhân viên trong bộ phận là: " + this.numberStaff;
    }
}
