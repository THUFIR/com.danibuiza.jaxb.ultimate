package net.bounceme.dur.jaxb.hello.world;

import com.danibuiza.jaxb.ultimate.business.Countries;
import java.net.URI;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Logger;

public class App {

    private static final Logger LOG = Logger.getLogger(App.class.getName());
    private Properties properties = new Properties();
    private Countries myNotes = null;

    public static void main(final String... args) throws Exception {
        new App().marshallAndWrite();
    }

    private void html() throws Exception {
        properties.loadFromXML(App.class.getResourceAsStream("/jaxb.xml"));
        URI outputForHTML = new URI(properties.getProperty("output_html_to_uri"));
        URL inputURL = new URL(properties.getProperty("note"));
        MyUnmarshaller hyperTextMarshaller = new MyUnmarshaller();
        MyNote myNote = new MyNote();
        hyperTextMarshaller.unmarshallNote(myNote, inputURL, outputForHTML);
    }

    private void marshallAndWriteNotes() throws Exception {
        properties.loadFromXML(App.class.getResourceAsStream("/jaxb.xml"));
        URI inputURI = new URI(properties.getProperty("input_uri"));
        URI outputURI = new URI(properties.getProperty("output_uri"));
        int numberOfObjectsToMake = Integer.parseInt(properties.getProperty("object_count"));
        MyNoteMarshaller myNoteMarshaller = new MyNoteMarshaller();      
        MyNotes myNotes = myNoteMarshaller.createMyNotes(numberOfObjectsToMake);
        myNoteMarshaller.marshallCountriesAndWriteToFile(myNotes, inputURI);
        myNotes = myNoteMarshaller.unmarshallCountriesFromFile(inputURI);
        myNoteMarshaller.marshallCountriesAndWriteToFile(myNotes, outputURI);
    }

    private void marshallAndWrite() throws Exception {
        properties.loadFromXML(App.class.getResourceAsStream("/jaxb.xml"));
        URI inputURI = new URI(properties.getProperty("input_uri"));
        URI outputURI = new URI(properties.getProperty("output_uri"));
        int numberOfCountriesToMake = Integer.parseInt(properties.getProperty("object_count"));
        CountryMarshaller countryMarshaller = new CountryMarshaller();
        myNotes = countryMarshaller.getManyCountries(numberOfCountriesToMake);
        countryMarshaller.marshallCountriesAndWriteToFile(myNotes, inputURI);
        myNotes = countryMarshaller.unmarshallCountriesFromFile(inputURI);
        countryMarshaller.marshallCountriesAndWriteToFile(myNotes, outputURI);
    }
}
