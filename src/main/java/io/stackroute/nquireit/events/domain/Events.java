package io.stackroute.nquireit.events.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Events {

    @Column(name = "event_Id")
    @Id
    Integer eventId;
    String eventName;

    String category;
    Date date;

    String type;
    String location;

    public Integer getEventId() {
        return eventId;
    }
    @Override
    public String toString() {
        return "Events{" +
                "eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                ", category='" + category + '\'' +
                ", date=" + date +
                ", type='" + type + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
