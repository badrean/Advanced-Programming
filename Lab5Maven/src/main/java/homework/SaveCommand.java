package homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import compulsory.Catalog;

import java.io.File;
import java.io.IOException;

public class SaveCommand implements Command {
    @Override
    public void executeCommand(Catalog catalog) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("Catalog.json"), catalog.getDocuments());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
