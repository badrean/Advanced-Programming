package homework;

import compulsory.Catalog;
import compulsory.Document;

public class MainLab5Hw {
    public static void main(String[] args) {
        Command addCommand = new AddCommand();
        SaveCommand saveCommand = new SaveCommand();
        LoadCommand loadCommand = new LoadCommand();
        ListCommand listCommand = new ListCommand();
        ViewCommand viewCommand = new ViewCommand();
        Catalog catalog = new Catalog();

        catalog.getDocuments().add(new Document("Ip Sem 2", "/Users/adrian/Downloads/IP sem2.pdf", ""));
        catalog.getDocuments().add(new Document("Lab 5 page", "", "https://profs.info.uaic.ro/~acf/java/labs/lab_05.html"));
        catalog.getDocuments().add(new Document("Wikipedia Page", "", "https://en.wikipedia.org/wiki/Web_template_system"));
//        addCommand.executeCommand(catalog);
//        addCommand.executeCommand(catalog);
        Catalog anotherCatalog = new Catalog();
        saveCommand.executeCommand(catalog);
        loadCommand.executeCommand(anotherCatalog);
        System.out.println("Loaded catalog:\n" + anotherCatalog);

        listCommand.executeCommand(catalog);
        viewCommand.executeCommand(catalog);

//        Desktop desktop = Desktop.getDesktop();
//        try {
//            desktop.browse(new URI("https://en.wikipedia.org/wiki/Web_template_system"));
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }
    }
}
