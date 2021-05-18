package GiftShops.giftmodel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import GiftShops.giftcontroller.Gift;
import GiftShops.giftmodel.*;

public class GiftController {
    String url = "jdbc:mysql://localhost:3306/gift";
    String username = "root";
    String password = "";
    List<Gift>GiftList= new ArrayList<>();
    public List<Gift>loading(){
        try {
            Connection conn= DriverManager.getConnection(url,username,password);
            Statement stmt = conn.createStatement();
            {
                String select = "Select * from giftshop";
                ResultSet rest = stmt.executeQuery(select);
                while (rest.next()){
                    int id= rest.getInt("id");
                    int qty=rest.getInt("qty");
                    double price= rest.getDouble("price");
                    String name =rest.getString("name");
                    Gift obj=new Gift(id, qty, price, name);
                    GiftList.add(obj);
                }
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return GiftList;
    }
    public boolean insertGift(Gift gift){
        try {
            Connection conn= DriverManager.getConnection(url,username,password);
            Statement stmt = conn.createStatement();
            {
               PreparedStatement ptsmt=conn.prepareStatement("insert into giftshop (id, qty, price, name) values (?,?,?,?)");
               ptsmt.setInt(1,gift.getId());
               ptsmt.setInt(2,gift.getQty());
               ptsmt.setDouble(3,gift.getPrice());
               ptsmt.setString(4,gift.getName());
               int rowsInserted = ptsmt.executeUpdate();
                System.out.println(rowsInserted+"rows affected");
                loading();
                return true;
            }
        }catch (SQLException ex){
           ex.printStackTrace();
           return false;
        }
    }
    public boolean deleteGift(Gift gift){
        try {
            Connection conn= DriverManager.getConnection(url,username,password);
            Statement stmt = conn.createStatement();
            {
                String select = "select * from giftshop ";
                ResultSet rest= stmt.executeQuery(select);
                if (!rest.next()){

                    System.out.println("Cannot delete/No gift found");
                    return false;
                }else{
                    String delete = "delete from giftshop where id ="+gift.getId();
                    stmt.executeUpdate(delete);
                    loading();
                    System.out.println("Gift has been deleted");
                    return true;
                }

            }
        }catch (SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
    public void displayGift(){
        try {
            Connection conn= DriverManager.getConnection(url,username,password);
            Statement stmt = conn.createStatement();
            {
                String stt= "select * from giftshop";
                ResultSet rest = stmt.executeQuery(stt);
                ResultSetMetaData restMD = rest.getMetaData();
                int numColums = restMD.getColumnCount();
                for (int i = 1; i <= numColums; i++) {
                    System.out.printf("%-30s", restMD.getColumnName(i));
                }
                loading();
                System.out.println();
                while (rest.next()) {
                    for (int i = 1; i <= numColums; i++) {
                        System.out.printf("%-30s", rest.getString(i));
                    }
                    System.out.println();
                }
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
