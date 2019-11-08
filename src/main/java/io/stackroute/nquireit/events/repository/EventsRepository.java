package io.stackroute.nquireit.events.repository;

import io.stackroute.nquireit.events.domain.Events;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventsRepository extends MongoRepository<Events, Integer> {

    @Query("{'eventName' : ?0}")
    Events findByEventsName(String eventName);

    @Query("{'category' : ?0}")
    List<Events> findByEventsCategory (String category);

    @Query("{'date' : ?0}")
    List<Events> findByEventsDate (Date date);

}
