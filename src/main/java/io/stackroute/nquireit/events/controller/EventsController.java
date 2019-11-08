package io.stackroute.nquireit.events.controller;


import io.stackroute.nquireit.events.domain.Events;
import io.stackroute.nquireit.events.service.EventsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping(value="api/v1")
@RestController
public class EventsController {

    private EventsService eventsService ;

    public EventsController(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @GetMapping("events")
    public ResponseEntity<?> getAllEvents(){
        return new ResponseEntity<List<Events>>(eventsService.showAllEvents(), HttpStatus.OK);
    }

    @PostMapping("events")
    public ResponseEntity<?>saveEvents(@RequestBody Events events){
        ResponseEntity responseEntity;

        try {
            eventsService.saveEvents(events);
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        }
        catch (Exception ex)
        {
            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;

    }

    @GetMapping("events/find/{eventName}")
    public ResponseEntity<?> getEventByName(@PathVariable(value ="eventName") String eventName ){
        return new ResponseEntity<Events>(eventsService.showEventsByName(eventName),HttpStatus.OK);

    }

    @GetMapping("events/find/{date}")
    public ResponseEntity<?> getEventByDate(@PathVariable(value = "date") Date date) {
        return new ResponseEntity<List<Events>>(eventsService.showEventsByDate(date),HttpStatus.OK);
    }

    @GetMapping("events/find/{category}")
    public ResponseEntity<?> getEventByCategory(@PathVariable(value = "category") String category) {
        return new ResponseEntity<List<Events>>(eventsService.showEventsByCategory(category),HttpStatus.OK);
    }

//    @DeleteMapping("events/delete/{}")
//    public ResponseEntity<?> deleteTrack(@RequestBody Track track){
//        ResponseEntity responseEntity;
//        try {
//            trackService.deleteTrack(track);
//            responseEntity = new ResponseEntity<String>("Successfully Deleted!",HttpStatus.ACCEPTED);
//        }catch (Exception e){
//            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NO_CONTENT);
//        }
//        return responseEntity;
//    }


}
