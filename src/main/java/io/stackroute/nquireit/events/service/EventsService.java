package io.stackroute.nquireit.events.service;

import io.stackroute.nquireit.events.domain.Events;

import java.util.Date;
import java.util.List;

public interface EventsService {

    Events showEventsByName(String name);
    List<Events> showEventsByCategory(String category);
    List<Events> showEventsByDate(Date date);
    List<Events> showAllEvents();
    Events saveEvents(Events events);


}
