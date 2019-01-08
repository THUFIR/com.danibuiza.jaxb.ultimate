package net.bounceme.dur.jaxb.hello.world;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "notes_collection")
public class MyNotes {

    private static final Logger LOG = Logger.getLogger(MyNotes.class.getName());

    private List<MyNote> myNotes = new ArrayList<>();

    public MyNotes() {
    }

    public List<MyNote> getMyNotes() {
        LOG.info(myNotes.toString());
        return myNotes;
    }

    @XmlElement(name = "each_note")
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

}
