package entry.fmi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Customer> allCustomers = new ArrayList<>();
        int numClients;
        do {
            System.out.println("Enter num clients");
            numClients = in.nextInt();
            in.nextLine();
        } while (numClients >= 500);  //// For controling the number of customers

        for (int i = 0; i < numClients; i++) {
            System.out.println("Enter Fname Lname city and Pcode of client");
            String firstName;
            String lastName;
            String city;
            String personalCode;
            do {
                firstName = in.nextLine();
                lastName = in.nextLine();
                city = in.nextLine();
                personalCode = in.nextLine();
            } while ((firstName.length() + lastName.length()) > 30 &&
                    city.length() > 10 && personalCode.length() > 10);  /// Control the lenght of elements

            // for adding all customers to the list
            Customer client = new Customer(firstName, lastName, city, Long.parseLong(personalCode));
            allCustomers.add(client);
        }
        // adding all customers to list and sort them
        ArrayList<Customer> sortedCustomers = new ArrayList<>();
        for (Customer customer : allCustomers) {
            sortedCustomers.add(customer);
        }
        sortedCustomers.sort((customer1, customer2) -> {
            int res = customer1.name.compareTo(customer2.name);
            return res;
        });

        // Condition one finished (tva sa tochka 1 i tocka 2 ot zadachata)
        for (Customer c  : sortedCustomers) {
            System.out.print(c.name + ", "+ c.lastName + ", " + c.city + ", "
                    + c.typeStock() + ", "+ c.hasPromotions()
                    + ", " + c.getProcent()+ ", "
                    + c.getDate());
            System.out.println();
        }
        /// Condition 2 next.....
        sortedCustomers.removeAll(allCustomers); /// not pretty sure about this

        sortedCustomers.sort((customer1, customer2) -> {
            if (customer1.city.equals("Plovdiv") && customer1.city.equals("Plovdiv")) {
                int res = customer1.takeProcents() - customer2.takeProcents();
                if (res == 0) {
                    int ress = customer1.name.compareTo(customer2.name);
                    return ress;
                }
                return res;
            }
            return 0 ;
        });

        for (Customer c  : sortedCustomers) {
            System.out.print(c.name + ", "+ c.lastName + ", " + c.city + ", "
                    + c.typeStock() + ", "+ c.hasPromotions()
                    + ", " + c.getProcent()+ ", "
                    + c.getDate());
            System.out.println();
        }
        /// Condition 3(poslednoto uslovie)
        System.out.println("Enter type of stock");
        int typeStock = in.nextInt();
        int maxProcent = 5;
        for (int i = 0; i < allCustomers.size(); i++) {
            if (allCustomers.get(i).getTypeStock() == typeStock){
                maxProcent =Integer.parseInt(allCustomers.get(i).getProcent());
            }
        }
        System.out.println("Max procent "+ maxProcent);






    }
}
