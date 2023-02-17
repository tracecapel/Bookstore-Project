package Project1;

import java.util.ArrayList;
import java.util.Scanner;



/* 
The functions of this program include:

Registering user as a new member
Logging in as an existing customer
Activating/deactivating premium membership
Completing a purchase
Tracking stock of items
Admin access to view stock of items, and view how much each customer has spent
Updating pay method
 */

public class storePrettiest {
    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        //Populating our ArrayLists with products and members by calling methods in Member and Inventory classes
        ArrayList < Product > productList = new ArrayList < > ();
        Inventory.addProductsToList(productList);

        ArrayList < Member > members = new ArrayList < > ();
        Member.addMembers(members);



        //Creating an admin object with password needed to access menu
        admin newAdmin = new admin(1234);

        //Main menu, this menu will loop until the user selects option 4 (exit)
        while (1 == 1) {

            System.out.println(
                "Welcome to our BookStore! Select an item from the menu below to continue.");

            System.out.println("1. Login");

            System.out.println("2. Register as a new member");

            System.out.println("3. Admin Login (View Customers and profits)");

            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            //This code will execute when the user selects 1 from the main menu
            if (choice == 1) {

                System.out.println("Enter your name");
                scanner.nextLine();
                String customerName = scanner.nextLine();
                //This is a for loop that checks if the user is a registered member, and if they are it then checks if they are premium and redirects to correct menu
                for (int i = 0; i < members.size(); i++) {
                    if (customerName.equals(members.get(i).getName())) {
                        if (members.get(i).getPremium()) {

                            System.out.println("Welcome back " + customerName + "!"); //This menu is for premium members. It adds the option to deactivate their membership or pay the fee for premium

                            System.out.println("Select an item from the menu to continue!");

                            System.out.println("1. Make a purchase");

                            System.out.println("2. Deactivate premium membership");

                            System.out.println("3. Pay premium membership fee");

                            System.out.println("4. Update payment method " +
                                "(Current pay method: " + members.get(i).getPayMethod() +
                                ")");
                            int choice2 = scanner.nextInt();
                            if (choice2 == 1) {
                                double total = 0;
                                int stockTrack = 0;

                                while (1 == 1) {
                                    int counter = 1;

                                    System.out.println(
                                        "Currently, we are selling the follow items: ");

                                    Inventory.printProductMenu(productList); //Method that prints menu

                                    System.out.println(
                                        "What would you like to purchase? Enter the number of the item youd like to buy."); //Asking customer what item theyd like to buy
                                    int choice3 = scanner.nextInt();

                                    total = total + productList.get(choice3 - 1).getPrice();
                                    System.out.println("Great choice! " +
                                        "The cost for " +
                                        productList.get(choice3 - 1).getTitle() + " is " +
                                        "$ " + productList.get(choice3 - 1).getPrice() +
                                        " Your current total is: " + total); //Confirms purchase and updates total

                                    stockTrack = productList.get(choice3 - 1).getStock();
                                    stockTrack = stockTrack - 1;
                                    productList.get(choice3 - 1).setStock(stockTrack); //This substracts stock from the purchased item 


                                    System.out.println("Would you like to buy more items?"); //Asking if the user would like to buy more items. If they press 1, the loop will not be broken and product menu will print again
                                    System.out.println("1. Yes");
                                    System.out.println("2. No, thats all");
                                    int choice4 = scanner.nextInt();
                                    if (choice4 == 1) {} else {
                                        System.out.println(
                                            "Thank you for shopping with us! Your total is " //This executes if user does not want to buy more items, it prints the total and exits to the main menu
                                            +
                                            total);
                                        System.out.println(
                                            "*********************************************************");
                                        members.get(i).setSpent(
                                            members.get(i).getTotalSpent() + total); //Updates total spent for member

                                        break;
                                    }
                                }
                                break;
                            }

                            if (choice2 == 2) {
                                System.out.println(
                                    "Were sorry you were not satisfied with premium, are you sure you want to cancel? Enter 1 for yes, 2 for no."); //Prompt that asks if user is sure they want to deactivate premium
                                int choice5 = scanner.nextInt();
                                if (choice5 == 1) {
                                    System.out.println(
                                        "Your premium membership has been deactivated.");
                                    members.get(i).setPremium(false); //Deactivating premium membership
                                    break;
                                }
                                if (choice5 == 2) {
                                    break;
                                }
                            }

                            if (choice2 == 3) {
                                System.out.println(
                                    "The membership fee is $10. Press 1 to confirm payment or 2 to exit."); // Asks member to confirm payment for renewing premium
                                int choice7 = scanner.nextInt();
                                if (choice7 == 1) {
                                    System.out.println(
                                        "Thank you for renewing your premium! Login to continue.");
                                    members.get(i).setPaid(true);
                                    members.get(i).setSpent(members.get(i).getTotalSpent() + 10); //Sets premium fee to paid and updates total spent for user
                                    break;
                                } else
                                    break;
                            }

                            if (choice2 == 4) {
                                System.out.println(
                                    "We currently accept two types of payment methods: Cash and Card." //Gives user their current pay method
                                    +
                                    " Your current pay method: " +
                                    members.get(i).getPayMethod() + "." +
                                    " Enter your preferred pay method below.");
                                scanner.nextLine();
                                String payMethod = scanner.nextLine();
                                members.get(i).setPayMethod(payMethod); //Updates pay method
                                System.out.println(
                                    "Pay method successfully updated. Select login to continue.");
                                break;
                            }
                        } else {
                            System.out.println("Welcome back " + customerName + "!"); //This is the menu for a non-premium member
                            System.out.println("Select an item from the menu to continue!");
                            System.out.println("1. Make a purchase");
                            System.out.println("2. Register as a premium member");
                        }
                        int choice2 = scanner.nextInt();
                        if (choice2 == 1) {
                            double total = 0;
                            int stockTrack = 0;

                            while (1 == 1) {
                                int counter = 1;

                                System.out.println(
                                    "Currently, we are selling the follow items: "); //This is a for loop that prints the stores product inventory for the customer to buy

                                Inventory.printProductMenu(productList); //Method that prints product menu

                                System.out.println(
                                    "What would you like to purchase? Enter the number of the item youd like to buy."); //Asking customer what item theyd like to buy
                                int choice3 = scanner.nextInt();

                                total = total + productList.get(choice3 - 1).getPrice();
                                System.out.println("Great choice! " +
                                    "The cost for " + productList.get(choice3 - 1).getTitle() +
                                    " is " +
                                    "$ " + productList.get(choice3 - 1).getPrice() +
                                    " Your current total is: " + total); //Confirms purchase and updates total

                                stockTrack = productList.get(choice3 - 1).getStock();
                                stockTrack = stockTrack - 1;
                                productList.get(choice3 - 1).setStock(stockTrack); //This subtracts stock from the purchased item

                                System.out.println("Would you like to buy more items?"); //Asking if the user would like to buy more items. If they press 1, the loop will not be broken and product menu will print again
                                System.out.println("1. Yes");
                                System.out.println("2. No, thats all");
                                int choice4 = scanner.nextInt();
                                if (choice4 == 1) {} else {
                                    System.out.println(
                                        "Thank you for shopping with us! Your total is " + total); //This executes if user does not want to buy more items, it prints the total and exits to the main menu
                                    System.out.println(
                                        "*********************************************************");
                                    members.get(i).setSpent(
                                        members.get(i).getTotalSpent() + total); //Updates total spent for member

                                    break;
                                }
                            }
                        }

                        if (choice2 == 2) { //This registers the user as a new premium member
                            System.out.println(
                                "We are glad you are interested in a premium membership! Premium members get access to exclusive products.");
                            System.out.println(
                                "Premium membership cost is $10 per month. How would you like to pay, Cash or Card?");
                            scanner.nextLine();
                            String payMethod = scanner.nextLine();
                            System.out.println("All set! You are now a premium member!");
                            members.get(i).setPayMethod(payMethod); //Updates pay method
                            members.get(i).setPremium(true); //Sets premium to true
                            members.get(i).setPaid(true); //Sets premium paid status to true
                            members.get(i).setSpent(members.get(i).getTotalSpent() + 10); //Add premium fee to total spent
                        }
                    }

                    if (!customerName.equals(members.get(i).getName()) && choice > 0) {
                        Thread.sleep(1000);
                        System.out.println(
                            "Cannot find name, please try again or register as a new member."); //This prints when the first for loop cannot find a member from the Member arraylist
                    }
                }
            }
            //This code will execute when user selects 2 from the main menu
            if (choice == 2) {
                System.out.println(
                    "Thank you for choosing our bookstore! To start registering yourself, enter your name!"); //Asking user to enter name
                scanner.nextLine();
                String newMemberName = scanner.nextLine();
                System.out.println("Welcome, " + newMemberName + "!" +
                    " Would you like to register as a premium member for $10 a month? It gives you exclusive access to our rarest products!" +
                    " Enter 1 for yes, 2 for no"); //Asking user if they want to be a premium member

                int isNewCustomerPremium = scanner.nextInt();
                if (isNewCustomerPremium == 1) {
                    System.out.println(
                        "Were glad you chose premium! What type of payment method would you prefer, Cash or card?"); //Asking for payment method if user does want to be premium
                    System.out.println(
                        "------------------------------------------------------------------------------------------");
                    scanner.nextLine();
                    String newCustomerPayMethod = scanner.nextLine();
                    Member newMember =
                        new Member(newMemberName, true, true, newCustomerPayMethod, 10); //Creates and adds a new object in the Members arraylist from the users input
                    members.add(newMember);
                    System.out.println("Your all set! Select login to continue");

                } else
                    System.out.println(
                        "No worries, you can always upgrade later! You are now registered, Select login to continue"); //Prints when user selects no for premium
                System.out.println(
                    "------------------------------------------------------------------------------------------");
                Member newMember = new Member(newMemberName, false, false, null, 0); //Creates and adds a new object in the Members arraylist from the users input
                members.add(newMember);
            }
            //This code will execute when user selects 3 from the main menu
            if (choice == 3) {
                while (1 == 1) {
                    System.out.println(
                        "Enter 4-digit admin passcode to continue, or press 2 to exit."); //Prompting user to enter the admin passcode
                    int adminPasscode = scanner.nextInt();
                    if (adminPasscode == 2) {
                        break;
                    }
                    if (adminPasscode == newAdmin.getPassword()) {
                        System.out.println("Choose from the menu: ");
                        System.out.println(
                            "1. See customer spending, premium status and dues paid/unpaid");
                        System.out.println("2. View Stock ");

                        int adminChoice = scanner.nextInt();

                        if (adminChoice == 1) {
                            for (int i = 0; i < members.size(); i++) { //This is a for loop that prints customer name, how much theyve spent, and if they are premium
                                System.out.println(" Customer name: " + members.get(i).getName() +
                                    " Total Spent:  " + members.get(i).getTotalSpent() +
                                    " Premium: " + members.get(i).getPremium());
                            }
                        }
                        if (adminChoice == 2) {
                            for (int i = 0; i < productList.size(); i++) { //This is a for loop that prints the title of each product and its stock left
                                System.out.println("Title: " + productList.get(i).getTitle() +
                                    " Stock: " + productList.get(i).getStock());
                            }
                        }

                    } else
                        System.out.println("Incorrect passcode, please try again"); //This prints when the entered passcode is wrong
                }
            }
            //This code will execute when user selects 4 from the main menu
            if (choice == 4) {
                System.out.println("Thank you for choosing us! Have a great day!"); //Exit statement
                break;
            }
            //This code will execute if user puts wrong input
            else  System.out.println("Cannot find that option :(");
        }
    }
}
