package net.bounceme.dur.jaxb.hello.world.book;

import java.io.File;
import java.net.URI;
import java.util.Random;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class BooksMarshaller {

    private static final Logger LOG = Logger.getLogger(BooksMarshaller.class.getName());

    private String alpha = "abcdefghijklmnopqrstuvwyz";
    private String numeric = "0123456789";
    private Builder builder = new Builder();

    public BooksMarshaller() {
    }


    

    public Library createNewLibraryFromScratch(int amax, int bmax, int emax) throws Exception {
        Book b = null;//newFakeRandomBook();
        Endowment e = null;//new Endowment();
        Author author = null;
        Subjects subjects = null;
        Subject subject = null;

        Library l = builder.newLib();
        for (int j = 0; j < emax; j++) {
            e = builder.newEndow();
            for (int i = 0; i < bmax; i++) {
                b = builder.newBook();
                for (int k = 0; k < amax; k++) {
                    author = builder.newAuthor();
                    b.add(author);
                }
                for (int k = 0; k < amax; k++) {
                    subjects = builder.newSubjects();
                    for (int x = 0; x < amax; x++) {
                        subject = builder.newSubject();
                        subjects.add(subject);
                    }

                }
                LOG.fine(b.toString());
                e.add(b);
            }
            LOG.fine(e.toString());
            l.add(e);
        }
        return l;
    }

    public void marshallLibraryAndWriteToURI(Library library, URI uri) throws Exception {
        LOG.info(library.toString());
        JAXBContext jaxbContext = JAXBContext.newInstance(Library.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(library, new File(uri));
        jaxbMarshaller.marshal(library, System.out);
    }

}
