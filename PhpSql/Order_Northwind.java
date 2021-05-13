package PhpSql;
import java.sql.*;
public class Order_Northwind {
    public static void main(String[] args) {
        try(
                Connection deptrai = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind","root","");
                Statement xaumu=deptrai.createStatement();
                ){
            String xinhgai = "select OrderID, CustomerID, EmployeeID, OrderDate ,RequiredDate,ShippedDate ,ShipVia ,Freight,ShipName,ShipAddress,ShipCity, ShipRegion, ShipPostalCode , ShipCountry from orders ;";
            System.out.println("The SQL statement is: "+xinhgai+"\n");
            ResultSet hihi= xaumu.executeQuery(xinhgai);
            int count =0;
            while (hihi.next()){
                int orderid= hihi.getInt("OrderID");
                String customerid= hihi.getString("CustomerID");
                int employeeid= hihi.getInt("EmployeeID");
                Date orderdate =hihi.getDate("OrderDate");
                Date requireddate= hihi.getDate("RequiredDate");
                Date shippedate= hihi.getDate("ShippedDate");
                int shipvia= hihi.getInt("ShipVia");
                double freight =hihi.getDouble("Freight");
                String shipname= hihi.getString("ShipName");
                String shipaddress= hihi.getString("ShipAddress");
                String shipcity= hihi.getString("ShipCity");
                String shipregion= hihi.getString("ShipRegion");
                String shippostalcode= hihi.getString("ShipPostalCode");
                String shipcountry= hihi.getString("ShipCountry");
                count++;
                System.out.println(orderid+" ,"+customerid+" ,"+employeeid+" ,"+orderdate+" ,"+requireddate+" ,"+shippedate+" ,"+shipvia+" ,"+freight+" ,"+shipname+" ,"+shipaddress+","+shipcity+" ,"+shipregion+" ,"+shippostalcode+" ,"+shipcountry);
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
