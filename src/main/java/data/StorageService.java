package data;

import data.models.Contact;

import java.util.List;

public interface StorageService {
    List<Contact> load();

    void save(List<Contact> contacts);
}
