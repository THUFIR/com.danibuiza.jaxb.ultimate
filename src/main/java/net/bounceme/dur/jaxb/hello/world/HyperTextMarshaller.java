package net.bounceme.dur.jaxb.hello.world;

import com.danibuiza.jaxb.ultimate.business.Countries;
import java.io.File;
import java.io.FileInputStream;

import javax.xml.bind.JAXBContext;
import java.net.URI;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.UnmarshallerHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class HyperTextMarshaller {

    private static final Logger LOG = Logger.getLogger(HyperTextMarshaller.class.getName());

    public HyperTextMarshaller() {
    }

    public void marshallXML3(MyNote myNote, URL url, URI outputURI) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(MyNote.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        MyNote customer = (MyNote) jaxbUnmarshaller.unmarshal(url);
    }

    public void marshallXML2(MyNote myNote, URL url, URI outputURI) throws Exception {
        File fileToWriteXML = new File(outputURI);
        fileToWriteXML.createNewFile();

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();

        JAXBContext jaxbContext = JAXBContext.newInstance("blog.log4j");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();
        xmlReader.setContentHandler(unmarshallerHandler);

        FileInputStream xmlStream = new FileInputStream(url.toString());
        InputSource xmlSource = new InputSource(xmlStream);
        xmlReader.parse(xmlSource);

        //    Log4JConfiguration config = (Log4JConfiguration) unmarshallerHandler.getResult();
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        //    marshaller.marshal(config, System.out);

        //  jaxbMarshaller.marshal(myNote, new File(outputURI));
        marshaller.marshal(jaxbContext, fileToWriteXML);

    }

    public void marshallXML(MyNote myNote, URI outputURI, URL inputURL) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Countries.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        jaxbMarshaller.marshal(myNote, new File(outputURI));
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
//        Thing thing = (Thing) unmarshaller.unmarshal(new File(outputURI));   //why create Thing?
        unmarshaller.unmarshal(fileToWriteHTML);
    }

}
