import di.ServiceLocator;
import ui.ConsoleUi;

public class Main {
    public static void main(String[] args) {
        ConsoleUi console = ServiceLocator.provideConsoleUi();
        console.start();
    }
}
