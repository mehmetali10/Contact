package models;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Contact {

    private String name;
    private int age;
    private String birthDate;
    private String phoneNumber;
    


    public Contact(String name, String phoneNumber ,String birthDate ) throws ParseException {

        if(name.equals(null) || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null/blank");
        }

        if(birthDate.equals(null) || birthDate.isBlank()) {
            throw new IllegalArgumentException("date of birth cannot be null/blank");
        }

        if(phoneNumber.equals(null) || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("phone number cannot be null/blank");
        }

        if(phoneNumber.length() < 10) {
            throw new IllegalArgumentException("phone number cannot be less than 10 digits");
        }

        if(age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }

        this.name = name;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.age = toAge(birthDate);
    }

    public Contact(Contact source) {
        this.age = source.age;
        this.birthDate = source.birthDate;
        this.name = source.name;
        this.phoneNumber = source.phoneNumber;
    }

    public int toAge(String birthDate) throws ParseException {
        
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        formatter.setLenient(false);
        long diff = new Date().getTime() - formatter.parse(birthDate).getTime(); //age in milliseconds
        return (int) (TimeUnit.MILLISECONDS.toDays(diff) / 365);
    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }


    public String getBirthDate() {
        return birthDate;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setName(String name) {
        if(name.equals(null) || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null/blank");
        }
        this.name = name;
    }


    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber.equals(null) || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("phone number cannot be null/blank");
        } 
        if(phoneNumber.length() < 10) {
            throw new IllegalArgumentException("phone number cannot be less than 10 digits");
        }
        this.phoneNumber = phoneNumber;
    }

    public void setBirthDate(String bd) throws ParseException {
        if(bd.equals(null) || bd.isBlank()) {
            throw new IllegalArgumentException("birthday cannot be null/blank");
        }
        this.birthDate = bd;
        int age = toAge(bd);
        setAge(age);
    }

    
    private void setAge(int age) {
        if(age < 0) {
            throw new IllegalArgumentException("age cannot be negative");
        }
        this.age = age; 
    }

    public String toString() {
        return  "Name: " + this.name + "\n" +

                "Phone number: " + this.phoneNumber + "\n" +

                "Birth Date: " + this.birthDate + "\n" +

                "Age: " + this.age + " year old\n"; 
    }


    
}
