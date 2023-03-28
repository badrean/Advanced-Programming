package homework;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import compulsory.Catalog;
import compulsory.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LoadCommand implements Command {
    @Override
    public void executeCommand(Catalog catalog) {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            List<Document> documentList = objectMapper.readValue(new File("Catalog.json"), new TypeReference<List<Document>>(){});
            catalog.getDocuments().addAll(documentList);
        } catch(IOException exception) {
            exception.printStackTrace();
        }
    }

    /*
        public void load(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Document> loadedDocuments = objectMapper.readValue(new File(fileName), new TypeReference<List<Document>>(){});
            this.documents = loadedDocuments;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     */
}
