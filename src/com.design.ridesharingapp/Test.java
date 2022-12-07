package com.design.ridesharingapp;

public class Test {
    public static void main(String[] args) {
        Rider rider = new Rider("Nishith");
        Driver driver = new Driver("John");
        rider.createRide(1,50,60,1);
        rider.closeRideAndReturnAmount();
    }
}
