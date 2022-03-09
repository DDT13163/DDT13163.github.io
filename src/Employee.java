import java.util.Scanner;
public class Employee extends Staff implements ICalculator {
    private double overtime;
    public Employee() {}
    public Employee(String id, String name, int age, double salaryCoefficient, String dateWork, String department, int holidays, double overtime) {
        super(id,name,age,salaryCoefficient,dateWork,department,holidays);
        this.overtime = overtime;
    }

    public double getOvertime() {
        return overtime;
    }

    public void setOvertime(double overtime) {
        this.overtime = overtime;
    }

    @Override
    public double calculateSalary() {
        return super.calculateSalary() + overtime * 200000;
    }

    @Override
    public void inputInformation() {
        Scanner input = new Scanner(System.in);
        super.inputInformation();
        System.out.print("Nhập số giờ làm thêm: ");
        overtime = input.nextDouble();
    }

    @Override
    public void displayInformation() {
        System.out.println("Mã nhân viên: " + id); // get, set chỉ dùng bên ngoài
        System.out.println("Họ và tên: " + getName());
        System.out.println("Tuổi: " + getAge());
        System.out.println("Hệ số lương: " + getSalaryCoefficient());
        System.out.println("Ngày vào làm: " + getDateWork());
        System.out.println("Bộ phận làm việc: " + getDepartment());
        System.out.println("Số ngày nghỉ phép: " + getHolidays());
        System.out.println("Số giờ làm thêm: " + getOvertime());
        System.out.println("Mức lương: " + calculateSalary());
    }
}
