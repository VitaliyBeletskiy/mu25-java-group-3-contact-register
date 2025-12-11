package data;

import data.models.Contact;

import java.util.List;

public interface ContactRepository {
    List<Contact> getAll();

    void add(Contact contact);

    void update(Contact contact);

    void delete(Contact contact);
}
