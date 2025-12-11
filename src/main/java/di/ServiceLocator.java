package di;

import data.ContactRepository;
import data.ContactRepositoryImpl;
import data.FileStorageService;
import data.StorageService;

public final class ServiceLocator {

    private static StorageService storageService;
    private static ContactRepository contactRepository;

    private ServiceLocator() {
    }

    private static StorageService provideStorageService() {
        if (storageService == null) {
            storageService = new FileStorageService();
        }
        return storageService;
    }


    public static ContactRepository provideContactRepository() {
        if (contactRepository == null) {
            contactRepository = ContactRepositoryImpl.getInstance(provideStorageService());
        }
        return contactRepository;
    }
}
