package com.company;
import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contact> phoneBook=new ArrayList<>();

    public void printContacts(){
        if(this.phoneBook.isEmpty()){
            System.out.println("You have no contacts.");
        }else{
            System.out.println("Contact list:");
            for(int i=0; i<this.phoneBook.size(); i++){
                System.out.println((i + 1) + ". " + this.phoneBook.get(i).getName()+" -> " + this.phoneBook.get(i).getPhoneNumber());
            }
        }
    }

    private int findContact(Contact contact){
        return this.phoneBook.indexOf(contact);
    }

    private int findContact(String contactName){
        for(int i=0; i<this.phoneBook.size(); i++){
            Contact contact=this.phoneBook.get(i);
            if(contact.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }

    public boolean addNewContact(Contact contact){
        if(findContact(contact.getName())>=0){
            return false;
        }
        phoneBook.add(contact);
        return true;
    }

    public boolean modifyContact(Contact oldContact, Contact newContact){
        int foundPosition=findContact(oldContact);
        if(foundPosition<0){
            System.out.println(oldContact.getName()+" was not found.");
            return false;
        }
        this.phoneBook.set(foundPosition, newContact);
        return true;
    }

    public boolean removeContact(Contact contact){
        int foundPosition=findContact(contact);
        if(foundPosition<0){
            System.out.println(contact.getName()+" was not found.");
            return false;
        }
        this.phoneBook.remove(foundPosition);
        return true;
    }

    public Contact queryContact(String name){
        int position=findContact(name);
        if(position>=0){
            return this.phoneBook.get(position);
        }
        return null;
    }


}
