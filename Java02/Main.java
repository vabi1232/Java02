package lab5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactList contactList = new ContactList();

        int n = 0;
        while (n < 4) {
            System.out.println("Moi ban chon menu : ");
            System.out.println("1. Insert contact");
            System.out.println("2. Add contact");
            System.out.println("3. Delete contact");
            System.out.println("4. Search contact");
            String chosle = sc.nextLine();

            switch (chosle) {
                case "1" : {
                        contactList.InsertPhone();
                    break;
                }
                case "2" : {
                    System.out.println("Moi ban nhap ten : ");
                    String name = sc.nextLine();
                    System.out.println("Moi ban nhap sdt : ");
                    String phone = sc.nextLine();
                    Contact contactList1 = new Contact(name, phone);
                    contactList.ContactListAdd(contactList1);
                    System.out.println(contactList1);
                    break;
                }
                case "3" : {
                    System.out.println("Nhap name can xoa :");
                    String name = sc.nextLine();
                    contactList.DeleteContactListAdd(name);
                    break;
                }
                case "4" : {
                    System.out.println("Nhap name can tim :");
                    String name = sc.nextLine();
                    contactList.SearchContact(name);
                    break;
                }
            }
        }
    }
}
