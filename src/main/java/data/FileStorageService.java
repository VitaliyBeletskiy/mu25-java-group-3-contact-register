package data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.models.Contact;

import java.io.File;
import java.util.List;

public final class FileStorageService implements StorageService {

    private final String fileName = "contacts.txt";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final File file = new File(fileName);

    @Override
    public List<Contact> load() {
        try {
            if (!file.exists()) {
                return List.of();
            }
            return objectMapper.readValue(
                    file,
                    new TypeReference<List<Contact>>() {
                    }
            );
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return List.of();
        }
    }

    @Override
    public void save(List<Contact> contacts) {
        try {
            objectMapper.writeValue(file, contacts);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
