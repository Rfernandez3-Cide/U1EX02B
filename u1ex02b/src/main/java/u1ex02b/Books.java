// Roberto Fernández del Barrio.//
// 43232819H....................//
// 22/10/2025...................//

package u1ex02b;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

// Class that defines how the XML file will be processed
class BookHandler extends DefaultHandler {
    // Accumulator for the text found inside the XML tags
    private StringBuilder value = new StringBuilder();
    // Variable to store the current book's year (attribute of <book>)
    private String currentYear;

    // Called when a new XML element starts
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Clear the StringBuilder content before reading new text
        value.setLength(0);

        // If the element is <book>, get its "year" attribute
        if (qName.equals("book")) {
            currentYear = attributes.getValue("year");
        }
    }

    // Called when character data is found inside an element
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Append the text to the StringBuilder
        value.append(ch, start, length);
    }

    // Called when an element ends
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Convert the accumulated content to a string
        String text = value.toString();

        // Perform actions depending on the element name
        switch (qName) {
            case "book":
                // Print an empty line when a book ends
                System.out.println("");
                break;

            case "title":
                // Print and save the book title
                System.out.println("Book title: " + text);
                Books.writeTxt(currentYear, "Book title: " + text);
                break;

            case "lastname":
                // Print and save the author's last name
                System.out.println("Author's last name: " + text);
                Books.writeTxt(currentYear, "Author's last name: " + text);
                break;

            case "firstname":
                // Print and save the author's first name
                System.out.println("Author's first name: " + text);
                Books.writeTxt(currentYear, "Author's first name: " + text);
                break;

            case "publisher":
                // Print and save the publisher
                System.out.println("Book publisher: " + text);
                Books.writeTxt(currentYear, "Book publisher: " + text);
                break;

            case "price":
                // Print and save the book price
                System.out.println("Book price: " + text);
                Books.writeTxt(currentYear, "Book price: " + text);
                break;
        }
    }
}

// Main class of the program
public class Books {
    public static void main(String[] args) {
        try {
            // Create a SAX parser factory
            SAXParserFactory factory = SAXParserFactory.newInstance();
            // Obtain a SAX parser from the factory
            SAXParser parser = factory.newSAXParser();
            // Create an instance of the handler defined above
            BookHandler handler = new BookHandler();
            // Parse the "books.xml" file using the handler
            parser.parse("books.xml", handler);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            // Handle and print possible errors during parsing
            System.out.println("Error: " + ex.getMessage());
        }
    }

    // Method to write content to a text file
    public static void writeTxt(String year, String content) {
        // Create a filename based on the book's year
        String fileName = "books_" + year + ".txt";

        // Use try-with-resources to automatically close the file
        try (PrintWriter out = new PrintWriter(new FileWriter(fileName, true))) {
            // Write the line into the text file
            out.println(content);
        } catch (IOException e) {
            // Print an error message if the writing fails
            System.out.println("Error writing file for year " + year);
            e.printStackTrace();
        }
    }
}
