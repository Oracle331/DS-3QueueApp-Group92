/*
 * Dave Rosenberg
 * Comp 2000 - Data Structures
 * Lab: Queue App: Train Simulation
 * Fall, 2019
 *
 * Usage restrictions:
 *
 * You may use this code for exploration, experimentation, and furthering your
 * learning for this course. You may not use this code for any other
 * assignments, in my course or elsewhere, without explicit permission, in
 * advance, from myself (and the instructor of any other course).
 *
 * Further, you may not post or otherwise share this code with anyone other than
 * current students in my sections of this course. Violation of these usage
 * restrictions will be considered a violation of the Wentworth Institute of
 * Technology Academic Honesty Policy.
 *
 * Do not remove this notice.
 */

package edu.wit.dcsn.comp2000.queueapp;


import sun.security.krb5.Config;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Your Name
 * @version 1.0.0
 */
public class TrainSimulation {

    /**
     * @param args -unused-
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        //
        Configuration theConfig = new Configuration();
        Configuration.RouteSpec theRouteSpec = theConfig.getRoute();

        TrainRoute theRoute = new TrainRoute(theRouteSpec);
        Configuration.TrainSpec[] theTrainSpecs = theConfig.getTrains();

        int i = 0;
        Train[] aTrain = new Train[10];
        for (Configuration.TrainSpec aTrainSpecification :theTrainSpecs )
        {
            aTrain[i] = new Train(theRoute, aTrainSpecification);
            System.out.printf("\t%s is %s with capacity %,d%n",
                    aTrain[i],
                    aTrain[i].getLocation(),
                    aTrain[i].getCapacity()
            );
            i++;
        }    // end foreach()
        Scanner sc = new Scanner(System.in);


        /*
        for(int a = 0; a < input; a++){

        }
         */

    }
}
