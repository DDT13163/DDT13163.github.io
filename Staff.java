import java.util.Scanner;
public abstract class Staff implements ICalculator{
   private int age, holidays;
   private String id, name, department, dateWork;
   private double salaryCoefficient;

   public Staff() {
   }

   public Staff(String id, String name, int age, double salaryCoefficient, String dateWork, String department, int holidays) {
      this.id = id;
      this.name = name;
      this.age = age;
      this.salaryCoefficient = salaryCoefficient;
      this.dateWork = dateWork;
      this.department = department;
      this.holidays = holidays;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public double getSalaryCoefficient() {
      return salaryCoefficient;
   }

   public void setSalaryCoefficient(double salaryCoefficient) {
      this.salaryCoefficient = salaryCoefficient;
   }

   public String getDateWork() {
      return dateWork;
   }

   public void setDateWork(String dateWork) {
      this.dateWork = dateWork;
   }

   public String getDepartment() {
      return department;
   }

   public void setDepartment(String department) {
      this.department = department;
   }

   public int getHolidays() {
      return holidays;
   }

   public void setHolidays(int holidays) {
      this.holidays = holidays;
   }

   public abstract void displayInformation();

   public void inputInformation() {
      Scanner input = new Scanner(System.in);
      System.out.print("Nhập mã nhân viên: ");
      id = input.next();
      input.nextLine();
      System.out.print("Nhập họ tên nhân viên: ");
      name = input.nextLine();
      System.out.print("Nhập tuổi nhân viên: ");
      age = input.nextInt();
      System.out.print("Nhập hệ số lương: ");
      salaryCoefficient = input.nextDouble();
      System.out.print("Nhập ngày vào làm: ");
      dateWork = input.next();
      input.nextLine();
      System.out.print("Nhập bộ phận làm việc: ");
      department = input.nextLine();
      System.out.print("Nhập số ngày nghỉ phép: ");
      holidays = input.nextInt();
   };

   @Override
   public double calculateSalary() {
      return 3000000 * salaryCoefficient;
   }
}
