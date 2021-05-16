package Drinks;

import Task6.Person;

import java.sql.*;
import java.util.Scanner;

public class LikeDrink {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            Connection drinks = DriverManager.getConnection("jdbc:mysql://localhost:3306/drink", "root", "");
            Statement stmt = drinks.createStatement();
            {
                System.out.println("Dưới đây là danh sách đồ uống yêu thích của tôi!");
                System.out.println();
                ResultSet rest_f = stmt.executeQuery("select * from likedrink");
                ResultSetMetaData restMD = rest_f.getMetaData();
                int numCols = restMD.getColumnCount();
                for (int i = 1; i <= numCols; i++) {
                    System.out.printf("%-30s", restMD.getColumnName(i));
                }
                System.out.println();
                System.out.println();
                while (rest_f.next()) {
                    for (int i = 1; i <= numCols; i++) {
                        System.out.printf("%-30s", rest_f.getString(i));
                    }
                    System.out.println();
                }
            }
            boolean quit = false;
            String name;
            double price;
            String brand;
            while (!quit) {
                System.out.println("\nEnter you action press:");
                System.out.println("1- C: Create drink like new.\n2- R: Read data , Print list like\n3- U:Update.\n4- D: Deleted data.\n5- E:Exits");
                int action = scanner.nextInt();
                scanner.nextLine();
                switch (action) {
                    case 1:
                        System.out.println("Enter id:");
                        int id= Integer.parseInt(scanner.nextLine());
                        System.out.println("Enter name drink: ");
                        String namedr = scanner.nextLine();
                        System.out.println("Enter price:");
                        double pricedr= Double.parseDouble(scanner.nextLine());
                        System.out.println("Enter brand:");
                        String branddr= scanner.nextLine();
                        String printdr = "insert into likedrink values(?,?,?,?)";
                        PreparedStatement ptsmt= drinks.prepareStatement(printdr);
                        ptsmt.setInt(1,id);
                        ptsmt.setString(2,namedr);
                        ptsmt.setDouble(3,pricedr);
                        ptsmt.setString(4,branddr);
                        int rowsInsert = ptsmt.executeUpdate();
                        System.out.println(rowsInsert+"drink inserted.");
                        break;
                    case 2:
                        ResultSet rest = stmt.executeQuery("select * from likedrink");
                        ResultSetMetaData restMD = rest.getMetaData();
                        int numCol = restMD.getColumnCount();
                        for (int i = 1; i <= numCol; i++) {
                            System.out.printf("%-30s", restMD.getColumnName(i));
                        }
                        System.out.println();
                        System.out.println();
                        while (rest.next()) {
                            for (int i = 1; i <= numCol; i++) {
                                System.out.printf("%-30s", rest.getString(i));
                            }
                            System.out.println();
                        }
                        break;
                    case 3:
                        System.out.println("Enter id update :");
                        int id_updr=Integer.parseInt(scanner.nextLine());
                        System.out.println("Enter name new");
                        String name_updr = scanner.nextLine();
                        String update_drink= "update likedrink set name = "+name_updr+" where id="+id_updr+"";
                        PreparedStatement ptsmt_updr= drinks.prepareStatement(update_drink);
                        drinks.setAutoCommit(false);
                        ptsmt_updr.setString(1,name_updr);
                        ptsmt_updr.setInt(2,id_updr);
                        ptsmt_updr.addBatch();
                        System.out.println("Upadate successfully");
                        break;
                    case 4:
                        System.out.println("Name drink:");
                        String named = scanner.nextLine();
                        String delete_dr = "DELETE FROM likedrink WHERE name ='"+named+"';";
                        PreparedStatement pstmt_dr = drinks.prepareStatement(delete_dr);
                        pstmt_dr.executeUpdate();
                        System.out.println("DELETED data !");
                        break;
                    case 5:
                        System.out.println("Byee");
                        quit = true;
                        break;
                }
            }

        }
        catch (SQLException ex){
            System.out.println(ex);
        }
    }
}
