package homework;

import compulsory.Catalog;

public class ListCommand implements Command {
    @Override
    public void executeCommand(Catalog catalog) {
        System.out.println(catalog);
    }
}
