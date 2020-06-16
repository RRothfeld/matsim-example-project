package org.matsim.project.lecture8; // Adjust for your project structure

import org.matsim.api.core.v01.events.*;
import org.matsim.api.core.v01.events.handler.*;

/**
 * This event handler prints some event information to the console.
 * @author dgrether
 *
 */
public class MyEventHandler1 implements LinkEnterEventHandler,
	LinkLeaveEventHandler, PersonArrivalEventHandler,
	PersonDepartureEventHandler {

	@Override
	public void reset(int iteration) {
		System.out.println("reset...");
	}


	@Override
	public void handleEvent(LinkEnterEvent event) {
		System.out.println("LinkEnterEvent");
		System.out.println("Time: " + event.getTime());
		System.out.println("LinkId: " + event.getLinkId());
	}

	@Override
	public void handleEvent(LinkLeaveEvent event) {
		System.out.println("LinkLeaveEvent");
		System.out.println("Time: " + event.getTime());
		System.out.println("LinkId: " + event.getLinkId());
	}

	@Override
	public void handleEvent(PersonArrivalEvent event) {
		System.out.println("AgentArrivalEvent");
		System.out.println("Time: " + event.getTime());
		System.out.println("LinkId: " + event.getLinkId());
		System.out.println("PersonId: " + event.getPersonId());
	}

	@Override
	public void handleEvent(PersonDepartureEvent event) {
		System.out.println("AgentDepartureEvent");
		System.out.println("Time: " + event.getTime());
		System.out.println("LinkId: " + event.getLinkId());
		System.out.println("PersonId: " + event.getPersonId());
	}
}
