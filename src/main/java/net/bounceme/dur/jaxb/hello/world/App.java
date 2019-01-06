package net.bounceme.dur.jaxb.hello.world;
//package com.danibuiza.jaxb.ultimate.marshal;

import com.danibuiza.jaxb.ultimate.business.Countries;
import com.danibuiza.jaxb.ultimate.business.Country;
import com.danibuiza.jaxb.ultimate.marshal.CountryOps;
import java.util.logging.Logger;

public class App {

    private static final Logger LOG = Logger.getLogger(App.class.getName());

    public static void main(final String... args) throws Exception {
        new App().marshallAndWrite();
    }

    private void marshallAndWrite() throws Exception {
        CountryOps ops = new CountryOps();
        Countries cs = new Countries();
        Country c = null;
        for (int i = 0; i < 9; i++) {
            c = ops.newFakeRandomCountry();
            cs.add(c);
        }
        ops.marshallCountriesAndWriteToFile(cs);
    }
}
