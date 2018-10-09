package phoneapp;

import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Mobile mobile = new Mobile("123 123");

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();
        while (!quit) {
            System.out.println("Enter action: ");
            int action = scanner.nextInt();
            scanner.nextLine();
            
            switch (action) {
                case 0:
                    System.out.println("Shutting down...");
                    quit = true;
                    break;
                case 1:
                    printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
    }

    private static void addNewContact() {

        System.out.println("Add new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String newPhone = scanner.nextLine();

        Contact newContact = Contact.createContact(newName, newPhone);

//        mobile.addNew(newContact); If we add this line, it will be added twice.

        if (mobile.addNew(newContact)) { //this if also adds
            System.out.println("New contact added!");
        } else {
            System.out.println("Error!");
        }
    }

    private static void updateContact() {
        System.out.println("Enter existing contact: ");
        String old = scanner.nextLine();
        Contact exists = mobile.queryContact(old);

        if (exists == null) {
            System.out.println("Could not find this contact!");
        } else {
            System.out.print("Enter new contact name: ");
            String newName = scanner.nextLine();
            System.out.println("Enter new phone number: ");
            String newNumber = scanner.nextLine();

            Contact newContact = Contact.createContact(newName, newNumber);

//            mobile.updateContact(exists, newContact);
            if (mobile.updateContact(exists, newContact)) {
                System.out.println("Contact updated!");
            } else {
                System.out.println("Updating failed");
            }
        }
    }

    private static void removeContact() {
        System.out.println("Enter existing contact: ");
        String old = scanner.nextLine();
        Contact exists = mobile.queryContact(old);

        if (exists == null) {
            System.out.println("Could not find this contact!");
        }
//        mobile.removeContact(exists);
        if (mobile.removeContact(exists)) {
            System.out.println("Contact removed!");
        } else {
            System.out.println("Could not remove contact");
        }
    }
    private static void queryContact() {
        System.out.println("Enter existing contact: ");
        String old = scanner.nextLine();
        Contact exists = mobile.queryContact(old);

        if (exists == null) {
            System.out.println("Could not find this contact!");
        }
        else System.out.println("Name: " + exists.getName() + "Phone: " + exists.getPhoneNumber());
    }

    private static void printContacts() {
        mobile.printContacts();
    }

    private static void startPhone() {
        System.out.println("Starting phone...");
    }

    private static void printActions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To shut down.");
        System.out.println("\t 1 - To print a list of all the items in the list.");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To edit an item in the list.");
        System.out.println("\t 4 - To remove an item from the list.");
        System.out.println("\t 5 - To search for an item in the list.");
        System.out.println("\t 6 - To print actions.");
    }

}
