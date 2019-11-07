package io.stackroute.nquireit.events.controller;


import io.stackroute.nquireit.events.domain.Events;
import io.stackroute.nquireit.events.service.EventsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value="api/v1")
@RestController
public class EventsController {

    EventsService eventsService ;

    public EventsController(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @GetMapping("event")
    public ResponseEntity<?> getallevents(){
        return new ResponseEntity<List<Events>>(eventsService.showAllEvents(), HttpStatus.OK);
    }
//    @PostMapping("music")
//    public ResponseEntity<?> saveUser(@RequestBody Music music)
//    {
//        ResponseEntity responseEntity ;
//        try {
//            musicService.saveUser(music);
//            responseEntity = new ResponseEntity<String>("Successfull created", HttpStatus.CREATED);
//        }
//        catch (Exception ex)
//        {
//            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
//        }
//        return responseEntity;
//    }

    @PostMapping("events")
    public ResponseEntity<?>saveEvents(@RequestBody Events events){
        ResponseEntity responseEntity;

        try {
            eventsService.saveEvents(events);
            responseEntity = new ResponseEntity<String>("Successfull created", HttpStatus.CREATED);
        }
        catch (Exception ex)
        {
            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;

    }

//    @GetMapping("music/find/{trackName}")
//    public ResponseEntity<?> query(@PathVariable(value = "trackName") String trackName)
//    {
//        return new ResponseEntity<List<Music>>( musicService.queryString(trackName),HttpStatus.OK);
//    }

    @GetMapping("events/find/{eventName}")
    public ResponseEntity<?> getEventByName(@PathVariable(value ="eventName") String eventName ){
        return new ResponseEntity<Events>(eventsService.showEventsByName(eventName),HttpStatus.OK);

    }

}
