package io.stackroute.nquireit.events.repository;

import io.stackroute.nquireit.events.domain.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventsRepository extends JpaRepository<Events, Integer> {

    @Query(value = "SELECT e from Events e where e.eventName=?1")
    Events findByEventsName(String eventName);

    @Query(value = "SELECT e from Events e where e.category=?1")
    List<Events> findByEventsCategory (String category);

    @Query(value = "SELECT e from Events e where e.date=?1")
    List<Events> findByEventsDate (Date date);

}
