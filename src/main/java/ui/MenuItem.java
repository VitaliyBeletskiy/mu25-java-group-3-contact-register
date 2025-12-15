package ui;

import auth.User;

import java.util.function.Predicate;

public record MenuItem(
        String key,
        String title,
        Predicate<User> isAllowed,
        Runnable action
) {
}
