package com.pbw.app;

import java.util.ArrayList;


public class Result {
    private int totalDistance;
    private ArrayList<Route> routes;

    public Result() {
        routes = new ArrayList<Route>();
        this.totalDistance = 0;
    }

    public Result(int numberOfRoute, int totalDistance, ArrayList<Route> routes) {
        super();
        this.totalDistance = totalDistance;
        this.routes = routes;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(int totalDistance) {
        this.totalDistance = totalDistance;
    }

    public ArrayList<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(ArrayList<Route> routes) {
        this.routes = routes;
    }

    public void addRoute(Route e) {
        this.totalDistance += e.getDistance();
        this.routes.add(e);
    }


}
