package compulsory;

import java.io.FileOutputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Lab5Main {
    public static void main(String[] args) {
        CatalogController catalog = new CatalogController();
        Document document1 = new Document("Un nume frumos", "../sigur_e_aici/", "www.namlink.com");
        Document document2 = new Document("Alt nume frumos", "../sigur_nue_aici/", "www.namlinkiar.com");
        Document document3 = new Document("Inca un nume", "../nupls/", "www.da.com");
        document1.addTag(Keys.AUTHOR, "Tiganus Ricardo");
        document1.addTag(Keys.PUBLISHING_DATE, "19/10/2020");
        document2.addTag(Keys.AUTHOR, "Tiganus Altul");

        catalog.addDocument(document1);
        catalog.addDocument(document2);
        catalog.addDocument(document3);


        File file = new File("Catalog.json");
        catalog.saveCatalog(file);

        CatalogController altCatalog = new CatalogController();
        altCatalog.loadCatalog(file);
        System.out.println(altCatalog);
    }
}
