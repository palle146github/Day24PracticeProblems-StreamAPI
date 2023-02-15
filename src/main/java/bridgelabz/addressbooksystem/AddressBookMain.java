package bridgelabz.addressbooksystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        Map<String, AddressBook> addressBookHashMap = new HashMap<String, AddressBook>();
        int userOption = 0;
        while(userOption != 6){
            System.out.println("1. Add Address Book");
            System.out.println("2. Edit Address Book");
            System.out.println("3. Display Address Book Names");
            System.out.println("4. Delete Address Book ");
            System.out.println("5. Search Person in a City or a State across Address Books ");
            System.out.println("6. View Persons by City or State ");
            System.out.println("7. Number of person in a city or state");
            System.out.println("8. Sorting");
            System.out.println("9. Exit");
            System.out.println("Enter your choice: ");
            Scanner s = new Scanner(System.in);
            int userOption1 = s.nextInt();
            switch(userOption1){
                case 1:
                    Scanner sa = new Scanner(System.in);
                    System.out.println("Enter Unique Address Book Name");
                    String addressBookName = s.next();
                    AddressBook addressBookSystem = new AddressBook();
                    addressBookHashMap.put(addressBookName,addressBookSystem);
                    System.out.println("Address Book Successfully created with the name " + addressBookName);
                    break;
                case 2:
                    System.out.println("Welcome to Address Book Editing");
                    int userOption2 = 0;
                    while (userOption2 != 5 && userOption2 != 6) {
                        Scanner sade = new Scanner(System.in);
                        System.out.println("1. Add Contact");
                        System.out.println("2. Display Contacts");
                        System.out.println("3. Edit Contact");
                        System.out.println("4. Delete Contact");
                        System.out.println("5. Go Back Main Menu");
                        System.out.println("6. Exit");
                        System.out.println("Enter your choice: ");
                        int choice = sade.nextInt();
                        System.out.println("Enter Address Book Name");
                        String addressBookNamen = sade.next();
                        try{
                            AddressBook ab = addressBookHashMap.get(addressBookNamen);
                            switch (choice) {
                                case 1:
                                    ab.addContactToAddressBook();
                                    break;
                                case 2:
                                    ab.displayContactDetails();
                                    break;
                                case 3:
                                    ab.editExistingContact();
                                    break;
                                case 4:
                                    ab.deleteContact();
                                    break;
                                case 5:
                                    userOption2 = 5;
                                    break;
                                case 6:
                                    userOption2 = 5;
                                    userOption = 5;
                                    break;
                                default:
                                    System.out.println("Invalid Choice");
                                    break;
                            }

                        }catch (NullPointerException e){
                            System.out.println("Address Book with name " + addressBookNamen + " does not exist");
                        }
                    }
                case 3:
                    if (addressBookHashMap.size() == 0) {
                        System.out.println("Address Book is Empty");
                    } else {
                        System.out.println("Address Books List");
                        int i = 0;
                        for (Map.Entry<String, AddressBook> entry : addressBookHashMap.entrySet()) {
                            String k = entry.getKey();
                            System.out.println(++i + ") " + k);
                        }
                    }
                    break;
                case 4:
                    Scanner s4 = new Scanner(System.in);
                    if (addressBookHashMap.size() != 0) {
                        for (Map.Entry<String, AddressBook> entry : addressBookHashMap.entrySet()) {
                            String k = entry.getKey();
                            System.out.println("Address Book Name : " + k);
                        }
                        System.out.println("Enter Address Book name which you want Delete");
                        String addressBookNamed = s4.next();
                        for (Map.Entry<String, AddressBook> entry : addressBookHashMap.entrySet()) {
                            String k = entry.getKey();
                            if (k.equalsIgnoreCase(addressBookNamed)) {
                                addressBookHashMap.remove(k);
                                System.out.println("Address Book with name  " + addressBookNamed + " deleted successfully");
                                break;
                            }
                        }
                    }
                    else {
                        System.out.println("No Address Book exist in the Record" );
                    }
                    break;
                case 5:
                    if (addressBookHashMap.size() != 0) {
                        Scanner scan = new Scanner(System.in);
                        System.out.println("Enter Person Name");
                        String personName = scan.next();
                        System.out.println( "Person Name " + personName);
                        for (Map.Entry<String, AddressBook> entry : addressBookHashMap.entrySet()) {
                            String k = entry.getKey();
                            AddressBook abs = addressBookHashMap.get(k);
                            abs.personFromCityorState(personName);
                        }
                    }
                    else{
                        System.out.println("Address Book is Empty");
                    }
                    break;
                case 6:
                    if (addressBookHashMap.size() != 0) {
                        Scanner scan = new Scanner(System.in);
                        System.out.println("1. Person by City");
                        System.out.println("2. Person by State");
                        System.out.println("Choose one option");
                        int optioncs = scan.nextInt();
                        AddressBook abs;
                        switch (optioncs) {
                            case 1:
                                Scanner scanc = new Scanner(System.in);
                                System.out.println("Enter City of a Person");
                                String city = scanc.next();
                                System.out.println("Persons from " + city);
                                for (Map.Entry<String, AddressBook> entry : addressBookHashMap.entrySet()) {
                                    String k = entry.getKey();
                                    abs = addressBookHashMap.get(k);
                                    abs.searchPersonsbyCity(city);
                                }
                                break;
                            case 2:
                                Scanner scans = new Scanner(System.in);
                                System.out.println("Enter State of a Person");
                                String state = scans.next();
                                System.out.println("Persons from " + state);
                                for (Map.Entry<String, AddressBook> entry : addressBookHashMap.entrySet()) {
                                    String k = entry.getKey();
                                    abs = addressBookHashMap.get(k);
                                    abs.searchPersonsbyState(state);
                                }
                                break;
                            default:
                                System.out.println("Invalid option");
                                break;
                        }
                    }
                    else {
                        System.out.println("Address Book is Empty");
                    }
                    break;
                case 7:
                    if (addressBookHashMap.size() != 0) {
                        Scanner scan = new Scanner(System.in);
                        System.out.println("1. Number of Persons in City");
                        System.out.println("2. Number of Persons in State");
                        System.out.println("Choose one option");
                        int opt = scan.nextInt();
                        switch (opt) {
                            case 1:
                                Scanner scan1 = new Scanner(System.in);
                                System.out.println("Enter city name");
                                String city = scan1.nextLine();
                                for (Map.Entry<String, AddressBook> entry : addressBookHashMap.entrySet()) {
                                    String k = entry.getKey();
                                    System.out.println("Number of persons in address book " + k + " State " + city);
                                    AddressBook abs = addressBookHashMap.get(k);
                                    abs.personCountByCity(city);
                                }
                                break;
                            case 2:
                                Scanner scan2 = new Scanner(System.in);
                                System.out.println("Enter state name");
                                String state = scan2.nextLine();
                                for (Map.Entry<String, AddressBook> entry : addressBookHashMap.entrySet()) {
                                    String k = entry.getKey();
                                    System.out.println("Number of persons in address book " + k);
                                    AddressBook abs = addressBookHashMap.get(k);
                                    abs.personCountbyState(state);
                                }
                                break;
                            default:
                                System.out.println("Invalid option");
                                break;
                        }
                    }else {
                        System.out.println("Address book is empty");
                    }
                        break;
                case 8:
                    if (addressBookHashMap.size() != 0) {
                        Scanner scan = new Scanner(System.in);
                        System.out.println("1. Sort by Persons name");
                        System.out.println("2. Sort by City");
                        System.out.println("3. Sort by State");
                        System.out.println("4. Sort by Zip");
                        System.out.println("Choose one option");
                        int sort = scan.nextInt();
                        switch (sort) {
                            case 1:
                                System.out.println("Sorting By Person name");
                                for (Map.Entry<String, AddressBook> entry : addressBookHashMap.entrySet()) {
                                    String k = entry.getKey();
                                    AddressBook abs = addressBookHashMap.get(k);
                                    System.out.println("Address Book : " + k);
                                    abs.sortBypersonName();
                                }
                                break;
                            case 2:
                                System.out.println("Sorting By City");
                                for (Map.Entry<String, AddressBook> entry : addressBookHashMap.entrySet()) {
                                    String k = entry.getKey();
                                    AddressBook abs = addressBookHashMap.get(k);
                                    System.out.println("Address Book : " + k);
                                    abs.sortBypersonCity();
                                }
                                break;
                            case 3:
                                System.out.println("Sorting By State");
                                for (Map.Entry<String, AddressBook> entry : addressBookHashMap.entrySet()) {
                                    String k = entry.getKey();
                                    AddressBook abs = addressBookHashMap.get(k);
                                    System.out.println("Address Book : " + k);
                                    abs.sortBypersonState();
                                }
                                break;
                            case 4:
                                System.out.println("Sorting By Zip");
                                for (Map.Entry<String, AddressBook> entry : addressBookHashMap.entrySet()) {
                                    String k = entry.getKey();
                                    AddressBook abs = addressBookHashMap.get(k);
                                    System.out.println("Address Book : " + k);
                                    abs.sortBypersonZip();
                                }
                                break;
                            default:
                                System.out.println("Invalid option");
                                break;
                        }
                    }else {
                        System.out.println("Address book is empty");
                    }
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
            }
        }
    }
}