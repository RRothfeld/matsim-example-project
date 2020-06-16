package org.matsim.project.lecture8; // Adjust for your project structure

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.events.*;
import org.matsim.api.core.v01.events.handler.*;
import org.matsim.api.core.v01.network.Link;
import org.matsim.api.core.v01.network.Network;
import org.matsim.vehicles.Vehicle;

import java.util.HashMap;
import java.util.Map;

/**
 * This EventHandler implementation counts the travel time of
 * all agents and provides the average travel time per
 * agent.
 * Actually, handling Departures and Arrivals should be sufficient for this (may 2014)
 * @author dgrether
 *
 */
public class CongestionDetectionEventHandler implements LinkEnterEventHandler,
	LinkLeaveEventHandler, PersonDepartureEventHandler{
	
	private Map<Id<Vehicle>,Double> earliestLinkExitTime = new HashMap<>() ;
	private Network network;
	
	public CongestionDetectionEventHandler(Network network ) {
		this.network = network ;
	}

	@Override
	public void reset(int iteration) {
		this.earliestLinkExitTime.clear(); 
	}

	@Override
	public void handleEvent(LinkEnterEvent event) {
		Link link = network.getLinks().get( event.getLinkId() ) ;
		double linkTravelTime =  link.getLength() / link.getFreespeed( event.getTime() );
		this.earliestLinkExitTime.put( event.getVehicleId(), event.getTime() + linkTravelTime ) ;
	}

	@Override
	public void handleEvent(LinkLeaveEvent event) {
		if(this.earliestLinkExitTime.containsKey(event.getVehicleId())) {
			double excessTravelTime = event.getTime() - this.earliestLinkExitTime.get(event.getVehicleId());
			System.out.println("excess travel time: " + excessTravelTime);
		}
	}

	@Override
	public void handleEvent(PersonDepartureEvent event) {
		Id<Vehicle> vehId = Id.create( event.getPersonId(), Vehicle.class ) ; // unfortunately necessary since vehicle departures are not uniformly registered
		this.earliestLinkExitTime.put( vehId, event.getTime() ) ;
	}

}
