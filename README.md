# U1EX02B


This Java program reads data from an XML file containing information about books.
It uses the SAX parser to process the XML and writes the extracted information into separate text files, one per publication year.
For each book, the program retrieves the title, the author's first and last name, the publisher, the price, and the publication year, displaying this information on the console and saving it in text files named books_YYYY.txt.


Operating system: Windows


IDE: Visual Studio Code (VSCode)


Java version used: 

Java(TM) SE Runtime Environment (build 1.8.0_461-b11)

Java HotSpot(TM) 64-Bit Server VM (build 25.461-b11, mixed mode)


Libraries used:

javax.xml.parsers for SAXParser
org.xml.sax for XML element handling


Execution instructions

Place the files Books.java and books.xml in the same directory.


Book information will be displayed on the console and a text file will be created for each year, named books_YEAR.txt.

Each run appends new information to the existing files for the corresponding year.