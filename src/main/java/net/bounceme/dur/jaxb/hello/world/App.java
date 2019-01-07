package net.bounceme.dur.jaxb.hello.world;

import com.danibuiza.jaxb.ultimate.business.Countries;
import com.danibuiza.jaxb.ultimate.business.Country;
import com.danibuiza.jaxb.ultimate.marshal.CountryOps;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Logger;

public class App {

    private static final Logger LOG = Logger.getLogger(App.class.getName());
    private Properties properties = new Properties();

    public static void main(final String... args) throws Exception {
        new App().marshallAndWrite();
    }

    private void marshallAndWrite() throws Exception {
        properties.loadFromXML(App.class.getResourceAsStream("/jaxb.xml"));
        String s = properties.getProperty("path");
        URI z = new URI(s);
        LOG.info(z.toString());
        Path path = Paths.get(z);
        CountryOps ops = new CountryOps();
        Countries countries = new Countries();
        Country c = null;
        for (int i = 0; i < 9; i++) {
            c = ops.newFakeRandomCountry();
            countries.add(c);
        }
        ops.marshallCountriesAndWriteToFile(countries, path);
    }
}
