package com.pbw.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SalamonReader {

    private Vehicle Vehicles;
    private ArrayList<Vehicle> vihicleList;

    public SalamonReader() {
        Vehicles = new Vehicle();
        vihicleList = new ArrayList<Vehicle>();
    }

    public SalamonReader(String path) throws FileNotFoundException {
        Vehicles = new Vehicle();
        vihicleList = new ArrayList<Vehicle>();
        Scanner scan = null;
        Customer c = new Customer();
        ArrayList<Customer> Customers;
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (int k = 0; k < listOfFiles.length; k++) {
            Vehicles = new Vehicle();
            Customers = new ArrayList<Customer>();
            File file = listOfFiles[k];
            if (file.isFile() && file.getName().endsWith(".txt")) {
                Vehicles.setDataFileSource(file.getName());

                File f = new File("src/salomonReader/sourceFile/" + file.getName());
                try {
                    scan = new Scanner(f);
                } catch (FileNotFoundException e) {
                    System.out.println("File not found.");
                    System.exit(0);
                }

                int total = 0;
                boolean foundInts = false; //flag to see if there are any integers
                int i = 0;
                while (scan.hasNextLine()) { //Note change

                    String currentLine = scan.nextLine();
                    //split into words
                    String words[] = currentLine.split(" ");


                    //For each word in the line
                    for (String str : words) {
                        try {

                            int num = Integer.parseInt(str);
                            total += num;
                            foundInts = true;
                            //create Vehicle
                            if (i == 0) {
                                Vehicles.setVehicle(num);
                            }
                            if (i == 1) {
                                Vehicles.setCapacity(num);
                            }
                            //class Customer
                            if (i != 0 & i != 1) {
                                if (i == 2) {
                                    c = new Customer();
                                    c.setCustNo(num);
                                }
                                if (i == 3) {
                                    c.setxCoord(num);
                                }
                                if (i == 4) {
                                    c.setyCoord(num);
                                }
                                if (i == 5) {
                                    c.setDemand(num);
                                }
                                if (i == 6) {
                                    c.setReadyTime(num);
                                }
                                if (i == 7) {
                                    c.setDueDate(num);
                                }
                                if (i == 8) {
                                    c.setService(num);
                                    i = 1;
                                    Customers.add(c);
                                }
                            }
                            i++;
                        } catch (NumberFormatException nfe) {
                            System.out.println("Word is not an integer, do nothing.");
                        }
                    }
                }//end while

                Vehicles.setCustomers(Customers);
                vihicleList.add(Vehicles);
                // System.out.println(Vehicles.getCustomers().get(Vehicles.getCustomers().size()-1).getDueDate());

                if (!foundInts)
                    System.out.println("No numbers found.");

                // close the scanner
                scan.close();
            }

        }
    }

    public Vehicle getVechicles() {
        return Vehicles;
    }

    public void setVechicles(Vehicle vechicles) {
        this.Vehicles = vechicles;
    }

    public Vehicle getVehicles() {
        return Vehicles;
    }

    public void setVehicles(Vehicle Vehicles) {
        this.Vehicles = Vehicles;
    }

    public ArrayList<Vehicle> getVihicleList() {
        return vihicleList;
    }

    public void setVihicleList(ArrayList<Vehicle> vihicleList) {
        this.vihicleList = vihicleList;
    }

    public int getVehicleIndexByVehicleNumber(int VehicleNo) {
        for (int i = 0; i < this.vihicleList.size(); i++) {
            if (this.vihicleList.get(i).getVehicle() == VehicleNo) {
                return i;
            }
        }
        return -1;
    }

    public int getVehicleIndexByVehicleCapacity(int VehicleCapacity) {
        for (int i = 0; i < this.vihicleList.size(); i++) {
            if (this.vihicleList.get(i).getCapacity() == VehicleCapacity) {
                return i;
            }
        }
        return -1;
    }


}


//first  put here the path of the files
//salamonReader sr = new salamonReader("src/salomonReader/sourceFile");

//here is some useful functions

//---------get vihicle Index first---------------

//int index=sr.getVehicleIndexByVehicleNumber(25);
//         OR
//int index=sr.getVehicleIndexByVehicleCapacity(200);

//----------------------------------------------

//then

//sr.getVihicleList().get(index).getVehicle()
//sr.getVihicleList().get(index).getCapacity()
//sr.getVihicleList().get(index).getCustomers().get(idcustomer).getCustNo()
//sr.getVihicleList().get(index).getCustomers().get(idcustomer).getxCoord()


// here is how to list of all contents
        /*
        for(int p=0;p<sr.getVihicleList().size();p++){
		      System.out.println("fileName= "+sr.getVihicleList().get(p).getDataFileSource()+" vehicle"+sr.getVihicleList().get(p).getVehicle()+" capacity"+sr.getVihicleList().get(p).getCapacity());
		      for(int j=0;j<sr.getVihicleList().get(p).getCustomers().size();j++){
		    	  System.out.println("cust NO="+sr.getVihicleList().get(p).getCustomers().get(j).getCustNo()+" xcord="+sr.getVihicleList().get(p).getCustomers().get(j).getxCoord()+" ycord="+sr.getVihicleList().get(p).getCustomers().get(j).getyCoord()+" demand="+sr.getVihicleList().get(p).getCustomers().get(j).getDemand()+" readytime="+sr.getVihicleList().get(p).getCustomers().get(j).getReadyTime()+" duedate="+sr.getVihicleList().get(p).getCustomers().get(j).getDueDate()+" service="+sr.getVihicleList().get(p).getCustomers().get(j).getService());
		      }
			}
*/