package ui;

import auth.AdminUser;
import auth.GuestUser;
import auth.User;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public final class ConsoleUi {

    private User currentUser;
    private final Scanner scanner = new Scanner(System.in);
    private final List<MenuItem> loginMenu = List.of(
            new MenuItem("1", "Guest User", u -> true, () -> currentUser = new GuestUser()),
            new MenuItem("2", "Admin User", u -> true, () -> currentUser = new AdminUser()),
            new MenuItem("quit", "Exit Program", u -> true, () -> System.exit(0))
    );
    private final List<MenuItem> mainMenu = List.of(
            new MenuItem("1", "Print all contacts", u -> true, () -> {
            }),
            new MenuItem("2", "Search by last name", u -> true, () -> {
            }),
            new MenuItem("3", "Search by first name", u -> true, () -> {
            }),
            new MenuItem("4", "Search by street name", u -> true, () -> {
            }),
            new MenuItem("5", "Free search", u -> true, () -> {
            }),
            new MenuItem("6", "Create new contact", User::isAdmin, () -> {
            })
            , new MenuItem("7", "Update existing contact", User::isAdmin, () -> {
            }),
            new MenuItem("8", "Delete contact", User::isAdmin, () -> {
            }),
            new MenuItem("quit", "Exit program", u -> true, () -> System.exit(0))
    );

    public void start() {
        showLoginMenu();

        while (true) {
            showMainMenu();
        }
    }

    private void showLoginMenu() {
        println("============================");
        println("=     Select User role     =");
        println("============================");
        loginMenu.forEach(i -> println(i.key() + ": " + i.title()));
        println("============================");

        MenuItem selectedMenuItem = selectMenuItem(loginMenu);
        selectedMenuItem.action().run();
    }

    private void showMainMenu() {
        println("============================");
        println("=        Main Menu         =");
        println("============================");
        for (MenuItem item : mainMenu) {
            if (item.isAllowed().test(currentUser)) {
                println(item.key() + ": " + item.title());
            }
        }
        println("============================");

        MenuItem selectedMenuItem = selectMenuItem(mainMenu);
        selectedMenuItem.action().run();
    }

    private MenuItem selectMenuItem(List<MenuItem> currentMenu) {
        Set<String> possibleChoices = new HashSet<>(currentMenu.stream().map(ui.MenuItem::key).toList());
        String selectedKey;

        while (true) {
            println("Enter number or type 'quit' to exit the app.");
            print("> ");
            String input = scanner.nextLine().toLowerCase().strip();
            if (possibleChoices.contains(input.strip())) {
                selectedKey = input;
                break;
            }
            println("Invalid input, try again.");
        }
        return currentMenu.stream()
                .filter(item -> item.key().equals(selectedKey))
                .findFirst().orElseThrow();
    }

    private void println(String msg) {
        System.out.println(msg);
    }

    private void print(String msg) {
        System.out.print(msg);
    }
}
