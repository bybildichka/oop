package Searches;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import GUI.*;
import Users.*;


public class CostFlightSearch extends FlightSearch {

    public CostFlightSearch(User user) {
        super(user);
    }

    public String search(String FirstCity, String SecondCity, double maxCost) {
        String searchResult = "Not found";
        Map<String, Map<String, Double>> temp = new HashMap<>();
        for (String tempAirport : flightsMap.getAirports()) {
            Map<String, Double> tempFlights = new HashMap<>();
            List<FlightData> tempFlightData = flightsMap.getFlights(tempAirport);
            for (FlightData flightData : tempFlightData) {
                if(flightData.getIsLuxury() == false){
                    String destinationAirport = flightData.getAirport();
                    double cost = flightData.getPrice();
                    tempFlights.put(destinationAirport, cost);
                }
            }
            temp.put(tempAirport, tempFlights);
        }
        searchResult = SearchMinSum.findMin(temp, FirstCity, SecondCity, maxCost, "cost");
        return searchResult;
    }
    
}
