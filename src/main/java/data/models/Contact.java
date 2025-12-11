package data.models;

import java.util.List;
import java.util.UUID;

public record Contact(
        String id,
        String firstName,
        String lastName,
        int age,
        Address address,
        List<String> phoneNumbers
) {
    // Constructor for creating new contacts (not used when loading from storage)
    public Contact(String firstName, String lastName, int age, Address address, List<String> phoneNumbers) {
        this(UUID.randomUUID().toString(), firstName, lastName, age, address, phoneNumbers);
    }

    public boolean contains(String query) {
        String q = query.toLowerCase();

        return firstName.toLowerCase().contains(q)
                || lastName.toLowerCase().contains(q)
                || address.contains(q)
                || phoneNumbers.stream().anyMatch(p -> p.contains(q));
    }
}
