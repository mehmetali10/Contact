import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;
import models.Contact;
import models.ContactManager;


public class Main {

     static ContactManager manager = new ContactManager();
    public static void main(String[] args) {

            try{
                loadContacts("contacts.txt");
            } catch(FileNotFoundException e) {
                e.getMessage();
            }finally {
                System.out.println("Contacts loaded");
                System.out.println(manager.toString());
            }

            
            manageContacts();
            System.out.println(manager);  
        
    }

    public static void manageContacts() {
        Scanner scan = new Scanner(System.in);
        while(true) {

            System.out.println("Would you like to \n\ta) add another contact\n\tb) remove a contact \n\tc) exit");
            String option = scan.nextLine();

            if(option.equals(null) || option.isBlank()) {
                System.out.println("/nPlease enter 'a'  'b'  'c' ");
            }

            if(option.equalsIgnoreCase("a")) {
                   System.out.print("\tName: ");
                   String name = scan.nextLine();
                   System.out.print("\tPhone Number: ");
                   String phoneNumber = scan.nextLine();
                   System.out.print("\tBirth Date: ");
                   String birthDate = scan.nextLine();
                   if (name.isBlank() || phoneNumber.isBlank() || phoneNumber.length() < 5) {
                       System.out.println("\nThe input you provided is not valid. Registration failed.");
                   } else {
                         try{
                                manager.addContact(new Contact(name, phoneNumber, birthDate));
                         }catch (ParseException e) {
                                e.getMessage();
                         }
                   }
            }
            else if(option.equalsIgnoreCase("b")) {
                System.out.println("Enter the name of person that you'd like to remove: ");
                System.out.println("\nWho would you like to remove?");
                manager.removeContact(scan.nextLine());
                System.out.println("\n\nUPDATED CONTACTS\n\n" + manager);
            } else {
                break;
            }

        }
        scan.close();
    }

    public static void loadContacts(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scan = new Scanner(fis);
        
        while(scan.hasNextLine()) {
            try{
                manager.addContact(new Contact(scan.next(), scan.next(), scan.next()));
            } catch(ParseException e) {
                e.getMessage();
            }
        }
        scan.close();

    }
}