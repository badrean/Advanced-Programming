package homework;

import compulsory.Catalog;
import compulsory.Document;
import compulsory.Keys;
import homework.exceptions.*;

import java.time.LocalDate;
import java.time.Year;
import java.util.Scanner;

public class AddCommand implements Command {
    @Override
    public void executeCommand(Catalog catalog) {
        Scanner userInput = new Scanner(System.in);
        String name = "";
        String path = "";
        String link = "";

        try {
            System.out.println("Adding Book\nTitle:");
            name = userInput.nextLine(); //trb sa existe un nume
            if (name.length() == 0) {
                throw new UnnamedBookException("The book name field cannot be empty");
            }

            System.out.println("Path:");
            path = userInput.nextLine(); //trb sa existe macar un path sau link
            System.out.println("Link:");
            link = userInput.nextLine();
            if (path.length() == 0 && link.length() == 0) {
                throw new NoPathLinkException("A path or link must be specified");
            }
        } catch (NoPathLinkException | UnnamedBookException exception) {
            exception.printStackTrace();
        }

        if(name.length() == 0 || (path.length() == 0 && link.length() == 0)) {
            System.out.println("Cannot create Document with the given parameters");
            return;
        }

        String author = "";
        int year = 0;
        double price = 0;

        try {
            System.out.println("Please enter the following details if known:\nAuthor:"); //must be alphabetical
            author = userInput.nextLine();
            if(!author.matches("[a-zA-Z]+") && author.length() > 0){
                throw new InvalidAuthorNameException("Author name must only contain alphabetical characters");
            }

            System.out.println("Publishing year:"); //must be an int and valid year
            String yearUserInput = userInput.nextLine();

            if(yearUserInput.length() > 0)
                year = Integer.parseInt(yearUserInput);
            int currYear = LocalDate.now().getYear();
            if ((year < 1600 || year > currYear) && yearUserInput.length() != 0) {
                throw new InvalidYearException("Please enter a valid year");
            }

            System.out.println("Price:"); //must be a greater than 0
            String priceUserInput = userInput.nextLine();

            if(yearUserInput.length() > 0)
                price = Double.parseDouble(priceUserInput);
            if (price <= 0 && priceUserInput.length() != 0) {
                throw new InvalidPriceException("Price must be greater than 0");
            }
        } catch (InvalidAuthorNameException | InvalidYearException | InvalidPriceException exception) {
            exception.printStackTrace();
        }

        Document document = new Document(name, path, link);

        if (author.length() > 0 && author.matches("[a-zA-Z]+")) {
            document.addTag(Keys.AUTHOR, author);
        }

        int currYear = LocalDate.now().getYear();
        if (1600 <= year && year <= currYear ) {
            document.addTag(Keys.YEAR, Integer.toString(year));
        }

        if (price > 0) {
            document.addTag(Keys.PRICE, Double.toString(price));
        }

        catalog.getDocuments().add(document);
    }
}
