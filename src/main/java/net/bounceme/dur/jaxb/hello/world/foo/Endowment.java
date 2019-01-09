package net.bounceme.dur.jaxb.hello.world.foo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Endowment {

    private static final Logger LOG = Logger.getLogger(Endowment.class.getName());

    private final String donor = null;
    private final List<Book> book = new ArrayList<>();

    public Endowment() {
    }
}
