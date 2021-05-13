package PhpSql;
import java.sql.*;
public class ebookShop {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop","root","");
                Statement stmt= conn.createStatement();
        ){
            String strSelect = "select id, author, title, price, qty from books";
            System.out.println("The SQl statemetnt is:"+strSelect+"\n");
            ResultSet rest = stmt.executeQuery(strSelect);

            System.out.println("The records selected are:");
            int rowCount=0;
            while (rest.next()){
                int id = rest.getInt("id");
                String author = rest.getString("author");
                String title = rest.getString("title");
                double price = rest.getDouble("price");
                int qty= rest.getInt("qty");
                System.out.println(id+","+author+","+title+","+price+","+qty);
                ++rowCount;
                if (author=="Dang Kim Thi"){
                    System.out.println(title+","+price);
                }
            }
            System.out.println("Total number of records = "+rowCount);
            System.out.println("");
            //bai1
            String strSelect2= "select title,price from books where author = 'Dang Kim Thi' ";
            System.out.println("The SQL stament is:"+strSelect2+"\n");
            ResultSet rest2 =stmt.executeQuery(strSelect2);
            int rowCount1=0;
            while (rest2.next()){
                String title = rest2.getString("title");
                double price = rest2.getDouble("price");
                System.out.println(title+","+price);
                ++rowCount1;
            }
            //y 3
            String strSelect3="select title, author, price, qty from books where author='Dang Kim Thi' or price>=30 order by price DESC, id ASC";
            System.out.println("The SQL stament is:"+strSelect3);
            ResultSet rest3=stmt.executeQuery(strSelect3);
            int rowCount2=0;
            while (rest3.next()){
                String author = rest3.getString("author");
                String title = rest3.getString("title");
                double price = rest3.getDouble("price");
                int qty= rest3.getInt("qty");
                System.out.println(author+","+title+","+price+","+qty);
                ++rowCount2;
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        }
}
