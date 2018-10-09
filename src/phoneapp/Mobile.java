package phoneapp;

import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class Mobile {

    private String myNumber;
    private ArrayList<Contact> myContacts;

    public Mobile(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public void printContacts() {
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println("#" + (i + 1) + "-" + this.myContacts.get(i).getName() + "-> " + this.myContacts.get(i).getPhoneNumber());
        }//Here we are getting with .get() Contact objects because the ArrayList that I created is made of Contact objects
    }

    public boolean addNew(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact on file.");
            return false;
        } 
       myContacts.add(contact);
       return true;
        
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int pos = findContact(oldContact);
        if (pos < 0) {
            System.out.println(oldContact.getName() + " was not found.");
            return false;
        }
        this.myContacts.set(pos, newContact);
        System.out.println("Old contact updated.");
        return true;
    }

    public boolean removeContact(Contact oldContact) {
        int pos = findContact(oldContact);
        if (pos < 0) {
            System.out.println(oldContact.getName() + " was not found.");
            return false;
        }
        this.myContacts.remove(pos);
        System.out.println("Contact removed.");
        return true;
    }

    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String contactName) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        } else {
            return null;
        }
    }

    public Contact queryContact(String name) {
        int pos = findContact(name);
        if (pos >= 0) {
            return this.myContacts.get(pos);
        }
        return null;
    }

}
