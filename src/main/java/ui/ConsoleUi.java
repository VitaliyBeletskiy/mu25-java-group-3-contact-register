package ui;

import auth.AdminUser;
import auth.GuestUser;
import auth.User;

import services.ContactService;
import data.models.Contact;
import data.models.Address;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public final class ConsoleUi {

    private User currentUser;
    private final Scanner scanner = new Scanner(System.in);
    private final ContactService contactService;
    private final List<MenuItem> loginMenu = List.of(
            new MenuItem("1", "Guest User", u -> true, () -> currentUser = new GuestUser()),
            new MenuItem("2", "Admin User", u -> true, () -> currentUser = new AdminUser()),
            new MenuItem("quit", "Exit Program", u -> true, () -> System.exit(0))
    );
    private final List<MenuItem> mainMenu = List.of(
            new MenuItem("1", "Print all contacts", u -> true, this::handlePrintAllContacts),
            new MenuItem("2", "Search by last name", u -> true, () -> handleSearch(SearchType.BY_LAST_NAME)),
            new MenuItem("3", "Search by first name", u -> true, () -> handleSearch(SearchType.BY_FIRST_NAME)),
            new MenuItem("4", "Search by street name", u -> true, () -> handleSearch(SearchType.BY_STREET)),
            new MenuItem("5", "Free search", u -> true, () -> handleSearch(SearchType.FREE)),
            new MenuItem("6", "Create new contact", User::isAdmin, this::createNewContact),
            new MenuItem("7", "Update existing contact", User::isAdmin, () -> {
            }),
            new MenuItem("8", "Delete contact", User::isAdmin, this::deleteContact),
            new MenuItem("quit", "Exit program", u -> true, () -> System.exit(0))
    );

    public ConsoleUi(ContactService contactService) {
        this.contactService = contactService;
    }

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

    private void createNewContact() {
        println("");
        println("=== Create New Contact ===");

        println("Enter first name:");
        String firstName = getStringInput();

        println("Enter last name:");
        String lastName = getStringInput();

        println("Enter age:");
        int age = getAgeInput();

        println("Enter street name:");
        String streetName = getStringInput();

        println("Enter house number:");
        String houseNumber = getStringInput();

        println("Enter postal code:");
        String postalCode = getStringInput();

        println("Enter city:");
        String city = getStringInput();

        println("Enter phone numbers (comma separated):");
        List<String> phoneNumbers = getStringListInput();

        contactService.createContact(
                new Contact(
                        firstName,
                        lastName,
                        age,
                        new Address(
                                streetName,
                                houseNumber,
                                postalCode,
                                city
                        ),
                        phoneNumbers
                )
        );

        println("Contact created successfully.");
        println("");
    }

    private void deleteContact() {
        println("=== Delete Contact ===");
        println("Enter last name of contact to delete:");

        String lastName = getNonEmptyStringInput();
        Contact contact = contactService.searchByLastName(lastName).orElse(null);

        if (contact == null) {
            println("No contact found with that last name.");
            return;
        }

        println("Contact found:");
        printContact(contact, 1);

        println("Are you sure you want to delete this contact? (yes/no)");
        print("> ");
        String confirmation = scanner.nextLine().trim().toLowerCase();

        if (confirmation.equals("yes")) {
            contactService.deleteContact(contact);
            println("Contact deleted successfully.");
        } else {
            println("Delete cancelled.");
        }

        waitForEnter();
    }

    private void handleSearch(SearchType searchType) {
        println("");
        println("=== " + searchType.title() + " ===");
        println("Enter search query:");
        String query = getNonEmptyStringInput();
        List<Contact> result = switch (searchType) {
            case BY_LAST_NAME -> {
                Contact c = contactService.searchByLastName(query).orElse(null);
                yield c == null ? List.of() : List.of(c);
            }
            case BY_FIRST_NAME -> contactService.searchByFirstName(query);
            case BY_STREET -> contactService.searchByStreet(query);
            case FREE -> contactService.freeSearch(query);
        };
        println("");
        println("Search results:");
        if (result.isEmpty()) {
            println("");
            println("No contact found.");
            println("");
        } else {
            printContacts(result);
        }
        waitForEnter();
    }

    private void handlePrintAllContacts() {
        List<Contact> contacts = contactService.getAllContacts();
        printContacts(contacts);
    }

    private void printContacts(List<Contact> contacts) {
        if (contacts.isEmpty()) {
            println("Contact list is empty.");
            return;
        }

        for (int i = 0; i < contacts.size(); i++) {
            printContact(contacts.get(i), i + 1);
        }
    }

    private void printContact(Contact c, int number) {
        println("");
        println(number + ":");
        println(c.firstName() + " " + c.lastName() + ", " + c.age() + " years old");
        println(c.address().street() + " " + c.address().house() + ", " + c.address().postalCode() + " " + c.address().city());
        println("Phones: " + String.join(", ", c.phoneNumbers()));
        println("");
    }

    private String getStringInput() {
        print("> ");
        String input = scanner.nextLine();
        return input == null ? "" : input.strip();
    }

    private String getNonEmptyStringInput() {
        while (true) {
            print("> ");
            String input = scanner.nextLine().strip();
            if (input.isEmpty()) {
                println("Input cannot be empty. Please try again.");
            } else {
                return input;
            }
        }
    }

    private int getAgeInput() {
        while (true) {
            print("> ");
            try {
                int age = Integer.parseInt(scanner.nextLine().strip());
                if (age < 0 || age > 130) throw new IllegalArgumentException();
                return age;
            } catch (Exception e) {
                println("Enter a valid age.");
            }
        }
    }

    private List<String> getStringListInput() {
        print("> ");
        String input = scanner.nextLine().strip();
        if (input.isEmpty()) return List.of();

        return Arrays.stream(input.split(","))
                .map(String::strip)
                .filter(s -> !s.isEmpty())
                .toList();
    }

    private void println(String msg) {
        System.out.println(msg);
    }

    private void print(String msg) {
        System.out.print(msg);
    }

    private void waitForEnter() {
        print("Press Enter to return to the menu...");
        scanner.nextLine();
    }
}
