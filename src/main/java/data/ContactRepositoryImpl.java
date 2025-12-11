package data;

import data.models.Contact;

import java.util.ArrayList;
import java.util.List;

public final class ContactRepositoryImpl implements ContactRepository {

    private static ContactRepositoryImpl instance;

    private final StorageService storageService;
    private final List<Contact> cache;

    private ContactRepositoryImpl(StorageService storageService) {
        this.storageService = storageService;
        this.cache = new ArrayList<>(storageService.load());
    }

    @Override
    public List<Contact> getAll() {
        return List.copyOf(cache);
    }

    @Override
    public void add(Contact contact) {
        cache.add(contact);
        storageService.save(cache);
    }

    @Override
    public void update(Contact contact) {
        for (int i = 0; i < cache.size(); i++) {
            if (cache.get(i).id().equals(contact.id())) {
                cache.set(i, contact);
                storageService.save(cache);
                return;
            }
        }
    }

    @Override
    public void delete(Contact contact) {
        cache.remove(contact);
        storageService.save(cache);
    }

    public static ContactRepositoryImpl getInstance(StorageService storageService) {
        if (instance == null) {
            instance = new ContactRepositoryImpl(storageService);
        }
        return instance;
    }
}
