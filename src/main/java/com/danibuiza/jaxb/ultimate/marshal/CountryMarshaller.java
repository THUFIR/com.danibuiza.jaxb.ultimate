package com.danibuiza.jaxb.ultimate.marshal;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.danibuiza.jaxb.ultimate.business.Countries;
import com.danibuiza.jaxb.ultimate.business.Country;
import java.net.URI;
import java.nio.file.Path;
import java.util.Random;
import java.util.logging.Logger;
import javax.xml.bind.Unmarshaller;

public class CountryMarshaller {

    private static final Logger LOG = Logger.getLogger(CountryMarshaller.class.getName());
    private int min = 1;
    private int max = 999;

    public CountryMarshaller() {
    }

    public Country newFakeRandomCountry() throws Exception {
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

    public void unmarshallCountriesFromFile(Path path) throws Exception {
        File file = new File(path.toUri());
        JAXBContext jaxbContext = JAXBContext.newInstance(Countries.class);

        /**
         * the only difference with the marshaling operation is here
         */
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Countries countres = (Countries) jaxbUnmarshaller.unmarshal(file);
        System.out.println(countres);

    }

    public void marshallCountriesAndWriteToFile(Countries countries, URI uri) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Countries.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(countries, new File(uri));
        jaxbMarshaller.marshal(countries, System.out);

    }

}
