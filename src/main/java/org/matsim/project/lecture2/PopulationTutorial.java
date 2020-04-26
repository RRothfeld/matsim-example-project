package org.matsim.project.lecture2;

import org.matsim.api.core.v01.Coord;
import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.Scenario;
import org.matsim.api.core.v01.TransportMode;
import org.matsim.api.core.v01.network.*;
import org.matsim.api.core.v01.population.*;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.network.NetworkUtils;
import org.matsim.core.network.io.MatsimNetworkReader;
import org.matsim.core.population.PopulationUtils;
import org.matsim.core.population.io.PopulationReader;
import org.matsim.core.scenario.ScenarioUtils;
import org.matsim.core.utils.geometry.CoordUtils;

public class PopulationTutorial {

    public static void main(String[] args) {

        Config config = ConfigUtils.createConfig();
        Scenario scenario = ScenarioUtils.createScenario(config) ;

        Population emptyPopulation = PopulationUtils.createPopulation(config);
        Population existingPopulation = scenario.getPopulation();

        PopulationFactory factory = emptyPopulation.getFactory();

        Person person1 = factory.createPerson(Id.createPersonId(1));

        //Create plan
        Plan plan1 = factory.createPlan();
        //Create and add home activity at (0,0), ending at 08:00:00
        Activity homeActivity = factory.createActivityFromCoord("home", new Coord(0,0));
        homeActivity.setEndTime(8*60*60);
        plan1.addActivity(homeActivity);
        //Create and add trip leg by car
        Leg leg2Work = factory.createLeg(TransportMode.car);
        plan1.addLeg(leg2Work);
        //Create and add work activity at (100,100), ending at 16:00:00
        Activity workActivity = factory.createActivityFromCoord("work", new Coord(100,100));
        workActivity.setEndTime(16*60*60);
        plan1.addActivity(workActivity);
        //Create and add trip leg by car
        Leg leg2Home = factory.createLeg(TransportMode.car);
        plan1.addLeg(leg2Home);
        //Add plan to person
        person1.addPlan(plan1);


        emptyPopulation.addPerson(person1);

        PopulationWriter writer = new PopulationWriter(emptyPopulation);
        writer.write("file-path");

        Scenario emptyScenario = ScenarioUtils.createScenario(config);
        PopulationReader reader = new PopulationReader(emptyScenario);
        reader.readFile("file-path");

    }
}
