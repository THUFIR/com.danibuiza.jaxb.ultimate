package net.bounceme.dur.jaxb.hello.world.book;

import java.io.File;
import java.net.URI;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class BooksMarshaller {

    private static final Logger LOG = Logger.getLogger(BooksMarshaller.class.getName());

    private Builder builder = new Builder();

    public BooksMarshaller() {
    }

    public Library createNewLibraryFromScratch(int amax, int bmax, int emax) throws Exception {
        Book book = null;
        Endowment endowment = null;
        Author author = null;
        Subjects subjects = null;
        Subject subject = null;

        Library l = builder.newLib();
        for (int j = 0; j < emax; j++) {
            endowment = builder.newEndow();
            for (int i = 0; i < bmax; i++) {
                book = builder.newBook();
                for (int k = 0; k < amax; k++) {
                    author = builder.newAuthor();
                    book.add(author);
                }
                for (int k = 0; k < amax; k++) {
                    subjects = builder.newSubjects();
                    for (int x = 0; x < amax; x++) {
                        subject = builder.newSubject();
                        subjects.add(subject);
                    }
                    book.setSubjects(subjects);
                }
                LOG.fine(book.toString());
                endowment.add(book);
            }
            LOG.fine(endowment.toString());
            l.add(endowment);
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
