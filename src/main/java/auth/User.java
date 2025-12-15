package auth;

public abstract class User {
    private final Role role;

    protected User(Role role) {
        this.role = role;
    }

    public boolean isAdmin() {
        return role.equals(Role.ADMIN);
    }
}
