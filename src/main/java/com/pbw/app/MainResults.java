package com.pbw.app;

// RUN this file to show result

//-----------------------  AUTHOR : PERRINE ----------------------------

public class MainResults {
    static Result result;

    public static void main(String[] args) {

        result = new Result();

        // 1)- we add 3 routes using the methode addRoute(Calacity,Distance,visitedCustomer)
        addRoute(10, 20, new int[]{57, 77, 18, 23, 28, 88, 68, 13, 8, 3});
        addRoute(11, 21, new int[]{1, 6, 11, 64, 84, 26, 21, 16, 73, 53});
        addRoute(12, 22, new int[]{0, 5, 10, 62, 82, 25, 20, 15, 71, 51});

        // 2)- Now we display the results
        printResult(result);
    }

    // This methode allow us to add routes in the arraylist of an Route's object
    public static void addRoute(int capacity, int distance, int[] visitedCustomer) {
        //The object result contains an arrayList attribute named "routes", so we add on it the routes.
        result.addRoute(new Route(capacity, distance, visitedCustomer));
    }

    // This methode delete all routes we added
    public static void deleteRoutes() {
        result.setRoutes(null);
    }

    // This method display the result
    public static void printResult(Result result) {
        System.out.println("Result");
        System.out.println("Number of routes:    " + result.getRoutes().size());
        System.out.println("Total solution Distance:    " + result.getTotalDistance());
        int counter = 0;
        for (Route r : result.getRoutes()) {
            System.out.println();
            System.out.println("Route " + counter + " Capacity: " + r.getCapacity());
            System.out.println("Route " + counter + " Distance: " + r.getDistance());
            System.out.println("Route " + counter + " Visited clients: ");

            for (int i : r.getVisitedClients()) {
                System.out.println(i);
            }
            counter = counter + 1;
        }
    }
}
