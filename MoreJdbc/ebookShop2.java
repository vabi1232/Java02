package MoreJdbc;

import java.sql.*;
public class ebookShop2 {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop","root","");
                Statement stmt= conn.createStatement();
        ){
            ResultSet rest= stmt.executeQuery("select * from books");
            //get the metadata of the ResultSet
            ResultSetMetaData restMD = rest.getMetaData();
            //get the number of column from metadata
            int numColumns = restMD.getColumnCount();
            //print colum names - column index begins at 1
            for (int i=1;i<=numColumns;i++){
                System.out.printf("%-30s",restMD.getColumnName(i));
            }
            System.out.println();
            for (int i=1;i<=numColumns;i++){
                System.out.printf("%-30s","("+restMD.getColumnClassName(i)+")");
            }
            System.out.println();
            while (rest.next()){
                for (int i=1;i<=numColumns;i++){
                    System.out.printf("%-30s",rest.getString(i));
                }
                System.out.println();
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
