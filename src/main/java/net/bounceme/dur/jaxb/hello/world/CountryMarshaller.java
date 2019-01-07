package net.bounceme.dur.jaxb.hello.world;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.danibuiza.jaxb.ultimate.business.Countries;
import com.danibuiza.jaxb.ultimate.business.Country;
import java.net.URI;
import java.util.Random;
import java.util.logging.Logger;
import javax.xml.bind.Unmarshaller;

public class CountryMarshaller {

    private static final Logger LOG = Logger.getLogger(CountryMarshaller.class.getName());
    private int min = 1;
    private int max = 999;

    public CountryMarshaller() {
    }

    public Countries getManyCountries(int max) throws Exception {
        Countries countries = new Countries();
        Country country = null;
        for (int i = 0; i < max; i++) {
            country = newFakeRandomCountry();
            countries.add(country);
        }
        return countries;
    }

    private Country newFakeRandomCountry() throws Exception {
        Country country = new Country();
        country.setName(randomString());
        country.setCapital(randomString());
        country.setContinent(randomString());
        country.setPopulation(randomInt());
        return country;
    }

    private int randomInt() {
        Random rand = new Random();
        return rand.nextInt((max + 1) - min) + min;
    }

    private String randomString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    public Countries unmarshallCountriesFromFile(URI uri) throws Exception {
        File file = new File(uri);
        JAXBContext jaxbContext = JAXBContext.newInstance(Countries.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Countries countries = (Countries) jaxbUnmarshaller.unmarshal(file);
        return countries;
    }

    public void marshallCountriesAndWriteToFile(Countries countries, URI uri) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Countries.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(countries, new File(uri));
        jaxbMarshaller.marshal(countries, System.out);

    }

}
