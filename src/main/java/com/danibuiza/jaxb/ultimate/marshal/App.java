package com.danibuiza.jaxb.ultimate.marshal;

import com.danibuiza.jaxb.ultimate.business.Countries;
import com.danibuiza.jaxb.ultimate.business.Country;

public class App {

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
