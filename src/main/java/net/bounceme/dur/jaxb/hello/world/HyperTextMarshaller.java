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

    public HyperTextMarshaller() {
    }

    public void marshallHTML(URL url, URI outputURI) throws Exception {
        File fileToWriteHTML = new File(outputURI);
        fileToWriteHTML.createNewFile();

        JAXBContext jaxbContext = JAXBContext.newInstance(WhatIsThisThing.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        UnmarshallerHandler unMarshallerHandler = unmarshaller.getUnmarshallerHandler();
        XMLReader xmlReader = new org.ccil.cowan.tagsoup.Parser();
        xmlReader.parse(url.toString());
        xmlReader.setContentHandler(unMarshallerHandler);
//        Thing thing = (Thing) unmarshaller.unmarshal(new File(outputURI));
        unmarshaller.unmarshal(fileToWriteHTML);
    }

}
