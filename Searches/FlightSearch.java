package Searches;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import GUI.*;
import Users.*;

public abstract class FlightSearch {
    protected User user;
    //public static FlightsMap flightsMap = new FlightsMap();
    public static FlightsMap flightsMap = null;
    public FlightSearch(User user) {
        this.user = user;
    }
    public String startSearch(String FirstCity, String SecondCity, double maxParameter){
        if (flightsMap == null) {
            try {
                FileInputStream fileIn = new FileInputStream("flightsMap.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                flightsMap = (FlightsMap) in.readObject();
                in.close();
                fileIn.close();
            } catch (IOException I) {
                flightsMap = new FlightsMap();
            } catch (ClassNotFoundException e) {
                System.err.println("ClassNotFoundException: " + e.getMessage());
            }
        }
        if(FirstCity.equals("") || SecondCity.equals("")){
            return "Airport should not be empty";
        }
        else if(!(Arrays.asList(flightsMap.getAirports()).contains(FirstCity) && Arrays.asList(flightsMap.getAirports()).contains(SecondCity))){
            return "Wrong airports";
        }
        else if(FirstCity.equals(SecondCity)){
            return "You don't need a flight";
        }
        try {
            FileOutputStream fileOut = new FileOutputStream("flightsMap.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(flightsMap);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
        return search(FirstCity, SecondCity, maxParameter);
    }
    public abstract String search(String firstCity, String SecondCity, double maxParameter);
}
