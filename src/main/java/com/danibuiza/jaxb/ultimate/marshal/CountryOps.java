package com.danibuiza.jaxb.ultimate.marshal;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.danibuiza.jaxb.ultimate.business.Countries;
import com.danibuiza.jaxb.ultimate.business.Country;
import java.util.Random;

public class CountryOps {

    public CountryOps() {
    }

    protected Country newFakeRandomCountry() throws Exception {
        Country country = new Country();
        country.setName(randomString());
        country.setCapital(randomString());
        country.setContinent(randomString());
        return country;
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

    protected void marshallCountriesAndWriteToFile(Countries countries) throws Exception {
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
