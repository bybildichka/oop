package Searches;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import GUI.*;
import Users.*;

public class TimeFlightSearch extends FlightSearch {
    boolean IncludesLuxury = user.getIsPremium();
    public TimeFlightSearch(User user) {
        super(user);
    }

    public String search(String FirstCity, String SecondCity, double maxCost) {
        String searchResult = "Not found";
        Map<String, Map<String, Double>> temp = new HashMap<>();
        for (String tempAirport : flightsMap.getAirports()) {
            Map<String, Double> tempFlights = new HashMap<>();
            List<FlightData> tempFlightData = flightsMap.getFlights(tempAirport);
            if(IncludesLuxury){
                for (FlightData flightData : tempFlightData) {
                        String destinationAirport = flightData.getAirport();
                        double hours = flightData.getHours();
                        tempFlights.put(destinationAirport, hours);
                } 
            }
            else
            {
                for (FlightData flightData : tempFlightData) {
                    if(flightData.getIsLuxury() == false){
                        String destinationAirport = flightData.getAirport();
                        double hours = flightData.getHours();
                        tempFlights.put(destinationAirport, hours);
                    }
                }
            }
            temp.put(tempAirport, tempFlights);
        }
        searchResult = SearchMinSum.findMin(temp, FirstCity, SecondCity, maxCost, "time");
        return searchResult;
    }
    
}