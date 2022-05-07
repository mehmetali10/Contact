package models;

import java.util.ArrayList;

public class ContactManager {
    ArrayList<Contact> list ;

    public ContactManager() {
        list = new ArrayList<Contact>();
    }

    public Contact getContact(int index) {
        return new Contact(list.get(index)); // avoids reference trap
    }

    public void setContact(int index, Contact c) {
        list.set(index, new Contact(c)); // avoids reference trap 
    }


    public void addContact(Contact c) {
        list.add(new Contact(c));     //avoids reference trap
    }

    public void removeContact(Contact c) {
        list.remove(c);
    }
    
    public void removeContact(String name) {
        if(list.isEmpty()) {
            throw new IllegalStateException("Contact list is empty.");
        }
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).getName().equalsIgnoreCase(name)) {
                list.remove(i);
            }
        }
    }

    public String toString() {
        String temp = "";
        for(int i=0; i<list.size(); i++) {
            temp += list.get(i).toString();
            temp += "\n\n";
        }
        return temp;
    }
    
}
