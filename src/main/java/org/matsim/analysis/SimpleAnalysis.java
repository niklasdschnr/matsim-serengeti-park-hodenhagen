package org.matsim.analysis;

import org.matsim.core.events.EventsUtils;

public class SimpleAnalysis {

    public static void main(String[] args){

        var handler = new SimplePersonEventHandler();
        var manager = EventsUtils.createEventsManager();
        manager.addHandler(handler);

        EventsUtils.readEvents(manager, "/Users/niklas/Documents/Masterarbeit_lokal/matsim-serengeti-park/scenarios/serengeti-park-v1.0/output/output-serengeti-park-v1.0-run1/serengeti-park-v1.0-run1.output_events.xml.gz");
    }
}
