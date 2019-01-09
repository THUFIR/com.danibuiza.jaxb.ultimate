package net.bounceme.dur.jaxb.hello.world.book;

import java.util.Random;
import java.util.logging.Logger;

public class BooksMarshaller {

    private static final Logger LOG = Logger.getLogger(BooksMarshaller.class.getName());
//    private Book b = new Book();
    private Endowment e = new Endowment();
    private Library l = new Library();

    public BooksMarshaller() {
    }

    private Book newFakeRandomBook() throws Exception {
        Book b = new Book();
        b.setIsbn(newRandomString("0123456789"));
        b.setTitle(newRandomString("abcdefghijklmnopqrstuvwxyz"));
        return b;
    }

    private String newRandomString(String SALTCHARS) {
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public void doMagic() throws Exception {
        Book b = newFakeRandomBook();
        LOG.info(b.toString());
    }

}
