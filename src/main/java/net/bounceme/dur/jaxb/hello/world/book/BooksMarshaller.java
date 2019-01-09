package net.bounceme.dur.jaxb.hello.world.book;

import java.io.File;
import java.net.URI;
import java.util.Random;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class BooksMarshaller {

    private static final Logger LOG = Logger.getLogger(BooksMarshaller.class.getName());
//    private Book b = new Book();
//    private Endowment e = null;//new Endowment();
//    private Library l = nnew Library();

    private String a = "abcdefghijklmnopqrstuvwyz";
    private String n = "abcdefghijklmnopqrstuvwyz";

    public BooksMarshaller() {
    }

    private Book newFakeRandomBook() throws Exception {
        Book b = new Book(newRandomString(n));
        b.setTitle(newRandomString(a));
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

    public Library createNewLibraryFromScratch(int bmax, int emax) throws Exception {
        Book b = null;//newFakeRandomBook();
        Endowment e = null;//new Endowment();

        Library l = new Library(newRandomString(a));
        for (int j = 0; j < emax; j++) {
            e = new Endowment(newRandomString(a));
            for (int i = 0; i < bmax; i++) {
                b = newFakeRandomBook();
                LOG.info(b.toString());
                e.add(b);
            }
            LOG.info(e.toString());
            l.add(e);
        }
        return l;
    }

    public void marshallMyNotesAndWriteToFile(Library library, URI uri) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Library.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(library, new File(uri));
        jaxbMarshaller.marshal(library, System.out);
    }

}
