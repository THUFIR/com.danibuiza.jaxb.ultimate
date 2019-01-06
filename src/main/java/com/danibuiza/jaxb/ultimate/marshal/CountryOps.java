package com.danibuiza.jaxb.ultimate.marshal;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.danibuiza.jaxb.ultimate.business.Countries;
import com.danibuiza.jaxb.ultimate.business.Country;
import static java.lang.Float.max;
import static java.lang.Float.min;
import java.util.Random;
import java.util.logging.Logger;

public class CountryOps {

    private static final Logger LOG = Logger.getLogger(CountryOps.class.getName());
    private int min = 1;
    private int max = 999;

    public CountryOps() {
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

    public void marshallCountriesAndWriteToFile(Countries countries) throws Exception {
        /* init jaxb marshaler */
        JAXBContext jaxbContext = JAXBContext.newInstance(Countries.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        /* set this flag to true to format the output */
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        /* marshaling of java objects in xml (output to file and standard output) */
        jaxbMarshaller.marshal(countries, new File("list_countries.xml"));
        jaxbMarshaller.marshal(countries, System.out);

    }
}
