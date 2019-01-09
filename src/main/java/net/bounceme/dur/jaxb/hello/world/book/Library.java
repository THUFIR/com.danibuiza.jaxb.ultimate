package net.bounceme.dur.jaxb.hello.world.book;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "notes_collection")
public class Library {

    private static final Logger LOG = Logger.getLogger(Library.class.getName());

    private String name = null;
    private List<Endowment> endowments = new ArrayList<>();

    private Library() {
    }

    public Library(String name) {
        this.name = name;
    }

    public List<Endowment> getEndowments() {
        return endowments;
    }

    @XmlElement(name = "endowment")
    public void setMyNotes(List<Endowment> endowment) {
        endowments = endowment;
    }

    public void add(Endowment e) {
        endowments.add(e);
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (Endowment e : endowments) {
            str.append(e.toString());
        }
        return str.toString();
    }

}
