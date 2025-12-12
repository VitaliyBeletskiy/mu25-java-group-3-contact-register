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

    private void showGuestMenuOptions() {
        System.out.println("=== Guest Menu ===");
        System.out.println("Choose an option:");
        System.out.println("1) Search by last name");
        System.out.println("2) Search by first name");
        System.out.println("3) Search by street name");
        System.out.println("4) Free search");
        System.out.println("5) Go back");
        System.out.println("quit) Exit program");
    }

    public void showGuestMenu() {
        while (true) {
            showGuestMenuOptions();

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
                    System.out.println(" Free search:");
                    break;
                case "5":
                    return;
                case "quit":
                    System.exit(0);
                default:
                    System.out.println("Invalid input, try again");
            }
        }
    }


}
