package PhpSql;

import java.sql.*;
import java.util.Scanner;

public class Product2{
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter min price:");
        double minprice = scanner.nextDouble();
        System.out.println("Enter max price:");
        double maxprice = scanner.nextDouble();
        try(
                Connection hihi= DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind","root","");
                Statement huhu= hihi.createStatement();
        ){
            String select ="select ProductID, ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice from products where "+minprice+" <UnitPrice || UnitPrice <"+maxprice+";";
            System.out.println("The SQL statement is: "+select+"\n");
            ResultSet haha= huhu.executeQuery(select);
            int count =0;
            while (haha.next()){
                int productid= haha.getInt("ProductID");
                String productname= haha.getString("ProductName");
                int supplierid= haha.getInt("SupplierID");
                int categoryid =haha.getInt("CategoryID");
                String quantityperunit= haha.getString("QuantityPerUnit");
                double unitprice= haha.getDouble("UnitPrice");
                count++;
                System.out.println(productid+" ,"+productname+" ,"+supplierid+" ,"+categoryid+" ,"+quantityperunit+" ,"+unitprice);
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
