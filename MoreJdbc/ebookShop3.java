package MoreJdbc;
import java.sql.*;
public class ebookShop3 {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop","root","");
                PreparedStatement pstmt= conn.prepareStatement("insert into books values (?,?,?,?,?)");
                PreparedStatement pstmtSelect = conn.prepareStatement("select * from books");
        ){
            pstmt.setInt(1,7005);
            pstmt.setString(2,"Mahjong 101");
            pstmt.setString(3,"Kumar");
            pstmt.setDouble(4,88.88);
            pstmt.setInt(5,88);
            int rowsInserted = pstmt.executeUpdate();
            System.out.println(rowsInserted + "rows affected.");
            pstmt.setInt(1,7006);
            pstmt.setString(2,"Majong102");
            //No change in values for parametters 3 to 5
            rowsInserted = pstmt.executeUpdate();
            System.out.println(rowsInserted+" rows affected.");
            //Issue a select to check the changes;
            ResultSet rest =pstmtSelect.executeQuery();
            while (rest.next()){
                System.out.println(rest.getInt("id")+","
                +rest.getString("author")+","
                +rest.getString("title")+","
                +rest.getDouble("price")+","
                +rest.getInt("qty"));
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
