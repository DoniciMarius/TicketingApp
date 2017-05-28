package ro.unicredit.ticketingservice.repositoryLayer.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

/**
 * Created by donic on 5/27/2017.
 */

@Entity
@XmlRootElement(name="ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String buyerName;

    private String buyTimestamp;

    @ManyToOne()
    @JoinColumn(name = "event_id")
    private Event event;

    public Ticket() {

        this.buyTimestamp = LocalDateTime.now().toString();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getBuyTimestamp() {
        return buyTimestamp;
    }

    public void setBuyTimestamp(String buyTimestamp) {
        this.buyTimestamp = buyTimestamp;
    }
}
