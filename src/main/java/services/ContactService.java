package services;

import data.models.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {

    List<Contact> getAllContacts();

    void createContact(Contact contact);

    void updateContact(Contact contact);

    void deleteContact(Contact contact);

    Optional<Contact> searchByLastName(String lastName);

    List<Contact> searchByFirstName(String firstName);

    List<Contact> searchByStreet(String street);

    List<Contact> freeSearch(String query);
}
