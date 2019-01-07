package net.bounceme.dur.jaxb.hello.world;

import com.danibuiza.jaxb.ultimate.business.Countries;
import com.danibuiza.jaxb.ultimate.marshal.CountryMarshaller;
import java.net.URI;
import java.util.Properties;
import java.util.logging.Logger;

public class App {

    private static final Logger LOG = Logger.getLogger(App.class.getName());
    private Properties properties = new Properties();
    private Countries countries = null;

    public static void main(final String... args) throws Exception {
        new App().marshallAndWrite();
    }

    private void marshallAndWrite() throws Exception {
        properties.loadFromXML(App.class.getResourceAsStream("/jaxb.xml"));
        URI inputURI = new URI(properties.getProperty("input_uri"));
        URI outputURI = new URI(properties.getProperty("output_uri"));
        int max = Integer.parseInt(properties.getProperty("countries"));
        CountryMarshaller ops = new CountryMarshaller();
        countries = ops.getManyCountries(99);
        ops.marshallCountriesAndWriteToFile(countries, inputURI);
        countries = ops.unmarshallCountriesFromFile(inputURI);
        ops.marshallCountriesAndWriteToFile(countries, outputURI);
    }
}
