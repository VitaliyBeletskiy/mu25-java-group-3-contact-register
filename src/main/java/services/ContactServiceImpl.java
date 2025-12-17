package services;

import data.ContactRepository;
import data.models.Contact;

import java.util.List;
import java.util.Optional;

public final class ContactServiceImpl implements ContactService {

    private final ContactRepository repo;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.repo = contactRepository;
    }

    @Override
    public List<Contact> getAllContacts() {
        return repo.getAll();
    }

    @Override
    public void createContact(Contact contact) {
        repo.add(contact);
    }

    @Override
    public void updateContact(Contact contact) {
        repo.update(contact);
    }

    @Override
    public void deleteContact(Contact contact) {
        repo.delete(contact);
    }

    @Override
    public Optional<Contact> searchByLastName(String lastName) {
        return repo.getAll().stream()
                .filter(c -> c.lastName().equalsIgnoreCase(lastName))
                .findFirst();
    }

    @Override
    public List<Contact> searchByFirstName(String firstName) {
        return repo.getAll().stream()
                .filter(c -> c.firstName().equalsIgnoreCase(firstName))
                .toList();
    }

    @Override
    public List<Contact> searchByStreet(String street) {
        return repo.getAll().stream()
                .filter(c -> c.address().street().equalsIgnoreCase(street))
                .toList();
    }

    @Override
    public List<Contact> freeSearch(String query) {
        return repo.getAll().stream()
                .filter(c -> c.contains(query))
                .toList();
    }
}
