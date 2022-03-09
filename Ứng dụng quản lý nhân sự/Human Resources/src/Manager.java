import java.util.Scanner;
public class Manager extends Staff implements ICalculator {
    private String position;
    private double salaryManager;
    public Manager() {}
    public Manager(String id, String name, int age, double salaryCoefficient, String dateWork, String department, int holidays, String position) {
        super(id,name,age,salaryCoefficient,dateWork,department,holidays);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public double calculateSalary() {
        if (position.equals("Business Leader") || position.equals("business leader")) {
            salaryManager = super.calculateSalary() + bonusBusiness;
        } else if (position.equals("Project Leader") || position.equals("project leader")) {
            salaryManager = super.calculateSalary() + bonusProject;
        } else if (position.equals("Technical Leader") || position.equals("technical leader")) {
            salaryManager = super.calculateSalary() + bonusTechnical;
        }
        return salaryManager;
    }

    @Override
    public void inputInformation() {
        Scanner input = new Scanner(System.in);
        super.inputInformation();
        System.out.print("Nhập chức danh: ");
        position = input.nextLine();
    }

    @Override
    public void displayInformation() {
        System.out.println("Mã nhân viên: " + getId());
        System.out.println("Họ và tên: " + getName());
        System.out.println("Tuổi: " + getAge());
        System.out.println("Hệ số lương: " + getSalaryCoefficient());
        System.out.println("Ngày vào làm: " + getDateWork());
        System.out.println("Bộ phận làm việc: " + getDepartment());
        System.out.println("Số ngày nghỉ phép: " + getHolidays());
        System.out.println("Chức vụ: " + getPosition());
        System.out.println("Mức lương: " + calculateSalary());
    }
}
