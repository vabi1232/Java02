package Java02;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class MoveList {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        List<String> name=new ArrayList<>();
        name.add("Superman");
        name.add("Batman");
        name.add("Spiderman");
        name.add("Loki & Thor");
        name.add("Wonder woman");
        int a=0;
        do {
            System.out.println("===================");
            System.out.println("1.Thêm một bộ phim mới:");
            System.out.println("2.Chỉnh sửa tên phim đã có:");
            System.out.println("3.Xóa đi một bộ phim khỏi danh sách yêu thích:");
            System.out.println("4.Tìm kiếm tên phim trong danh sách yêu thích:");
            System.out.println("5.In ra danh sách các bộ phim yêu thích");
            System.out.println("6.Kết thúc.");
            System.out.println("====================");
            System.out.println("Mời bạn chọn :");
             a = scan.nextInt();
            switch (a){
                case 1:
                    System.out.println("Mời bạn nhập tên phimn: ");
                    String mv = scan.next();
                    name.add(mv);
                    System.out.println("Tên phim bạn mới thêm vào là: "+name);
                    break;
                case 2:
                    System.out.println("Nhập vị trí tên phim bạn muốn thay đổi:");
                    int tr=scan.nextInt();
                    System.out.println("Nhập tên phim mới:");
                    String new_Movie= scan.next();
                    name.set(tr,new_Movie);
                    System.out.println("Tên phim mới được thay đổi là "+new_Movie);
                    System.out.println(name);
                    break;
                case 3:
                    System.out.println("Nhập vị trí tên phim bạn muốn xóa:");
                    int re_mv=scan.nextInt();
                    name.remove(re_mv);
                    System.out.println("Tên phim đã được xóa.");
                    System.out.println(name);
                    break;
                case 4:
                    System.out.println("Nhập tên phim bạn muốn tìm kiếm :");
                    String se_mv= scan.next();
                    System.out.println("Vị trí của phim "+se_mv+"là: "+name.indexOf(se_mv));
                    break;
                case 5:
                    name.forEach(names->{
                        System.out.println(names);
                    });
                    break;
            }

        }while (a==6);
        System.out.println("Kết thúc!!");
    }
}
