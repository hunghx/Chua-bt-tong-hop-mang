import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[][] employees = new String[100][7];
        int size = 0;// số luong nhân vien ban dau = 0
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // hiển thị menu
            System.out.println("\n" +
                    "*********************MENU********************** \n" +
                    "1.\tThêm mới 1 nhân viên \n" +
                    "2.\tHiển thị danh sách thông tin nhân viên \n" +
                    "3.\tXem thông tin nhân viên theo mã nhân viên\n" +
                    "4.\tCập nhật thông tin nhân viên\n" +
                    "5.\tXóa nhân viên\n" +
                    "6.\tTìm kiếm nhân viên theo tên (tương đối)\n" +
                    "7.\tSắp xếp và hiển thị danh sách nhân viên theo tên từ a - z\n" +
                    "8.\tThoát\n");
            // yêu ầu nhập vào
            System.out.println("nhạp chưc năng");
            byte choice = Byte.parseByte(scanner.nextLine());
            switch (choice) {
                case 1:
                    // thêm mới
                    if (size >= 100) {
                        // mảng đầy
                        System.err.println("so luong nhân vien da đầy, không thể thêm nữa");
                    } else {
                        // mảng chưa đầy
                        // yêu cầu nhập thông tin và them vao cuối mảng (vi trí thứ size)
                        System.out.println("Nhap mã nhan vien");
                        String id = scanner.nextLine();
                        System.out.println("Nhap tên nhan vien");
                        String name = scanner.nextLine();
                        System.out.println("Nhap ngày sinh (dd/MM/yyyy)");
                        String date = scanner.nextLine();
                        System.out.println("Nhap ịa chỉ");
                        String address = scanner.nextLine();
                        System.out.println("Nhap so điện thoại");
                        String phone = scanner.nextLine();
                        System.out.println("Nhap luong cơ bản");
                        String salary = scanner.nextLine();
                        System.out.println("Nhap so hệ số");
                        String rate = scanner.nextLine();
                        // tạo mới employee
                        String[] newEmployee = new String[]{id, name, date, address, phone, salary, rate}; // tạo mới mảng
                        employees[size] = newEmployee;
                        size++; // tăng số lương nhân viên lên 1
                    }
                    break;
                case 2:
                    if (size == 0) {
                        // mảng đầy
                        System.err.println("danh sách rỗng");
                    } else {
                        for (int i = 0; i < size; i++) {
                            // mỗi một phần tử là 1 nhân viên
                            System.out.printf("Mã NV : %-3s | Tên NV : %-10s | Ngày sinh : %-10s | Địa chỉ : %-10s | SDT : %-11s | Lương CB : %-10s | Hệ số : %-3s \n"
                                    , employees[i][0], employees[i][1], employees[i][2], employees[i][3], employees[i][4], employees[i][5], employees[i][6]);
                        }
                    }
                    break;
                case 3:
                    // xem thông tin nhân viên theo mã
                    System.out.println("Hãy nhap ma nhan vien cân tim");
                    String idEmployee = scanner.nextLine();
                    boolean flag = false; // cắm cờ
                    // duyệt mảng
                    for (int i = 0; i < size; i++) {
                        if (employees[i][0].equals(idEmployee)) { // so sánh bằng
                            // hiển thị thông tin
                            System.out.printf("Mã NV : %-3s | Tên NV : %-10s | Ngày sinh : %-10s | Địa chỉ : %-10s | SDT : %-11s | Lương CB : %-10s | Hệ số : %-3s \n"
                                    , employees[i][0], employees[i][1], employees[i][2], employees[i][3], employees[i][4], employees[i][5], employees[i][6]);
                            flag = true; // cờ đảo chiều
                            break;
                        }
                    }

                    if (!flag) {
                        System.err.println("khong có nhan vien nao phu hop");
                    }
                    break;
                case 4:
                    System.out.println("Hãy nhap ma nhan vien cân cap nhat thong tin");
                    String idEdit = scanner.nextLine();
                    boolean flagFind = false; // cắm cờ
                    // duyệt mảng
                    for (int i = 0; i < size; i++) {
                        if (employees[i][0].equals(idEdit)) { // so sánh bằng
                            // hiển thị thông tin cũ
                            System.out.println("thong tin cũ của nhân viên");
                            System.out.printf("Mã NV : %-3s | Tên NV : %-10s | Ngày sinh : %-10s | Địa chỉ : %-10s | SDT : %-11s | Lương CB : %-10s | Hệ số : %-3s \n"
                                    , employees[i][0], employees[i][1], employees[i][2], employees[i][3], employees[i][4], employees[i][5], employees[i][6]);
                            System.out.println("Nhạp thong tin mới");
                            System.out.println("Nhap tên nhan vien");
                            employees[i][1] = scanner.nextLine();
                            System.out.println("Nhap ngày sinh (dd/MM/yyyy)");
                            employees[i][2] = scanner.nextLine();
                            System.out.println("Nhap ịa chỉ");
                            employees[i][3] = scanner.nextLine();
                            System.out.println("Nhap so điện thoại");
                            employees[i][4] = scanner.nextLine();
                            System.out.println("Nhap luong cơ bản");
                            employees[i][5] = scanner.nextLine();
                            System.out.println("Nhap so hệ số");
                            employees[i][6] = scanner.nextLine();
                            System.out.println("cập nhật thành công");
                            flagFind = true; // cờ đảo chiều
                            break;
                        }
                    }
                    if (!flagFind) {
                        System.err.println("khong có nhan vien nao phu hop");
                    }
                    break;
                case 5:
                    System.out.println("Hãy nhap ma nhan vien cân xóa");
                    String idDelete = scanner.nextLine();
                    int indexDelete = -1; // vị trí cần xóa
                    // duyệt mảng lâ ra vị trí càn xóa
                    for (int i = 0; i < size; i++) {
                        if (employees[i][0].equals(idDelete)) { // so sánh bằng
                            // hiển thị thông tin cũ
                            indexDelete = i;
                            break;
                        }
                    }
                    if (indexDelete == -1) {
                        // không tìm thấy
                        System.err.println("khong có nhan vien nao phu hop");
                    }else {
                        // tìm thấy

                        //dịch chuyển các ptu bên tay phải vị trí cần xóa sang trái 1 đơn vị
                        for (int i = indexDelete; i < size - 1; i++) {
                            employees[i] = employees[i + 1];
                        }

                        // cập nhật giá trị cuối cùng ve mang các giá trị null (ko cần thiết)
                        employees[size - 1] = new String[7];

                        size--;
                    }
                    break;
                case 6:
                    //  tìm kiếm tương đối
                    System.out.println("Hãy nhap tên nhan vien cân tim");
                    String name = scanner.nextLine();
                    boolean check = false;
                    // duyet mang de tim kiem
                    for (int i = 0; i < size; i++) {
                        if (employees[i][1].toLowerCase().contains(name.toLowerCase())) { // tim kiem tuong doi ko phan biet hoa thuong
                            // hiển thị thông tin cũ
                            System.out.printf("Mã NV : %-3s | Tên NV : %-10s | Ngày sinh : %-10s | Địa chỉ : %-10s | SDT : %-11s | Lương CB : %-10s | Hệ số : %-3s \n"
                                    , employees[i][0], employees[i][1], employees[i][2], employees[i][3], employees[i][4], employees[i][5], employees[i][6]);
                            check = true;
                        }
                    }
                    if (!check){
                        System.err.println("khong có nhan vien nao trung khop");
                    }
                    break;
                case 7:
                    for (int i = 0; i < size -1 ; i++) {
                        for (int j = i+1; j < size ; j++) {
                            if (employees[i][1].compareTo(employees[j][1])>0){
//                                đô vị trí 2 ptu
                                String[] temp = employees[i];
                                employees[i] = employees[j];
                                employees[j] = temp;
                            }
                        }
                    }
                    System.out.println("Đã sắp");
                    break;
                case 8:
                    System.out.println("Thoat chuong trinh");
                    return; // dừng hàm main
                default:
                    System.err.println("nhap khong hop le, nhap lai");
            }
        }

    }
}