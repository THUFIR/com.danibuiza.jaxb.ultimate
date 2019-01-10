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

    public BooksMarshaller() {
    }

    private Author newFakeRandomAuthor() throws Exception {
        Author a = new Author(newRandomString(numeric));
        a.setFirst(newRandomString(alpha));
        a.setLast(newRandomString(alpha));
        return a;
    }

    private Book newFakeRandomBook() throws Exception {
        Book b = new Book(newRandomString(numeric));
        b.setTitle(newRandomString(alpha));
        return b;
    }

    private String newRandomString(String saltChars) {
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * saltChars.length());
            salt.append(saltChars.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public Library createNewLibraryFromScratch(int amax, int bmax, int emax) throws Exception {
        Book b = null;//newFakeRandomBook();
        Endowment e = null;//new Endowment();
        Author author = null;

        Library l = new Library(newRandomString(alpha));
        for (int j = 0; j < emax; j++) {
            e = new Endowment(newRandomString(alpha));
            for (int i = 0; i < bmax; i++) {
                b = newFakeRandomBook();
                for (int k = 0; k < amax; k++) {
                    author = newFakeRandomAuthor();
                    b.add(author);
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
