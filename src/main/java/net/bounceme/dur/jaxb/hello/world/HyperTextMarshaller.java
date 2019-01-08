package net.bounceme.dur.jaxb.hello.world;


import javax.xml.bind.JAXBContext;
import java.net.URI;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.bind.Unmarshaller;

public class HyperTextMarshaller {

    private static final Logger LOG = Logger.getLogger(HyperTextMarshaller.class.getName());

    public HyperTextMarshaller() {
    }

    public void marshallNote(MyNote myNote, URL url, URI outputURI) throws Exception {
        LOG.info(url.toString());
        LOG.info(outputURI.toString());
        JAXBContext jaxbContext = JAXBContext.newInstance(MyNote.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        //  MyNote note = (MyNote) jaxbUnmarshaller.unmarshal(url);
       
    }



}
