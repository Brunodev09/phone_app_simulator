package phoneapp;

/**
 *
 * @author bruno
 */
public class Contact {
    private String name;
    private String phoneNumber;
    
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    //As static doesn't access classes properties they don't need an instance of the class to be called
    public static Contact createContact(String name, String phoneNumber) {
        return new Contact(name, phoneNumber);
    }
    
}
