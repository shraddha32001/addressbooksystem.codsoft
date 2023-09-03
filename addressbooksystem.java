package com.CODSOFT;


	import java.util.ArrayList;
	import java.util.Scanner;

	class Contact {
	    private String name;
	    private String phoneNumber;
	    private String emailAddress;

	    public Contact(String name, String phoneNumber, String emailAddress) {
	        this.name = name;
	        this.phoneNumber = phoneNumber;
	        this.emailAddress = emailAddress;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getPhoneNumber() {
	        return phoneNumber;
	    }

	    public String getEmailAddress() {
	        return emailAddress;
	    }

	    @Override
	    public String toString() {
	        return "Name: " + name + "\nPhone Number: " + phoneNumber + "\nEmail Address: " + emailAddress;
	    }
	}

	class AddressBook {
	    private ArrayList<Contact> contacts;

	    public AddressBook() {
	        contacts = new ArrayList<>();
	    }

	    public void addContact(Contact contact) {
	        contacts.add(contact);
	    }

	    public void removeContact(String name) {
	        contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(name));
	    }

	    public Contact searchContact(String name) {
	        for (Contact contact : contacts) {
	            if (contact.getName().equalsIgnoreCase(name)) {
	                return contact;
	            }
	        }
	        return null;
	    }

	    public void displayAllContacts() {
	        for (Contact contact : contacts) {
	            System.out.println(contact);
	            System.out.println("---");
	        }
	    }
	}

	public class addressbooksystem {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        AddressBook addressBook = new AddressBook();

	        while (true) {
	            System.out.println("\nAddress Book Menu:");
	            System.out.println("1. Add Contact");
	            System.out.println("2. Remove Contact");
	            System.out.println("3. Search Contact");
	            System.out.println("4. Display All Contacts");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine();  // Consume the newline character

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter Name: ");
	                    String name = scanner.nextLine();
	                    System.out.print("Enter Phone Number: ");
	                    String phoneNumber = scanner.nextLine();
	                    System.out.print("Enter Email Address: ");
	                    String emailAddress = scanner.nextLine();

	                    Contact newContact = new Contact(name, phoneNumber, emailAddress);
	                    addressBook.addContact(newContact);
	                    System.out.println("Contact added successfully!");
	                    break;

	                case 2:
	                    System.out.print("Enter Name to Remove: ");
	                    String removeName = scanner.nextLine();
	                    addressBook.removeContact(removeName);
	                    System.out.println("Contact removed successfully!");
	                    break;

	                case 3:
	                    System.out.print("Enter Name to Search: ");
	                    String searchName = scanner.nextLine();
	                    Contact foundContact = addressBook.searchContact(searchName);
	                    if (foundContact != null) {
	                        System.out.println("Contact Found:\n" + foundContact);
	                    } else {
	                        System.out.println("Contact not found.");
	                    }
	                    break;

	                case 4:
	                    System.out.println("All Contacts:");
	                    addressBook.displayAllContacts();
	                    break;

	                case 5:
	                    System.out.println("Exiting Address Book.");
	                    scanner.close();
	                    System.exit(0);

	                default:
	                    System.out.println("Invalid choice. Please choose a valid option.");
	            }
	        }
	    }
	}
