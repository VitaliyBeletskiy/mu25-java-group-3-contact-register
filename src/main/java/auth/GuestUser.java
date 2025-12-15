package auth;

public final class GuestUser extends User {
    public GuestUser() {
        super(Role.GUEST);
    }
}
