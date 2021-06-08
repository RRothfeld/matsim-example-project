package org.matsim.project.lecture8; // Adjust for your project structure

import org.matsim.api.core.v01.network.Network;
import org.matsim.core.api.experimental.events.EventsManager;
import org.matsim.core.events.EventsReaderXMLv1;
import org.matsim.core.events.EventsUtils;
import org.matsim.core.network.NetworkUtils;
import org.matsim.core.network.io.MatsimNetworkReader;

public class RunEventsExample {

    public static void main(String[] args) {
        EventsManager manager = EventsUtils.createEventsManager();

		//manager.addHandler(new MyEventHandler1()); // registering my Event Handler
        manager.addHandler(new PersonUsingPTEventHandler());

		//Network network = NetworkUtils.createNetwork();
    	//MatsimNetworkReader reader = new MatsimNetworkReader(network);
		//reader.readFile("output/output_network.xml.gz");

		//manager.addHandler(new CongestionDetectionEventHandler(network));

        EventsReaderXMLv1 eventsReader = new EventsReaderXMLv1(manager);
        eventsReader.readFile("output/output_events.xml.gz");
    }
}
