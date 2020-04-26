package org.matsim.project.lecture2;

import org.matsim.api.core.v01.Coord;
import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.Scenario;
import org.matsim.api.core.v01.network.Link;
import org.matsim.api.core.v01.network.Network;
import org.matsim.api.core.v01.network.NetworkFactory;
import org.matsim.api.core.v01.network.Node;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.network.io.NetworkWriter;
import org.matsim.core.scenario.ScenarioUtils;

public class CreateNetwork {

    // define capacity of the links in suburban and urban area
    private static final long CAP_Suburban = 500; // [veh/h]
    private static final long CAP_Urban = 250; // [veh/h]

    // define freespeed for links in suburban and urban area
    private static final double LINK_SPEED_Urban = 13.88;
    private static final double LINK_SPEED_Suburban = 22.22; // [m/s]


    public static void main(String[] args) {

        Config config = ConfigUtils.createConfig();
        Scenario scenario = ScenarioUtils.createScenario(config);
        Network net = scenario.getNetwork();
        NetworkFactory fac = net.getFactory();

        // create nodes
        Node n0 = fac.createNode(Id.createNodeId(0), new Coord(0, 0));
        net.addNode(n0);
        Node n1 = fac.createNode(Id.createNodeId(1), new Coord(1000, 0));
        net.addNode(n1);
        Node n2 = fac.createNode(Id.createNodeId(2), new Coord(2000, 0));
        net.addNode(n2);
        Node n3 = fac.createNode(Id.createNodeId(3), new Coord(3000, 1000));
        net.addNode(n3);

        //
        //
        //add missing nodes here...
        //
        //

        // create links

        //link 0 <-> 1
        Link l_01 = fac.createLink(Id.createLinkId("0_1"), n0, n1);
        net.addLink(l_01);
        Link l_10 = fac.createLink(Id.createLinkId("1_0"), n1, n0);
        net.addLink(l_10);

        //link 1 <-> 2
        Link l_12 = fac.createLink(Id.createLinkId("1_2"), n1, n2);
        net.addLink(l_12);
        Link l_21 = fac.createLink(Id.createLinkId("2_1"), n2, n1);
        net.addLink(l_21);

        //link 2 <-> 3
        Link l_23 = fac.createLink(Id.createLinkId("2_3"), n2, n3);
        net.addLink(l_23);
        Link l_32 = fac.createLink(Id.createLinkId("3_2"), n3, n2);
        net.addLink(l_32);

        //
        //
        //add missing links here...
        //
        //

        //
        //
        // set link attributes
        //
        //


        // write network
        new NetworkWriter(net).write("network.xml");
    }

    private static void setLinkAttributes(Link link, double capacity, double freespeed) {
        // fill in method
    }
}
