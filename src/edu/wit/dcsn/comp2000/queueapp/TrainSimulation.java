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
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Your Name
 * @version 1.0.0
 */
public class TrainSimulation {
    public static StringBuilder toPrint;
    public static PrintWriter file_out;
    /**
     * @param args -unused-
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        //


        //This code will give us the output to the console that he is looking for
        Configuration theConfiguration = new Configuration();

        System.out.println("Individual specifications:\n");

        // General
        System.out.println("Ticks: " + theConfiguration.getTicks());
        System.out.println("Seed: " + theConfiguration.getSeed());

        // Route
        System.out.println("Route: " + theConfiguration.getRoute());

        // Stations
        System.out.println("Stations: " + Arrays.toString(theConfiguration.getStations()));

        // Trains
        System.out.println("Trains:");
        for (Configuration.TrainSpec aTrainSpec : theConfiguration.getTrains()) {
            System.out.println("\t" + aTrainSpec);
        }    // end for()

        // Passengers
        System.out.println("Passengers: " + Arrays.toString(theConfiguration.getPassengers()));


        // test toString()
        System.out.println("\n----------\ntoString():\n");
        System.out.println(theConfiguration);
        setup(theConfiguration);

//        Configuration theConfig = new Configuration();
//        Configuration.RouteSpec theRouteSpec = theConfig.getRoute();
//
//        TrainRoute theRoute = new TrainRoute(theRouteSpec);
//        Configuration.TrainSpec[] theTrainSpecs = theConfig.getTrains();
//
//        int i = 0;
//        Train[] aTrain = new Train[10];
//        for (Configuration.TrainSpec aTrainSpecification :theTrainSpecs )
//        {
//            aTrain[i] = new Train(theRoute, aTrainSpecification);
//            System.out.printf("\t%s is %s with capacity %,d%n",
//                    aTrain[i],
//                    aTrain[i].getLocation(),
//                    aTrain[i].getCapacity()
//            );
//            i++;
//        }    // end foreach()
//        Scanner sc = new Scanner(System.in);
//        Location shift = new Location(theRoute);
//
//        /*
//        TODO: Should ticks be < 50 as the total ticks is 50 per config file?
//         */
//
//            for (int ticks = 0; ticks < 2000; ticks++) {
//                shift.move();
//
//            /*
//            TODO: Generate a random amount of passengers each tick?
//            This is what he does in his log file based on
//            https://piazza.com/class/jz2r7a1vdt1684?cid=45
//             */
//                for (Train current : aTrain) {
//                    current.removePassenger();
//                    // I think we need to look at this in more depth and then implement it
//
//                /*
//                TODO: Print out to log which passenger removed????
//                 */
//                    //current.addPassenger(); //Implement addPassenger??
//                /*
//                TODO: Print out to log which passenger was added?
//                 */
//                }
//            }
//        }
    }

    public static void setup(Configuration theConfig) {
        Configuration.RouteSpec theRoute = theConfig.getRoute();
        int[] theStationSpecs = theConfig.getStations();
        Random pseudoRandom = new Random(theConfig.getSeed());
        Configuration.PairedLimit[] thePassengerSpecs = theConfig.getPassengers();
        TrainRoute route = new TrainRoute(theRoute);
        Location direct = new Location(route);

        for(int stations : theStationSpecs){
            Station newStation = new Station(route, stations);
        }

        int minimumPassengers =
                thePassengerSpecs[Configuration.PASSENGERS_INITIAL].minimum;
        int maximumPassengers =
                thePassengerSpecs[Configuration.PASSENGERS_INITIAL].maximum;
        int newPassengerCount =
                minimumPassengers == maximumPassengers
                        ? minimumPassengers
                        : pseudoRandom.nextInt(maximumPassengers - minimumPassengers)
                        + minimumPassengers + 1;
        for (int passengerCount = 1; passengerCount <= newPassengerCount; passengerCount++) {

            Passenger aPassenger =
                    new Passenger(
                            new Location(
                                    route,
                                    theStationSpecs[pseudoRandom.nextInt(theStationSpecs.length)],
                                    Direction.NOT_APPLICABLE
                            ),
                            new Location(
                                    route,
                                    theStationSpecs[pseudoRandom.nextInt(theStationSpecs.length)],
                                    Direction.NOT_APPLICABLE
                            ),
                            0    // current time indicates that clock hasn't started
                    );


            System.out.printf("\t%s%n",
                    aPassenger.toStringFull()
            );

        }
//        Location toLocation = ;
//
//        for (int passengerCount = 1; passengerCount <= newPassengerCount; passengerCount++) {
//            Passenger aPassenger =
//                    new Passenger(
//                            direct.getDirection(theStationSpecs[pseudoRandom.nextInt(theStationSpecs.length)]),
//                            theStationSpecs[pseudoRandom.nextInt(theStationSpecs.length)],
//                            0    // current time indicates that clock hasn't started
//                    );
//
//            System.out.printf("\t%s%n",
//                    aPassenger.toStringFull()
//            );
//        }
    }
    public static void run(){

    }
}
