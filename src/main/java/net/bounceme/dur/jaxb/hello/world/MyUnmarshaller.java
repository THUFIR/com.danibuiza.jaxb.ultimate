package net.bounceme.dur.jaxb.hello.world;

import com.danibuiza.jaxb.ultimate.business.Countries;
import java.io.File;
import javax.xml.bind.JAXBContext;
import java.net.URI;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.bind.Unmarshaller;

public class MyUnmarshaller {

    private static final Logger LOG = Logger.getLogger(MyUnmarshaller.class.getName());

    public MyUnmarshaller() {
    }

    public Countries unmarshallCountriesFromFile(URI uri) throws Exception {
        File file = new File(uri);
        JAXBContext jaxbContext = JAXBContext.newInstance(Countries.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Countries countries = (Countries) jaxbUnmarshaller.unmarshal(file);
        return countries;
    }

    public void unmarshallNote(MyNote myNote, URL url, URI outputURI) throws Exception {
        LOG.info(url.toString());
        LOG.info(outputURI.toString());
        JAXBContext jaxbContext = JAXBContext.newInstance(MyNote.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        MyNote note = (MyNote) jaxbUnmarshaller.unmarshal(url);
    }

}
