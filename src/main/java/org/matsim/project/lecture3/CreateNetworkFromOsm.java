package org.matsim.project.lecture3;

import org.matsim.core.utils.geometry.CoordinateTransformation;
import org.matsim.core.utils.geometry.transformations.TransformationFactory;
import org.matsim.core.utils.io.OsmNetworkReader;

public class CreateNetworkFromOsm {
    public static void main(String[] args) {

        // First, we need an new/empty network in which the OsmNetworkReader can store whatever it parses
        // ...

        CoordinateTransformation ct = TransformationFactory.getCoordinateTransformation(TransformationFactory.WGS84,
                "EPSG:XXXX");

        //new OsmNetworkReader(network, ct).parse(args[0]);
        // write network to disk
    }
}
