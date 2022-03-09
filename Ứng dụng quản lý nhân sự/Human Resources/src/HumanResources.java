import java.util.*;
public class HumanResources {
    public static void cacchucnang() {
        System.out.println("Hãy chọn chức năng trong số dưới đây. Nhập số từ 1 đến 8 để chọn chức năng tương ứng:");
        System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty.");
        System.out.println("2. Hiển thị các bộ phận trong công ty.");
        System.out.println("3. Hiển thị các nhân viên theo từng bộ phận.");
        System.out.println("4. Thêm nhân viên mới vào công ty.");
        System.out.println("5. Hiển thị bảng lương của nhân viên toàn công ty.");
        System.out.println("6. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần.");
        System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự giảm dần.");
        System.out.println("8. Tìm kiếm nhân viên công ty theo tên hoặc mã nhân viên.");
        System.out.print("Bạn chọn chức năng số mấy? ");
    }



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int chucnang = 0;
        ArrayList<Staff> staff = new ArrayList<>(); // biến cục bộ trong hàm main
        Staff staff1 = new Employee("001", "Nguyen Van A", 25, 1.5, "12/3/2021",
                "phong ki thuat", 6, 2.5);
        Staff staff2 = new Employee("002", "Tran Van B", 28, 1.8, "7/8/2016",
                "phong cong nghe", 4, 3);
        Staff staff3 = new Manager("003", "Le Van C", 32, 2.5, "4/6/2019",
                "phong kinh doanh", 2, "Business Leader");
        staff.add(staff1);
        staff.add(staff2);
        staff.add(staff3);
        ArrayList<Department> departments = new ArrayList<>();
        Department department1 = new Department("111", "phong ki thuat", 1);
        Department department2 = new Department("222", "phong cong nghe", 1);
        Department department3 = new Department("333", "phong kinh doanh", 1);
        departments.add(department1);
        departments.add(department2);
        departments.add(department3);
        do {
            cacchucnang();
            chucnang = input.nextInt();
            if (chucnang == 1) {
                System.out.println("Danh sách nhân viên hiện có trong công ty là:");
                for (int i = 0; i < staff.size(); i++) {
                    System.out.println((i + 1) + ".");
                    staff.get(i).displayInformation();
                }
            }
            if (chucnang == 2) {
                System.out.println("Danh sách bộ phận công ty như sau:");
                for (int i = 0; i < departments.size(); i++) {
                    System.out.println((i + 1) + ".");
                    System.out.println(departments.get(i).toString());
                }
            }
            if (chucnang == 3) {
                System.out.println("Danh sách nhân viên theo từng bộ phận là:");
                for (int i = 0; i < departments.size(); i++) {
                    System.out.println((i + 1) + ". " + departments.get(i).getName() + ":");
                    for (int j = 0; j < staff.size(); j++) {
                        int count = 0;
                        if (departments.get(i).getName().equals(staff.get(j).getDepartment())) {
                            count += 1;
                            System.out.println("Thứ " + count + ".");
                            staff.get(j).displayInformation();
                        }
                    }
                }
            }
            if (chucnang == 4) {
                System.out.println("Bạn muốn thêm nhân viên là Employee hay Manager? (e-Employee, m-Manager) ");
                String loainhanvien = input.next();
                if (loainhanvien.equals("e")) {
                    System.out.println("Nhập thông tin nhân viên mới là Employee:");
                    Staff moreStaff = new Employee();
                    moreStaff.inputInformation();
                    System.out.println("Thông tin của nhân viên mới nhập là:");
                    moreStaff.displayInformation();
                    staff.add(moreStaff);
                } else if (loainhanvien.equals("m")) {
                    System.out.println("Nhập thông tin nhân viên mới là Manager:");
                    Staff moreStaff = new Manager();
                    moreStaff.inputInformation();
                    System.out.println("Thông tin của nhân viên mới nhập là:");
                    moreStaff.displayInformation();
                    staff.add(moreStaff);
                }
            }
            if (chucnang == 5) {
                System.out.println("Hiển thị bảng lương của nhân viên toàn công ty:");
                for (int i = 0; i < staff.size(); i++) {
                    System.out.println((i + 1) + ".");
                    System.out.println("Họ và tên: " + staff.get(i).getName());
                    System.out.println("Mức lương: " + staff.get(i).calculateSalary());
                }
            }
            if (chucnang == 6) {
                System.out.println("Hiển thị bảng lương của nhân viên theo thứ tự tăng dần:");
                Collections.sort(staff, new Comparator<Staff>() {
                    @Override
                    public int compare(Staff number1, Staff number2) {
                        if (number1.calculateSalary() < number2.calculateSalary()) {
                            return -1;
                        } else {
                            if (number1.calculateSalary() == number2.calculateSalary()) {
                                return 0;
                            } else {
                                return 1;
                            }
                        }
                    }
                });
                for (int i = 0; i < staff.size(); i++) {
                    System.out.println((i + 1) + ".");
                    System.out.println("Tên: " + staff.get(i).getName());
                    System.out.println("Mức lương: " + staff.get(i).calculateSalary());
                }
            }
            if (chucnang == 7) {
                System.out.println("Hiển thị bảng lương của nhân viên theo thứ tự giảm dần:");
                Collections.sort(staff, new Comparator<Staff>() {
                    @Override
                    public int compare(Staff number1, Staff number2) {
                        if (number1.calculateSalary() < number2.calculateSalary()) {
                            return 1;
                        } else {
                            if (number1.calculateSalary() == number2.calculateSalary()) {
                                return 0;
                            } else {
                                return -1;
                            }
                        }
                    }
                });
                for (int i = 0; i < staff.size(); i++) {
                    System.out.println((i + 1) + ".");
                    System.out.println("Tên: " + staff.get(i).getName());
                    System.out.println("Mức lương: " + staff.get(i).calculateSalary());
                }
            }
            if (chucnang == 8) {
                System.out.println("Bạn muốn tìm kiếm nhân viên theo tên hay mã? (t-tên, m-mã) ");
                String timkiem = input.next();
                if (timkiem.equals("t")) {
                    System.out.println("Hãy nhập chính xác cả họ và tên nhân viên:");
                    input.nextLine();
                    String tennhanvien = input.nextLine();
                    boolean tim = true;
                    for (Staff search : staff) {
                        if (tennhanvien.equals(search.getName())) {
                            System.out.println("Tìm được kết quả như sau:");
                            search.displayInformation();
                            tim = true;
                        } else {
                            tim = false;
                        }
                    }
                        if (tim == false) {
                            System.out.println("Không tìm thấy kết quả phù hợp!");
                        }
                }
                if (timkiem.equals("m")) {
                    System.out.println("Hãy nhập chính xác mã nhân viên:");
                    String manhanvien = input.next();
                    boolean tim = true;
                    for (Staff search : staff) {
                        if (manhanvien.equals(search.getId())) {
                            System.out.println("Tìm được kết quả như sau:");
                            search.displayInformation();
                            tim = true;
                        } else {
                            tim = false;
                        }
                    }
                        if (tim == false) {
                            System.out.println("Không tìm thấy kết quả phù hợp!");
                        }
                    }
                }
            }
        while (chucnang >= 1 && chucnang <= 8);
    }
}



