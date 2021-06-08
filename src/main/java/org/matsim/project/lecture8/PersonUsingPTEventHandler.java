package org.matsim.project.lecture8;

import org.matsim.api.core.v01.events.ActivityStartEvent;
import org.matsim.api.core.v01.events.handler.ActivityStartEventHandler;

public class PersonUsingPTEventHandler implements ActivityStartEventHandler {
    @Override
    public void handleEvent(ActivityStartEvent event) {
        // Print out PersonID if using PT
        if(event.getActType().equals("pt interaction")) {
            System.out.println(String.format("Person: %s at %02d:%02d", event.getPersonId(), (int) Math.floor(event.getTime() / 3600), (int) Math.floor((event.getTime() / 60) % 60)));
        }
    }

    @Override
    public void reset(int iteration) {
        // leave empty
    }
}
