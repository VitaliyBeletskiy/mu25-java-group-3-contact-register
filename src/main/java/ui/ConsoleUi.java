package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class ConsoleUi {

    private Scanner scanner = new Scanner(System.in);
    private final List<MenuItem> loginMenu = List.of(
            new MenuItem("1", "Guest User", () -> {

            }),
            new MenuItem("2", "Admin User", () -> {

            }),
            new MenuItem("quit", "Exit Program", () -> {

            })
    );
    private final List<MenuItem> mainMenu = List.of(
            new MenuItem("1", "Search by last name", () -> {

            }),
            new MenuItem("2", "Search by first name", () -> {

            }),
            new MenuItem("3", "Search by street name", () -> {


            }),
            new MenuItem("4", "Free search", () -> {


            }),
            new MenuItem("5", "Create new contact", () -> {


            })
            , new MenuItem("6", "Update existing contact", () -> {


            }),
            new MenuItem("7", "Delete contact", () -> {


            }),
            new MenuItem("8", "Print all contacts", () -> {


            }),
            new MenuItem("quit", "Exit program", () -> {


            })
    );


    public void showLoginMenu() {
        println("============================");
        println("=     Select User role     =");
        println("============================");
        loginMenu.forEach(i -> println(i.key() + ": " + i.title()));
        println("============================");
    }

    public void showMainMenu() {
        println("============================");
        println("=        Main Menu         =");
        println("============================");
        mainMenu.forEach(i -> println(i.key() + ": " + i.title()));
        println("============================");
    }

    private void println(String msg) {
        System.out.println(msg);
    }


}
