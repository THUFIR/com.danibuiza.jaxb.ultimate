package net.bounceme.dur.jaxb.hello.world;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/*
<note><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don't forget me this weekend!</body></note>
 */
@XmlType(propOrder = {"note", "to", "from", "heading", "body"})
@XmlRootElement(name = "note")
public class MyNote {

    private String note;
    private String to;
    private String from;
    private String heading;
    private String body;

    public String getNote() {
        return note;
    }

    @XmlElement(name = "Country_Population")
    public void setNote(String note) {
        this.note = note;
    }

    public String getTo() {
        return to;
    }

    @XmlElement(name = "Country_Population")
    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    @XmlElement(name = "Country_Population")

    public void setFrom(String from) {
        this.from = from;
    }

    public String getHeading() {
        return heading;
    }

    @XmlElement(name = "Country_Population")
    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getBody() {
        return body;
    }

    @XmlElement(name = "Country_Population")
    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return note + to + from + heading + body;
    }

}
