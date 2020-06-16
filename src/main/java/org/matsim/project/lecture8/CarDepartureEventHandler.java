package org.matsim.project.lecture8;

import org.matsim.api.core.v01.events.VehicleEntersTrafficEvent;
import org.matsim.api.core.v01.events.handler.VehicleEntersTrafficEventHandler;

import java.util.HashMap;
import java.util.Map;

public class CarDepartureEventHandler implements VehicleEntersTrafficEventHandler {
    Map<Double, Integer> counter = new HashMap();
    double binSizeHour = 30 / 60.0;

    @Override
    public void handleEvent(VehicleEntersTrafficEvent event) {
        double timeBin = Math.floor(event.getTime() / (60 * 60) / binSizeHour) * binSizeHour;

        if (counter.containsKey(timeBin)) {
            Integer currentValue = counter.get(timeBin);
            counter.put(timeBin, currentValue + 1);
        } else {
            counter.put(timeBin, 1);
        }
    }

    @Override
    public void reset(int iteration) {
        System.out.println("hour,count");
        for (Double hour : counter.keySet()) {
            System.out.println(hour + "," + counter.get(hour));
        }

        // All data printed, clear map
        counter.clear();
    }
}
