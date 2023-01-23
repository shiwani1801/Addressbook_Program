package com.bridgelabz.addressbook;

import java.util.*;
public class AddressBookSystemMain {

    //Declaring one hashmap containing all the address book
    Map<String, ContactOperations> addressBookDictionary = new HashMap<>();

    //Default Constructor
    public AddressBookSystemMain() {
        System.out.println("Welcome to Address Book Program !!!");
    }

    Scanner scan = new Scanner(System.in);
    ContactOperations addressBook;

    //Method to save the address book
    public void saveAddressBook(String a) {
        addressBook = new ContactOperations();
        addressBookOperation();
        System.out.println("Do you want to save this address book?");
        String choice = scan.next();
        if (choice.equalsIgnoreCase("y")) {
            addressBookDictionary.put(a, addressBook);
        } else {
            System.out.println("Address book is not saved");
        }
    }

    //Method to print all the address book
    public void printAddressBooks() {
        Iterator<Map.Entry<String, ContactOperations>> itr = addressBookDictionary.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, ContactOperations> entry = itr.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    //Method to check if that given address book name is present or in the address book dictionary
    public boolean checkBookName(String a) {
        boolean flag = true;
        Iterator<Map.Entry<String, ContactOperations>> itr = addressBookDictionary.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, ContactOperations> entry = itr.next();
            String s = entry.getKey();
            if (s.equalsIgnoreCase(a)) {
                System.out.println("This name : " + a + " is already present in Address Book Dictionary\nGive a new name");
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {

        //Initialize Object
        AddressBookSystemMain obj = new AddressBookSystemMain();

        //Now saving the address book
        System.out.println("How many address book you want to save?");
        int books = obj.scan.nextInt();
        for (int i = 1; i <= books; i++) {
            System.out.println("Give one address book name");
            String a = obj.scan.next();
            if (obj.checkBookName(a)) {
                System.out.println("For " + a);
                obj.saveAddressBook(a);
            } else
                i--;
        }
        //print all address book
        obj.printAddressBooks();
    }

    //Performing some contact operation
    public void addressBookOperation() {

        boolean flag = true;

        while (flag) {
            System.out.println();
            System.out.println("1.Add Contact");
            System.out.println("2.Add Multiple Contact");
            System.out.println("3.Edit Contact");
            System.out.println("4.Delete Contact");
            System.out.println("5.Show Contacts");
            System.out.println("6.Exit");
            System.out.println();
            System.out.println("Enter Choice: ");

            String option = scan.next();

            switch (option) {
                case "1":
                    addressBook.addContact();
                    break;

                case "2":
                    System.out.println("1.You want to add multiple contacts from console");
                    System.out.println("2.You want to add multiple contacts from the contact cards");
                    System.out.println("What you want?");
                    System.out.println("Enter your choice.");
                    int choice = scan.nextInt();
                    if (choice == 1) {
                        System.out.println("Enter how many contacts you want to add at a time.");
                        int numOfContacts = scan.nextInt();
                        for (int i = 1; i <= numOfContacts; i++) {
                            addressBook.addContact();
                            System.out.println(i + " Contact added successfully");
                        }
                    } else if (choice == 2) {
                        addressBook.sharedContactCards();
                        System.out.println("Contact cards added successfully");
                    } else
                        System.out.println("Enter valid choice");
                    break;

                case "3":
                    if (addressBook.checkList()) {
                        boolean b = addressBook.editContact();
                        if (b == true) {
                            System.out.println("Details Updated");
                        } else {
                            System.out.println("Contact Not Found");
                        }
                    } else
                        System.out.println("Nothing in the contact list.\nPlease create one");
                    break;

                case "4":
                    if (addressBook.checkList()) {
                        boolean listDeleted = addressBook.deleteContact();
                        if (listDeleted) {
                            System.out.println("Details Deleted");
                        } else {
                            System.out.println("Cannot be Deleted");
                        }
                    } else
                        System.out.println("Nothing in the contact list.\nPlease create one");
                    break;

                case "5":
                    addressBook.printContact();
                    break;
                case "6":
                    flag = false;
                    break;
                default:
                    System.out.println("Enter a valid input.");
                    break;
            }
        }
    }
}