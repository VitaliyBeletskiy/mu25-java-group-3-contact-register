package ui;

import java.util.Scanner;

public final class ConsoleUi {

    private Scanner scanner = new Scanner(System.in);

    public void loginMenu() {
        while (true) {
            showLoginMenuOptions();

            String choice = scanner.nextLine().trim().toLowerCase();
            switch (choice) {
                case "1":
                    System.out.println("Guest login selected");
                    showGuestMenu();
                    break;
                case "2":
                    System.out.println("Admin login selected");
                    showAdminMenu();
                    break;
                case "quit":
                    System.out.println("goodbye");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input, try again");
            }
        }
    }

    private void showLoginMenuOptions() {
        System.out.println("=== Login Menu ===");
        System.out.println("Choose an option:");
        System.out.println("1) Guest");
        System.out.println("2) Administrator");
        System.out.println("quit) Exit program");
    }

    private void showMainMenu(boolean isAdmin) {
        System.out.println(isAdmin ? "===Admin Menu===" : "===Guest menu===");
        System.out.println("Choose an option:");
        System.out.println("1) Search by last name");
        System.out.println("2) Search by first name");
        System.out.println("3) Search by street name");
        System.out.println("4) Free search");

        if (isAdmin) {
            System.out.println("5) Create new contact");
            System.out.println("6) Update existing contact");
            System.out.println("7) Delete Contact");
        }
        System.out.println("quit) Exit program");
    }

    private void showGuestMenu() {
        while (true) {
            showMainMenu(false);
            String choice = scanner.nextLine().trim().toLowerCase();

            switch (choice) {
                case "1":
                    System.out.println(" Enter last name:");
                    break;
                case "2":
                    System.out.println("Enter first name:");
                    break;
                case "3":
                    System.out.println("Enter street name:");
                    break;
                case "4":
                    System.out.println("Free search:");
                    break;
                case "quit":
                    System.out.println("quit) Exit program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input, try again");
            }
        }
    }

    public void showAdminMenu() {
        while (true) {
            showMainMenu(true);
            String choice = scanner.nextLine().trim().toLowerCase();
            switch (choice) {
                case "1":
                    System.out.println("Enter last name:");
                    break;
                case "2":
                    System.out.println("Enter first name:");
                    break;
                case "3":
                    System.out.println("Enter street name:");
                    break;
                case "4":
                    System.out.println("Free search:");
                    break;
                case "5":
                    System.out.println("Create new contact");
                    break;
                case "6":
                    System.out.println("Update existing contact");
                    break;
                case "7":
                    System.out.println("Delete Contact ");
                    break;
                case "quit":
                    System.out.println("quit) Exit program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input, try again");
            }
        }
    }


}
