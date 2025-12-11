package data.models;

public record Address(
        String street,
        String house,
        String city,
        String postalCode
) {
    public boolean contains(String query) {
        String q = query.toLowerCase();

        return street.toLowerCase().contains(q)
                || house.toLowerCase().contains(q)
                || city.toLowerCase().contains(q)
                || postalCode.toLowerCase().contains(q);
    }
}
