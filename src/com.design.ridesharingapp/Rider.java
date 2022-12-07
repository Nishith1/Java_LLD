package com.design.ridesharingapp;

import java.util.ArrayList;

public class Rider extends Person {
    public Rider(String name) {
        super(name);
    }

    ArrayList<Ride> completedRides = new ArrayList<>();
    Ride currentRide;

    public void createRide(int rideId, int origin, int destination, int numOfSeats){
        if(origin>destination){
            System.out.println("Invalid Input");
        }else{
            currentRide.setId(rideId);
            currentRide.setOrigin(origin);
            currentRide.setDestination(destination);
            currentRide.setNumberOfSeats(numOfSeats);
            currentRide.setRideStatus(RideStatus.CREATED);
        }
    }

    public void updateRide(int rideId, int origin, int destination, int numOfSeats){
        if(currentRide.getRideStatus()==RideStatus.WITHDRAWN){
            System.out.println("Cant Update Ride. Ride was withdrawn");
        }else if(currentRide.getRideStatus()==RideStatus.COMPLETED){
            System.out.println("Cant Update Ride. Ride was completed");
        }
        createRide(rideId,origin,destination,numOfSeats);
    }

    public void withdrawRide(int rideId){
        if(currentRide.getId() !=rideId) {
            System.out.println("Wrong Ride Id as Input. Can't withdraw current ride");
        }
        if(currentRide.getRideStatus() != RideStatus.CREATED){
            System.out.println("Ride wasn't in progress. Cant withdraw ride");
        }
        currentRide.setRideStatus(RideStatus.WITHDRAWN);
    }

    public int closeRideAndReturnAmount(){
        if(currentRide.getRideStatus() != RideStatus.CREATED){
            System.out.println("Ride wasn't in progress. Cant close ride");
            return 0;
        }
        currentRide.setRideStatus(RideStatus.COMPLETED);
        completedRides.add(currentRide);
        return currentRide.calculateFare(completedRides.size()>=10);
    }
}
