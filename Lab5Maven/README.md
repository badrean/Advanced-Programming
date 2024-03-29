### Document Management System
Write an application that can manage a catalog of documents. An entry in this catalog might be an article, a book, etc.
A document may be located using a path in the local file system or a link to an external URL. Each document has a unique ID, a name and may have additional tags, which are pairs name-value. Example of tags may be title, author, year, publishingDate, etc.
  
The main specifications of the application are:  

---

### Compulsory (1p)

* Create an object-oriented model of the problem. You should have at least the following classes: Catalog, Document. 
Create a class responsible with external operations regarding a catalog.
* Implement the following methods representing commands that will manage the content of the catalog:
    * add: adds a new entry into the catalog;
    * toString: a textual representation of the catalog;
    * save: saves the catalog to an external file using JSON format; you may use Jackson or other library;
    * load: loads the catalog from an external file.

## Done:

* Created the necessary classes

---

### Homework (2p)

* Create an object-oriented model of the problem. You should have at least the following classes: Catalog, Document. 
Create a class responsible with external operations regarding a catalog.
* Implement the following methods representing commands that will manage the content of the catalog:
    * list: prints the list of documents on the screen;
    * view: opens a document using the native operating system application (see the Desktop class);
    * report: creates (and opens) an HTML report representing the content of the catalog.
* The application will signal invalid data or the commands that are not valid using custom exceptions.
* The final form of the application will be an executable JAR archive. Identify the generated archive and 
launch the application from the console, using the JAR.


## Done:

* Created the necessary classes, but didn't do the HTML report
