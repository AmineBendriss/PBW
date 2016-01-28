package com.pbw.app;

public class Route {
    private int capacity;
    private float distance;
    private int[] visitedClients;

    public Route() {
    }

    public Route(int capacity, float distance, int[] visitedClients) {
        super();
        this.capacity = capacity;
        this.distance = distance;
        this.visitedClients = visitedClients;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int[] getVisitedClients() {
        return visitedClients;
    }

    public void setVisitedClients(int[] visitedClients) {
        this.visitedClients = visitedClients;
    }


}
