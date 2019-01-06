package net.bounceme.dur.jaxb.hello.world;
//package com.danibuiza.jaxb.ultimate.marshal;

import com.danibuiza.jaxb.ultimate.business.Countries;
import com.danibuiza.jaxb.ultimate.business.Country;
import com.danibuiza.jaxb.ultimate.marshal.CountryOps;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Logger;

public class App {

    private static final Logger LOG = Logger.getLogger(App.class.getName());
    private Properties properties = null;

    public static void main(final String... args) throws Exception {
        new App().marshallAndWrite();
    }

    private void marshallAndWrite() throws Exception {
//        properties.loadFromXML(App.class.getResourceAsStream("jaxb.xml"));
     //   String stringPath = properties.getProperty("path");
        Path path = Paths.get("/home/thufir/jaxb/countries.xml");

        CountryOps ops = new CountryOps();
        Countries countries = new Countries();
        Country c = null;
        for (int i = 0; i < 99; i++) {
            c = ops.newFakeRandomCountry();
            countries.add(c);
        }
        ops.marshallCountriesAndWriteToFile(countries,path);
    }
}
