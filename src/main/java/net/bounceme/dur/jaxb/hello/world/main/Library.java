package net.bounceme.dur.jaxb.hello.world.main;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import net.bounceme.dur.jaxb.hello.world.book.Endowment;

@XmlRootElement(name = "notes_collection")
public class Library {

    private static final Logger LOG = Logger.getLogger(Library.class.getName());

    private List<MyNote> myNotes = new ArrayList<>();

    public Library() {
    }

    public Library(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<MyNote> getMyNotes() {
        LOG.info(myNotes.toString());
        return myNotes;
    }

    @XmlElement(name = "note")
    public void setMyNotes(List<MyNote> myNotes) {
        LOG.info(myNotes.toString());
        this.myNotes = myNotes;
    }

    public void add(MyNote myNote) {
        LOG.info(myNote.toString());
        myNotes.add(myNote);
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (MyNote note : myNotes) {
            str.append(note.toString());
        }
        return str.toString();
    }

    public void add(Endowment e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
