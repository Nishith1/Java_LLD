package com.design.ridesharingapp;

enum RideStatus {IDLE,CREATED,WITHDRAWN,COMPLETED}

public class Ride {
    static int AMT_PER_KM = 20;
    int id;
    int origin;
    int destination;
    int numberOfSeats;
    RideStatus rideStatus;


    public Ride() {
    }

    public Ride(int id, int origin, int destination, int numberOfSeats, RideStatus rideStatus) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.numberOfSeats = numberOfSeats;
        this.rideStatus = rideStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrigin() {
        return origin;
    }

    public void setOrigin(int origin) {
        this.origin = origin;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }

    int calculateFare(boolean isPriorityRider){
        int dist  = destination - origin;
        if(isPriorityRider){
            if(numberOfSeats<2){
                return (int) (dist * AMT_PER_KM * 0.75);
            }else{
                return (int) (dist * numberOfSeats * 0.75 * AMT_PER_KM);
            }
        }else{
            if(numberOfSeats<2){
                return dist * AMT_PER_KM;
            }else{
                return (int) (dist * numberOfSeats * 0.75 * AMT_PER_KM);
            }
        }
    }
}
