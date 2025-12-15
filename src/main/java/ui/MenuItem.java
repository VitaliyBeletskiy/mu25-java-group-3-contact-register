package ui;

public record MenuItem(
        String key,
        String title,
        Runnable action
) {
}
