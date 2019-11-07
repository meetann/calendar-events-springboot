package io.stackroute.nquireit.events.service;

import io.stackroute.nquireit.events.domain.Events;
import io.stackroute.nquireit.events.repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventsServiceImpl implements EventsService {

    private EventsRepository eventsRepository;

    @Autowired
    public EventsServiceImpl(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public Events showEventsByName(String name) {
        return eventsRepository.findByEventsName(name);
    }

    @Override
    public List<Events> showEventsByCategory(String category) {
        return eventsRepository.findByEventsCategory(category);
    }

    @Override
    public List<Events> showEventsByDate(Date date) {
        return eventsRepository.findByEventsDate(date);
    }

    @Override
    public List<Events> showAllEvents() {
        return eventsRepository.findAll();
    }

    @Override
    public Events saveEvents(Events events) {
        Events saveEvent = eventsRepository.save(events);
        return saveEvent;
    }
}
