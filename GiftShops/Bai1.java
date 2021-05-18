package GiftShops;
import  java.sql.*;
import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop","root","");
            Statement stmt = conn.createStatement();
            String strdeleted = "delete  from books  where id  > 8000";
            System.out.println("The sql stamenmt is:"+strdeleted+"\n");
            int countdelete= stmt.executeUpdate(strdeleted);
            System.out.println(countdelete +"record deleted");
            String sqlInsert ="insert into books values"+"(8001,'Java Cord','Dang Kim Thi',15.55,55),"+"(8002,'Jaca Advanced','James Gosling',25.55,55)";
            System.out.println("The sql stamenmt is:"+sqlInsert+"\n");
            int countInser= stmt.executeUpdate(sqlInsert);
            System.out.println(countInser +"record insert");
            System.out.println("");
           /* sqlInsert = "insert into books(id, title, author) values(2001,'Java Jdbc MySql','Thi DK')";
            System.out.println("The sql stamenmt is:"+sqlInsert+"\n");
            countInser= stmt.executeUpdate(sqlInsert);
            System.out.println(countInser +"record insert");*/

        /*    System.out.println("Enter id:");
            int id= scanner.nextInt();
            String deteletd= "delete from books where id= '"+id+"';";
            int coundetleted = stmt.executeUpdate(deteletd);
            System.out.println(coundetleted +"record deleted");*/
            //add
            System.out.println("Enter id:");
            int id1=Integer.parseInt(scanner.nextLine());
            System.out.println("Enter title:");
            String title = scanner.nextLine();
            System.out.println("Enter author");
            String author= scanner.nextLine();
            System.out.println("Enter price:");
            double price = scanner.nextDouble();
            System.out.println("Enter qty:");
            int qty = scanner.nextInt();
            String insert1 = "insert into books values ("+id1+",'"+title+"','"+author+"',"+price+","+qty+");";
            int countInsertedd = stmt.executeUpdate(insert1);
            System.out.println(countInser +"record insert");

        }
        catch (SQLException ex1){
            System.out.println(ex1);
        }
    }
}
