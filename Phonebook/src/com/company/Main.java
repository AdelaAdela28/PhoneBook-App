package com.company;
import java.util.*;

public class Main {
    // App that implements a simple mobile phone with some capabilities.
    // Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
    // and search/find contact.

    private static Scanner scanner=new Scanner(System.in);
    private static MobilePhone mobilePhone=new MobilePhone();

    public static void main(String[] args) {
        boolean quit=false;
        startPhone();
        printActions();
        while(!quit){
            System.out.println("Enter your choice: ");
            int choice=scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 0:
                    printActions();
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    modifyContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    quit=true;
                    System.out.println("Bye, bye!");
                    break;
            }
        }
    }

    private static void startPhone(){
        System.out.println("Starting phone...");
    }
    private static void printActions(){
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print action options.");
        System.out.println("\t 1 - To show all contacts.");
        System.out.println("\t 2 - To add a new contact.");
        System.out.println("\t 3 - To modify an existing contact.");
        System.out.println("\t 4 - To remove an existing contact.");
        System.out.println("\t 5 - To search a contact.");
        System.out.println("\t 6 - To quit the application.");
    }

    private static void addNewContact(){
        System.out.print("Enter new contact name: ");
        String name=scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone=scanner.nextLine();
        Contact newContact=Contact.createContact(name, phone);
        if(mobilePhone.addNewContact(newContact)){
            System.out.println("New contact added: "+"\nname: "+name+", phone number: "+phone);
        }else{
            System.out.println("Cannot add "+name+", contact already exists.");
        }
    }

    private static void queryContact(){
        System.out.print("Enter existing contact name: ");
        String name=scanner.nextLine();
        Contact existingContactRecord=mobilePhone.queryContact(name);
        if(existingContactRecord==null){
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Name: "+existingContactRecord.getName()+ ", phone number: "+existingContactRecord.getPhoneNumber());
    }

    private static void modifyContact(){
        System.out.print("Enter existing contact name: ");
        String name=scanner.nextLine();
        Contact existingContactRecord=mobilePhone.queryContact(name);
        if(existingContactRecord==null){
            System.out.println("Contact not found.");
            return;
        }
        System.out.print("Enter new contact name: ");
        String newName=scanner.nextLine();
        System.out.print("Enter new contact phone number: ");
        String newPhoneNumber=scanner.nextLine();
        Contact newContact=Contact.createContact(newName, newPhoneNumber);
        if(mobilePhone.modifyContact(existingContactRecord, newContact)){
            System.out.println("Successfully updated contact: "+ existingContactRecord.getName()+ " was replaced with "+ newContact.getName()+ ".");
        }else{
            System.out.println("Error updating contact.");
        }
    }

    private static void removeContact(){
        System.out.print("Enter existing contact name: ");
        String name=scanner.nextLine();
        Contact existingContactRecord=mobilePhone.queryContact(name);
        if(existingContactRecord==null){
            System.out.println("Contact not found.");
            return;
        }
        if(mobilePhone.removeContact(existingContactRecord)){
            System.out.println("Successfully deleted contact: "+ existingContactRecord.getName()+ " was removed.");
        }else{
            System.out.println("Error deleting contact.");
        }
    }
}
