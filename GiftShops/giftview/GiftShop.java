package GiftShops.giftview;

import GiftShops.giftcontroller.Gift;
import GiftShops.giftmodel.GiftController;

import java.util.Scanner;

public class GiftShop {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1. Add new gift\n"+
                    "2. Deleted gift\n"+
                    "3. Display all gift\n"+
                    "4. Exits");
            System.out.println("Your choice:");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    addGf();
                    break;
                case 2:
                    deleteGf();
                    break;
                case 3:
                    GiftController ctr= new GiftController();
                    ctr.displayGift();
                    break;
                case 4:
                    System.out.println("See you again!");
                    break;
            }
        }while (choice != 4);
    }
    public static void addGf(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Gift ID:");
        int id= scanner.nextInt();
        System.out.println("Enter Gift Qty:");
        int qty= scanner.nextInt();
        System.out.println("Enter Gift Price:");
        double price = scanner.nextDouble();
        System.out.println("Enter Gift Name:");
        String name= scanner.next();
        Gift obj= new Gift(id, qty, price, name);
        GiftController ctrl = new GiftController();
        ctrl.insertGift(obj);
    }
    public static void deleteGf(){
        Scanner scanner = new Scanner(System.in);
        Gift obj= new Gift();
        System.out.println("Enter the id you want to delete:");
        int id= scanner.nextInt();
        obj.setId(id);
        GiftController ctr= new GiftController();
        ctr.deleteGift(obj);
    }
}
