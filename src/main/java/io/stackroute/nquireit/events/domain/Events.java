package io.stackroute.nquireit.events.domain;

import org.springframework.data.mongodb.core.mapping.Document;


import org.springframework.data.annotation.Id;
import java.util.Date;

@Document
public class Events {

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
