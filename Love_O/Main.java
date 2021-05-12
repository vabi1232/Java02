package Love_O;
import java.util.Scanner;

public class Main {
    private static Scanner scanner= new Scanner(System.in);
    private static LoveOldList loveoldlist = new LoveOldList("Wonder woman");

    public static void main(String[] args) {
        boolean huhu = false;
        runLoveOld();
        printActions();
        while (!huhu){
            System.out.println("\nNhập 6 hành động đã hiện thị ở trên!");
            int run= scanner.nextInt();
            scanner.nextLine();
            switch (run){
                case 1:
                    loveoldlist.printLoveOlds();
                    break;
                case 2:
                    addNewOldLove();
                    break;
                case 3:
                    updateLoveOld();
                    break;
                case 4:
                    removeLoveOld();
                    break;
                case 5:
                    queryLoveOld();
                    break;
                case 6:
                    System.out.println("Chào các tình cũ anh đi tìm tình yêu mới đây hihi:))");
                    huhu=true;
                    break;
            }
        }
    }
    private static void addNewOldLove(){
        System.out.println("Nhập tên tình cũ:");
        String name= scanner.nextLine();
        System.out.println("Nhập tính cách tình cũ:");
        String character= scanner.nextLine();
        LoveOld newLoveOld = LoveOld.createOldLove(name,character);
        if (loveoldlist.addNewOldLove(newLoveOld)){
            System.out.println("Đã tên tình cũ mới = "+name+", character = "+character);
        }else{
            System.out.println("Không thể thêm "+name+"đã có trong danh sách");
        }
    }
    private static void updateLoveOld(){
        System.out.println("Nhập tên tình cũ hiện có:");
        String name = scanner.nextLine();
        LoveOld existingLoveOld = loveoldlist.queryLoveOld(name);
        if (existingLoveOld ==  null){
            System.out.println("Không tìm thấy tình cũ");
            return;
        }
        System.out.println("Nhập tên tình cũ mới:");
        String newName= scanner.nextLine();
        System.out.println("Nhập tích cách tình cũ:");
        String newCharacter = scanner.nextLine();
        LoveOld newLoveOld = LoveOld.createOldLove(newName,newCharacter);
        if (loveoldlist.updateLoveOld(existingLoveOld,newLoveOld)){
            System.out.println("Đã cập nhập thành công bản ghi");
        }else {
            System.out.println("Nhập bản ghi");
        }
    }
    private static void removeLoveOld(){
        System.out.println("Nhập tên tình cũ hiện tại ");
        String name= scanner.nextLine();
        System.out.println("Nhập tính cách tình cũ hiện tại.");
        String character = scanner.nextLine();
        LoveOld existingLoveOld = loveoldlist.queryLoveOld(name);
        if (existingLoveOld==null){
            System.out.println("Love old not found");
            return;
        }
        if (loveoldlist.removeLoveOld(existingLoveOld)){
            System.out.println("Đã xóa thành công tình cũ");
        }else{
            System.out.println("Nhập dữ liệu để xóa tình cũ");
        }
    }
    private static void queryLoveOld(){
        System.out.println("Nhập tên tình cũ hiện tại ");
        String name= scanner.nextLine();
        System.out.println("Nhập tính cách tình cũ hiện tại.");
        String character = scanner.nextLine();
        LoveOld existingLoveOld = loveoldlist.queryLoveOld(name);
        if (existingLoveOld==null){
            System.out.println("Love old not found");
            return;
        }
        System.out.println("Name:"+existingLoveOld.getName()+", Character is"+existingLoveOld.getCharacter());
    }
    private static void runLoveOld(){
        System.out.println("Đây là danh sách tình cũ huhu buồn nhỉ hihi");
    }
    private static void printActions(){
        System.out.println("\nMời bạn chọn hành động: \nNhấn");
        System.out.println("1 - In ra danh sách tình cũ: \n" +
                "2 - Thêm tình cũ\n" +
                "3 - Cập nhập tình cũ\n" +
                "4 - Xóa tình cũ\n" +
                "5 - In danh sách các hành động có sẵn\n" +
                "6 - Byee");
        System.out.println("Chosse your action:");
    }
}
