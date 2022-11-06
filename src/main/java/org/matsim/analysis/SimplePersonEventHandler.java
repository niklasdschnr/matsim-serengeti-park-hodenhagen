package org.matsim.analysis;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.events.PersonArrivalEvent;
import org.matsim.api.core.v01.events.PersonDepartureEvent;
import org.matsim.api.core.v01.events.handler.PersonArrivalEventHandler;
import org.matsim.api.core.v01.events.handler.PersonDepartureEventHandler;
import org.matsim.api.core.v01.population.Person;

import java.util.HashMap;
import java.util.Map;

public class SimplePersonEventHandler implements PersonDepartureEventHandler, PersonArrivalEventHandler {

    //define a map variable to use it everywhere, map with id mapping to some value
    private final Map<Id<Person>, Double> persontoDepartureTime = new HashMap<>();
    //final: gurantee that the hashmap won't change

    @Override
    public void handleEvent(PersonArrivalEvent personArrivalEvent) {
        //the event handler will get called whenever the event occurs, not in the order the code is written here
        var arrivalTime = personArrivalEvent.getTime();
        var departureTime=persontoDepartureTime.get(personArrivalEvent.getPersonId());
        var travelTime=arrivalTime-departureTime;

        System.out.println("Person: " + personArrivalEvent.getPersonId() + "travelled   " + travelTime + " sec  (" + travelTime/60 + "min)");
        //System.out.println("Arrival: " + personArrivalEvent.getTime() + ": " + personArrivalEvent.getPersonId());
    }


    @Override
    public void handleEvent(PersonDepartureEvent personDepartureEvent) {
        var departureTime = personDepartureEvent.getTime();
        var personId =personDepartureEvent.getPersonId();
        persontoDepartureTime.put(personId, departureTime);
        //System.out.println("Departure: " + personDepartureEvent.getTime() + ": " + personDepartureEvent.getPersonId());

    }
}
