package u1ex02b;

import java.io.IOException;
import java.text.AttributedCharacterIterator.Attribute;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class LibroHandler extends DefaultHandler {
    private StringBuilder value;

    public LibroHandler() {
        this.value = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attribute attribute) throws SAXException {
        this.value.setLength(0);
        if (qName.equals("libro")) {
            String añoString = attributes.getValue("año");
            System.out.println("Atributo año: " + añoString);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        this.value.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String qName, String localName) throws SAXException {
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
            parser.parse("libro.xml", handler);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}