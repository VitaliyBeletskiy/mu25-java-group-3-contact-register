package services;

import data.models.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> getAllContacts();

    void createContact(Contact contact);

    void updateContact(Contact contact);

    void deleteContact(Contact contact);

    Contact searchByLastName(String lastName);

    List<Contact> searchByFirstName(String firstName);

    List<Contact> searchByStreet(String street);

    List<Contact> freeSearch(String query);
}
