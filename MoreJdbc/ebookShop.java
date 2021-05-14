package MoreJdbc;
import java.sql.*;
public class ebookShop {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop","root","");
                Statement stmt= conn.createStatement();
        ){
            //Step 3&4
            conn.setAutoCommit(false);
            ResultSet rest= stmt.executeQuery("select id,qty from books where id in(1001,1002)");
            while (rest.next()){
                System.out.println(rest.getInt("id")+","+rest.getInt("qty"));
            }
            conn.commit();//commit select
            //Issue two update statements thru
            stmt.executeUpdate("Update books set qty =  qty + 1 where id =1001");
            stmt.executeUpdate("Update books set qty =  qty + 1 where id =1002");
            conn.commit();//commit update
            rest = stmt.executeQuery("Select id, qty from books where id in(1001,1002)");
            System.out.println("--After update and commit--");
            while (rest.next()){
                System.out.println(rest.getInt("id")+","+rest.getInt("qty"));
            }
            conn.commit();//commit select
            //Issue two update statements thru executeUpdate
            stmt.executeUpdate("update books set qty = qty - 99 where id =1001");
            stmt.executeUpdate("update books set qty = qty - 99 where id =1002");
            conn.rollback();
            rest = stmt.executeQuery("Select id, qty from books where id in(1001,1002)");
            System.out.println("--After update and roolback--");
            while (rest.next()){
                System.out.println(rest.getInt("id")+","+rest.getInt("qty"));
            }
            conn.commit();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        }
}
