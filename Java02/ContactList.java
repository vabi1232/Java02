package lab5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ContactList {
    List<Contact> contactList = new LinkedList<>();
    Scanner sc = new Scanner(System.in);

    public ContactList () {
        contactList = new ArrayList<>();
    }

    public void ContactListAdd (Contact contact) {
            this.contactList.add(contact);
    }

    public void DeleteContactListAdd (String name) {
        Contact contact = contactList.stream().filter(contact1 -> contact1.getName().equals(name)).findFirst()
                .orElse(null);
        if (contact == null) {
            return;
        }
        else {
            this.contactList.remove(contact);

        }
    }

    public void InsertPhone () {
        for (Contact c : contactList) {
            contactList.toString();
            System.out.println(contactList);
        }
    }

    public void SearchContact (String name) {
        boolean searched = false;
        for (Contact s : contactList) {
            if (s.getName().contains(name)) {
                searched = true;
                System.out.println(s.toString());
                break;
            }
        }
        if (!searched) {
            System.out.println("No");
        }
    }


}
