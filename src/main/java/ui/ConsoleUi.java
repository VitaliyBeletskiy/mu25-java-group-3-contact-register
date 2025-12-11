package ui;

import java.util.Scanner;

public class ConsoleUi {

    private Scanner scanner = new Scanner(System.in);

    public void showMainMenu() {
        System.out.println("=== Main Menu ===");
        System.out.println("choose an option:");
        System.out.println("1) Guest");
        System.out.println("2) Administrator");
        System.out.println("quit) Exit program");
    }
}