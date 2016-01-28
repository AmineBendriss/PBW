package com.pbw.app;

import java.util.ArrayList;

public class Vehicle {
    private ArrayList<Customer> customers;
    private String dataFileSource;
    private int vehicle;
    private int capacity;

    public Vehicle() {
    }

    public int getVehicle() {
        return vehicle;
    }

    public void setVehicle(int vehicle) {
        this.vehicle = vehicle;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public String getDataFileSource() {
        return dataFileSource;
    }

    public void setDataFileSource(String dataFileSource) {
        this.dataFileSource = dataFileSource;
    }


}
