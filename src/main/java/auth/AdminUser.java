package auth;

public final class AdminUser extends User {
    public AdminUser() {
        super(Role.ADMIN);
    }
}
