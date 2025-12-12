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
}
