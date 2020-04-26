package org.matsim.project.lecture2;

import org.matsim.api.core.v01.Coord;
import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.Scenario;
import org.matsim.api.core.v01.network.*;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.network.NetworkUtils;
import org.matsim.core.network.io.MatsimNetworkReader;
import org.matsim.core.scenario.ScenarioUtils;
import org.matsim.core.utils.geometry.CoordUtils;

public class NetworkTutorial {

    public static void main(String[] args) {

        Config config = ConfigUtils.createConfig();
        Scenario scenario = ScenarioUtils.createScenario(config) ;

        Network emptyNetwork = NetworkUtils.createNetwork();
        //or scenario.getNetwork();

        NetworkFactory factory = emptyNetwork.getFactory();

        Coord from = CoordUtils.createCoord(0,0);
        Coord to = CoordUtils.createCoord(100, 100);

        Node fromNode = factory.createNode(Id.createNodeId("fromNode"), from);
        Node toNode = factory.createNode(Id.createNodeId("toNode"), to);

        emptyNetwork.addNode(fromNode);
        emptyNetwork.addNode(toNode);

        Link link = factory.createLink(Id.createLinkId("link1"), fromNode, toNode);
        Link linkReverse = factory.createLink(Id.createLinkId("Link1_r"), toNode, fromNode);

        emptyNetwork.addLink(link);
        emptyNetwork.addLink(linkReverse);


        link.setFreespeed(13.8);
        link.setCapacity(1800);
        link.setLength(1000);
        link.setNumberOfLanes(2);

        fromNode.setCoord(CoordUtils.createCoord(-100, -100));

        NetworkWriter writer = new NetworkWriter(emptyNetwork);
        writer.write("path-to-file");

        Network trulyEmptyNetwork = NetworkUtils.createNetwork();
        MatsimNetworkReader reader = new MatsimNetworkReader(trulyEmptyNetwork);

    }
}
