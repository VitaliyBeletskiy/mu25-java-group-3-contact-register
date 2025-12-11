package di;

import data.ContactRepository;
import data.ContactRepositoryImpl;
import data.FileStorageService;
import data.StorageService;
import services.ContactService;
import services.ContactServiceImpl;

public final class ServiceLocator {

    private static StorageService storageService;
    private static ContactRepository contactRepository;
    private static ContactService contactService;

    private ServiceLocator() {
        // private constructor
    }

    private static StorageService provideStorageService() {
        if (storageService == null) {
            storageService = new FileStorageService();
        }
        return storageService;
    }


    private static ContactRepository provideContactRepository() {
        if (contactRepository == null) {
            contactRepository = ContactRepositoryImpl.getInstance(provideStorageService());
        }
        return contactRepository;
    }

    public static ContactService provideContactService() {
        if (contactService == null) {
            contactService = new ContactServiceImpl(provideContactRepository());
        }
        return contactService;
    }
}
