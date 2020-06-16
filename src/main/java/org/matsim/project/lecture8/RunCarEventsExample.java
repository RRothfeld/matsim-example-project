package org.matsim.project.lecture8; // Adjust for your project structure

import org.matsim.core.api.experimental.events.EventsManager;
import org.matsim.core.events.EventsReaderXMLv1;
import org.matsim.core.events.EventsUtils;

public class RunCarEventsExample {

    public static void main(String[] args) {
        EventsManager manager = EventsUtils.createEventsManager();

        CarDepartureEventHandler carHandler = new CarDepartureEventHandler();
        manager.addHandler(carHandler);

        EventsReaderXMLv1 eventsReader = new EventsReaderXMLv1(manager);
        eventsReader.readFile("output/output_events.xml.gz");
        carHandler.reset(0);
    }
}
