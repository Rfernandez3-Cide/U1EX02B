package u1ex02b;

import java.io.IOException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class LibroHandler extends DefaultHandler {
    private StringBuilder value = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        value.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        value.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "libro":
                System.out.println("");
                break;
            case "título":
                System.out.println("Título del libro: " + this.value.toString());
                break;
            case "apellido":
                System.out.println("Apellido del autor: " + this.value.toString());
                break;
            case "nombre":
                System.out.println("Nombre del autor: " + this.value.toString());
                break;
            case "editiorial":
                System.out.println("Editiorial del libro: " + this.value.toString());
                break;
            case "precio":
                System.out.println("Precio del libro: " + this.value.toString());
                break;
        }
    }
}

public class Principal {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            LibroHandler handler = new LibroHandler();
            parser.parse("libros.xml", handler);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
