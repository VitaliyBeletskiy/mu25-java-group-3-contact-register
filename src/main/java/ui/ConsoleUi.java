package ui;

import java.util.Scanner;

public final class ConsoleUi {

    private Scanner scanner = new Scanner(System.in);

    public void loginMenu() {
        System.out.println("=== Login Menu ===");
        System.out.println("choose an option:");
        System.out.println("1) Guest");
        System.out.println("2) Administrator");
        System.out.println("quit) Exit program");

        String loginChoice = scanner.nextLine().trim().toLowerCase();

        if (loginChoice.equals("1")) {
        } else if (loginChoice.equals("2")) {
        } else if (loginChoice.equalsIgnoreCase("quit")) {
            System.exit(0);
        } else {
            System.out.println("invalid input, try again.");
        }
    }
}