package net.bounceme.dur.jaxb.hello.world;

import java.io.File;

import javax.xml.bind.JAXBContext;
import java.net.URI;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.UnmarshallerHandler;
import org.xml.sax.XMLReader;

public class HyperTextMarshaller {

    private static final Logger LOG = Logger.getLogger(HyperTextMarshaller.class.getName());
    private int min = 0, max = 0;

    public HyperTextMarshaller() {
    }

    public void hyperText(URL url, URI outputURI) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Thing.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        XMLReader xmlReader = new org.ccil.cowan.tagsoup.Parser();
        xmlReader.parse(url.toString());
        xmlReader.setContentHandler(unmarshaller.getUnmarshallerHandler());
        Thing thing = (Thing) unmarshaller.unmarshal(new File(outputURI));

    }

    public void hyperText2(URL url, URI outputURI) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Thing.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();
        XMLReader xmlReader = new org.ccil.cowan.tagsoup.Parser();
        xmlReader.setContentHandler(unmarshallerHandler);
        xmlReader.parse(url.toString());
        Thing thing = (Thing) unmarshallerHandler.getResult();
    }

}
