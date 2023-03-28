package compulsory;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Catalog {

    private List<Document> documents;
    public Catalog(){
        documents = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "documents=" + documents +
                '}';
    }

    public List<Document> getDocuments() {
        return documents;
    }

//    public void add(Document document){
//        this.documents.add(document);
//    }
//
//    public void save(File file){
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, this.documents);
//        } catch (IOException exception){
//            exception.printStackTrace();
//        }
//    }
//
//     public void load(File file){
//         ObjectMapper objectMapper = new ObjectMapper();
//         try {
//             this.documents = objectMapper.readValue(file, new TypeReference<List<Document>>() {});
//         } catch (IOException exception) {
//             exception.printStackTrace();
//         }
//     }
}
