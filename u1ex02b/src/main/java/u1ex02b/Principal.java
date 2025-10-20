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

class LibroHandler extends DefaultHandler {
    private StringBuilder value = new StringBuilder();
    private String añoActual;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        value.setLength(0);

        if (qName.equals("libro")) {
            añoActual = attributes.getValue("año");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        value.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String texto = value.toString();
        switch (qName) {
            case "libro":
                System.out.println("");
                break;
            case "titulo":
                System.out.println("Título del libro: " + texto);
                Principal.escribirTxt(añoActual, "Título del libro: " + texto);
                break;
            case "apellido":
                System.out.println("Apellido del autor: " + texto);
                Principal.escribirTxt(añoActual, "Apellido del autor: " + texto);
                break;
            case "nombre":
                System.out.println("Nombre del autor: " + texto);
                Principal.escribirTxt(añoActual, "Nombre del autor: " + texto);
                break;
            case "editorial":
                System.out.println("Editorial del libro: " + texto);
                Principal.escribirTxt(añoActual, "Editorial del libro: " + texto);
                break;
            case "precio":
                System.out.println("Precio del libro: " + texto);
                Principal.escribirTxt(añoActual, "Precio del libro: " + texto);
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

    public static void escribirTxt(String año, String contenido) {
        String nombreFichero = "libros_" + año + ".txt";

        try (PrintWriter out = new PrintWriter(new FileWriter(nombreFichero, true))) {
            out.println(contenido);
        } catch (IOException e) {
            System.out.println("Error escribiendo el fichero para el año " + año);
            e.printStackTrace();
        }
    }

}
