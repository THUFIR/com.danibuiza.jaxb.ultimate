package net.bounceme.dur.jaxb.hello.world;

import com.danibuiza.jaxb.ultimate.business.Countries;
import java.net.URI;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Logger;

public class App {

    private static final Logger LOG = Logger.getLogger(App.class.getName());
    private Properties properties = new Properties();
    private Countries countries = null;

    public static void main(final String... args) throws Exception {
        new App().marshallAndWrite();
    }

    private void html() throws Exception {
        properties.loadFromXML(App.class.getResourceAsStream("/jaxb.xml"));
        URI inputURI = new URI(properties.getProperty("input_uri"));
        URI outputHTML = new URI(properties.getProperty("output_html_to_uri"));
        URL url = new URL(properties.getProperty("url"));
        HyperTextMarshaller htm = new HyperTextMarshaller();
        htm.hyperText(url, outputHTML);
    }

    private void marshallAndWrite() throws Exception {
        properties.loadFromXML(App.class.getResourceAsStream("/jaxb.xml"));
        URI inputURI = new URI(properties.getProperty("input_uri"));
        URI outputURI = new URI(properties.getProperty("output_uri"));
        int numberOfCountriesToMake = Integer.parseInt(properties.getProperty("countries"));
        CountryMarshaller ops = new CountryMarshaller();
        countries = ops.getManyCountries(numberOfCountriesToMake);
        ops.marshallCountriesAndWriteToFile(countries, inputURI);
        countries = ops.unmarshallCountriesFromFile(inputURI);
        ops.marshallCountriesAndWriteToFile(countries, outputURI);
    }
}
