package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ContactOperations {
    static Scanner scan = new Scanner(System.in);
    private static ArrayList<AddressBook> contactDetails = new ArrayList<>();

    //For adding contact
    public void addContact() {
        System.out.println("Enter the contact details.............");
        System.out.println("Enter the First name:");
        String firstName = scan.nextLine();
        System.out.println("Enter the Last name:");
        String lastName = scan.nextLine();
        System.out.println("Enter the Address:");
        String address = scan.nextLine();
        System.out.println("Enter the City:");
        String city = scan.nextLine();
        System.out.println("Enter the State:");
        String state = scan.nextLine();
        System.out.println("Enter the Zip code:");
        String zip = scan.nextLine();
        System.out.println("Enter the Phone no:");
        String phoneNumber = scan.nextLine();
        System.out.println("Enter the Email:");
        String email = scan.nextLine();

        //Calling Address BOOK class
        AddressBook details = new AddressBook(firstName, lastName, address, city, state, zip, phoneNumber, email);
        contactDetails.add(details);
    }
    public void sharedContactCards()
    {
        AddressBook a = new AddressBook("Shiv", "Sahare", "Jogithana", "Umred",
                "MH", "442467", "8908675432", "shiv@gmail.com");
        AddressBook b = new AddressBook("Prati", "Borkar", "near Chowala store", "Nagpur",
                "MH", "446734", "7008566789", "prati@gmail.com");
        AddressBook c = new AddressBook("Nilam", "Kose", "Nakhara choke", "Nagpur",
                "MH", "446789", "9937585846", "nilamgmail.com");
        contactDetails.add(a);
        contactDetails.add(b);
        contactDetails.add(c);
    }


    //For editing contact
    public boolean editContact(String Name) {
        int flag = 0;
        for (AddressBook contact : contactDetails) {
            if (contact.getFirstName().equalsIgnoreCase(Name)) {
                System.out.println("Enter the detail which needs to be updated:\nChoose the option.");
                System.out.println("1. Edit First Name");
                System.out.println("2. Edit Last Name");
                System.out.println("3. Edit Address");
                System.out.println("4. Edit City");
                System.out.println("5. Edit State");
                System.out.println("6. Edit Zip");
                System.out.println("7. Edit Phone Number");
                System.out.println("8. Edit Email");

                int choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter First Name: ");
                        String firstName = scan.next();
                        contact.setFirstName(firstName);
                        break;

                    case 2:
                        System.out.println("Enter Last name: ");
                        String lastName = scan.next();
                        contact.setLastName(lastName);
                        break;

                    case 3:
                        System.out.println("Enter Address: ");
                        String address = scan.next();
                        contact.setAddress(address);
                        break;

                    case 4:
                        System.out.println("Enter City: ");
                        String city = scan.next();
                        contact.setCity(city);
                        break;

                    case 5:
                        System.out.println("Enter State: ");
                        String state = scan.next();
                        contact.setState(state);
                        break;

                    case 6:
                        System.out.println("Enter Zip Code: ");
                        String zip = scan.next();
                        contact.setZip(zip);
                        break;

                    case 7:
                        System.out.println("Enter Phone Number:");
                        String phoneNumber = scan.next();
                        contact.setPhoneNumber(phoneNumber);
                        break;

                    case 8:
                        System.out.println("Enter Email: ");
                        String email = scan.next();
                        contact.setEmail(email);
                        break;

                }

                flag = 1;
                break;
            }
        }
        return flag == 1;
    }

    //For deleting contact
    public boolean deleteContact(String name) {
        int flag = 0;
        for(AddressBook contact: contactDetails)
        {
            if(contact.getFirstName().equalsIgnoreCase(name))
            {
                contactDetails.remove(contact);
                flag = 1;
                break;
            }
        }
        return flag == 1;
    }

    //Check if array list is empty
    public boolean checkList()
    {
        if (!contactDetails.isEmpty())
            return true;
        else
            return false;
    }

    //Printing contactDetails
    public void printContact() {
        if(checkList())
        {
            System.out.println("Contact details are below.....\n");
            Iterator it = contactDetails.iterator();
            while (it.hasNext())
            {
                System.out.println(it.next());
            }
        }
        else
            System.out.println("Contact list is empty.");
    }


}
