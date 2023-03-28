package homework;

import compulsory.Catalog;
import homework.exceptions.EmptyDocumentListException;
import jdk.jshell.DeclarationSnippet;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

public class ViewCommand implements Command {
    @Override
    public void executeCommand(Catalog catalog) {
        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            return;
        }

        Scanner userInput = new Scanner(System.in);
        System.out.println("List of documents:\n" + catalog.getDocuments());
        System.out.println("Please enter the ID of the document you want to open");

        String idUserInput = userInput.nextLine();
        int id = Integer.parseInt(idUserInput);
        try {
            if(catalog.getDocuments().size() == 0) {
                throw new EmptyDocumentListException("The document list is empty");
            }
            if(id < 0 || id > catalog.getDocuments().size()) {
                throw new java.lang.IndexOutOfBoundsException("Please enter a valid id");
            }
        } catch (IndexOutOfBoundsException | EmptyDocumentListException exception) {
            exception.printStackTrace();
        }

        File file;
        String sourceType;
        if(catalog.getDocuments().get(id).getPath().length() == 0) {
            file = new File(catalog.getDocuments().get(id).getLink());
            sourceType = "link";
        }
        else {
            file = new File(catalog.getDocuments().get(id).getPath());
            sourceType = "path";
        }

        Desktop desktop = Desktop.getDesktop();
        if (sourceType.equals("path")) {
            try {
                if (file.exists()) desktop.open(file);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        else {
            try {
                desktop.browse(new URI(file.getPath()));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

    }
}
