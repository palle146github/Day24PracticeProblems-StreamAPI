package bridgelabz.addressbooksystem;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class AddressBook {
    Contact contact = new Contact();
    ArrayList<Contact> contactArrayList = new ArrayList<>();
    Map<String, String> cityPerson = new HashMap<>();
    Map<String, String> statePerson = new HashMap<>();
    public static int cityorStateCount;
    int count = 0;

    public void addContactToAddressBook() {
        Scanner scanner = new Scanner(System.in);
        boolean modify = false;
        boolean empty = true;
        System.out.println("Please Contact First Name!! ");
        String contactFirstName = scanner.nextLine();
        if (contactArrayList.size() != 0) {
            empty = false;
            Iterator<Contact> iterator = contactArrayList.iterator();
            while (iterator.hasNext()) {
                Contact contact1 = iterator.next();
                Predicate<Contact> isPresent = p -> p.getFirstName().equals(contactFirstName);
                boolean nameOccures = contactArrayList.stream().anyMatch(isPresent);
            if (nameOccures) {
                    System.out.println("Duplicate Entry!! Please start again!!!");
                    modify = false;
                } else {
                    modify = true;
                }
            }
        }
        if (modify == true || empty == true) {
            System.out.println("Enter Contact Last Name");
            String lastName = scanner.next();

            System.out.println("Enter Contact Address Details");
            String address = scanner.next();

            System.out.println("Enter Contact City Name");
            String city = scanner.next();

            System.out.println("Enter Contact State Name");
            String state = scanner.next();

            System.out.println("Enter Contact Zip");
            String zip = scanner.next();

            System.out.println("Enter Contact Phone Number");
            String phoneNumber = scanner.next();

            System.out.println("Enter Contact Email");
            String email = scanner.next();

            Contact contact1 = new Contact(contactFirstName, lastName, address, city, state, zip, phoneNumber, email);
            contactArrayList.add(contact1);

            System.out.println("Contact Details Added Successfully");
        }
    }

    public void displayContactDetails() {
        if (contactArrayList.size() == 0) {
            System.out.println("No contacts in Address Book");
            System.out.println("");
        } else {
            for (Contact c : contactArrayList) {
                System.out.print("");
                System.out.print("");
                System.out.println("First Name : " + c.getFirstName());
                System.out.println("Last Name : " + c.getLastName());
                System.out.println("Address : " + c.getAddress());
                System.out.println("City : " + c.getCity());
                System.out.println("State : " + c.getState());
                System.out.println("Zip : " + c.getZip());
                System.out.println("Phone Number : " + c.getPhoneNumber());
                System.out.println("Email : " + c.getEmail());
                System.out.println("");
                System.out.print("");

            }
        }
    }

    public void deleteContact() {
        Scanner sd = new Scanner(System.in);
        if (contactArrayList.size() != 0) {
            System.out.println("Please Enter the First name of contact which you want delete!!");
            String name = sd.nextLine();
            Iterator<Contact> iterator = contactArrayList.iterator();
            while (iterator.hasNext()) {
                Contact c = iterator.next();
                if (name.equalsIgnoreCase(c.getFirstName())) {
                    contactArrayList.remove(c);
                    System.out.println("Employee of " + name + " is successfully deleted");
                    break;
                }

            }
        } else {
            System.out.println("No Employee exist in Company");
        }
    }

    public void editExistingContact() {
        if (contactArrayList.size() == 0) {
            System.out.println("No contacts in Address Book to edit");
        } else {
            Scanner se = new Scanner(System.in);
            System.out.println("Enter First Name Edit Contact Details");
            String firstName = se.next();
            for (Contact c : contactArrayList) {
                if (c.getFirstName().equalsIgnoreCase(firstName)) {
                    System.out.print("\t1. First Name");
                    System.out.print("\t2. Last Name");
                    System.out.print("\t3. Address");
                    System.out.print("\t4. City");
                    System.out.print("\t5. State");
                    System.out.print("\t6. Zip");
                    System.out.print("\t7. Phone Number");
                    System.out.print("\t8. Mail");
                    System.out.print("\t9. All");
                    System.out.print("\t10. Exit\n");
                    System.out.println("Enter your choice to edit respective details: ");
                    int editOption = se.nextInt();
                    switch (editOption) {
                        case 1:
                            System.out.println("Enter new First Name ");
                            Scanner sf = new Scanner(System.in);
                            String newFirstName = sf.next();
                            c.setFirstName(newFirstName);
                            System.out.println("First Name Edited Successfully");
                            break;
                        case 2:
                            System.out.println("Enter new Last Name ");
                            Scanner sl = new Scanner(System.in);
                            String newLastName = sl.next();
                            c.setLastName(newLastName);
                            System.out.println("Last Name Edited Successfully");
                            break;
                        case 3:
                            System.out.println("Enter new Address ");
                            Scanner sa = new Scanner(System.in);
                            String newAddress = sa.next();
                            c.setAddress(newAddress);
                            System.out.println("Address Edited Successfully");
                            break;
                        case 4:
                            System.out.println("Enter new City ");
                            Scanner sc = new Scanner(System.in);
                            String newCity = sc.next();
                            c.setCity(newCity);
                            System.out.println("City Edited Successfully");
                            break;
                        case 5:
                            System.out.println("Enter new State ");
                            Scanner ss = new Scanner(System.in);
                            String newState = ss.next();
                            c.setState(newState);
                            System.out.println("State Edited Successfully");
                            break;
                        case 6:
                            System.out.println("Enter new Zip ");
                            Scanner sz = new Scanner(System.in);
                            String newZip = sz.next();
                            c.setZip(newZip);
                            System.out.println("Zip Edited Successfully");
                            break;
                        case 7:
                            System.out.println("Enter new Phone Number ");
                            Scanner sp = new Scanner(System.in);
                            String newPhone = sp.next();
                            c.setPhoneNumber(newPhone);
                            System.out.println("Phone Number Edited Successfully");
                            break;

                        case 8:
                            System.out.println("Enter new Email ");
                            Scanner sem = new Scanner(System.in);
                            String newEmail = sem.next();
                            c.setPhoneNumber(newEmail);
                            System.out.println("Email Edited Successfully");
                            break;

                        case 9:
                            Scanner sall = new Scanner(System.in);

                            System.out.println("Enter Contact New First Name");
                            String newFirstname = sall.next();
                            c.setFirstName(newFirstname);

                            System.out.println("Enter Contact New Last Name");
                            String lastName = sall.next();
                            c.setLastName(lastName);

                            System.out.println("Enter Contact New Address Details");
                            String address = sall.next();
                            c.setAddress(address);

                            System.out.println("Enter Contact New City Name");
                            String city = sall.next();
                            c.setCity(city);

                            System.out.println("Enter Contact New State Name");
                            String state = sall.next();
                            c.setState(state);

                            System.out.println("Enter Contact New Zip");
                            String zip = sall.next();
                            c.setZip(zip);

                            System.out.println("Enter Contact Phone Number");
                            String phoneNumber = sall.next();
                            c.setPhoneNumber(phoneNumber);

                            System.out.println("Enter Contact New Email");
                            String email = sall.next();
                            c.setEmail(email);
                            break;
                        case 10:
                            System.exit(1);
                            break;
                        default:
                            System.out.println("Invalid option");
                            break;
                    }
                }
            }
        }
    }

    public void personCountByCity(String city){
        long pcc = contactArrayList.stream().filter( p -> p.getCity().equalsIgnoreCase(city)).count();
        System.out.println(pcc);
    }
    public void personCountbyState(String state){
        long pcs = contactArrayList.stream().filter( p -> p.getState().equalsIgnoreCase(state)).count();
        System.out.println(pcs);
    }
    public int counting(){
        return count++;
    }
    public void sortBypersonName(){
        Comparator<Contact> nameComparator = (cust1, cust2) -> cust1.getFirstName().compareTo(cust2.getFirstName());
        List<Contact> sortedContactList = contactArrayList.stream().sorted(nameComparator).collect(Collectors.toList());
        sortedContactList.forEach(System.out::println);
    }
    public void sortBypersonCity(){
        Comparator<Contact> nameComparator = (cust1, cust2) -> cust1.getCity().compareTo(cust2.getCity());
        List<Contact> sortedContactList = contactArrayList.stream().sorted(nameComparator).collect(Collectors.toList());
        sortedContactList.forEach(System.out::println);
    }
    public void sortBypersonState(){
        Comparator<Contact> nameComparator = (cust1, cust2) -> cust1.getState().compareTo(cust2.getState());
        List<Contact> sortedContactList = contactArrayList.stream().sorted(nameComparator).collect(Collectors.toList());
        sortedContactList.forEach(System.out::println);
    }
    public void sortBypersonZip(){
        Comparator<Contact> nameComparator = (cust1, cust2) -> cust1.getZip().compareTo(cust2.getZip());
        List<Contact> sortedContactList = contactArrayList.stream().sorted(nameComparator).collect(Collectors.toList());
        sortedContactList.forEach(System.out::println);
    }
    public void searchPersonsbyCity(String city) {
        contactArrayList.stream().filter( p -> p.getCity().equalsIgnoreCase(city)).forEach(p -> System.out.println("Person  : " + p.getFirstName()));
        }


    public void searchPersonsbyState(String state) {
        contactArrayList.stream().filter( p -> p.getState().equalsIgnoreCase(state)).forEach(p -> System.out.println("Person  : " + p.getFirstName()));
        }

    public void personFromCityorState(String personName) {
        contactArrayList.stream().filter( p -> p.getFirstName().equalsIgnoreCase(personName)).forEach( p -> System.out.println("City : " + p.getCity() + "\tState : " + p.getState()));
    }
}
