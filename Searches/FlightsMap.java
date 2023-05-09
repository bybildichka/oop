package Searches;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.*;

public class FlightsMap implements Serializable{    
    private String[] airports = {"London","Paris","Amsterdam","Frankfurt","Madrid","Barcelona","Istanbul","Munich","Rome","Dublin","Copenhagen","Vienna","Zurich","Athens","Oslo",
    "Stockholm","Helsinki","Brussels","Moscow","Lisbon","Manchester","Warsaw","Edinburgh","Prague","Budapest","Glasgow","Bucharest","Belgrade","Hamburg","Geneva"};
    private Map<String, List<FlightData>> flights;

    public FlightsMap(){
        flights = new HashMap<String, List<FlightData>>();
        for(String airport: airports){
            flights.put(airport, new ArrayList<FlightData>());
        }
        Random rand = new Random();
        for (int i = 0; i < 150; i++) {
            String source = airports[rand.nextInt(airports.length)];
            String destination = airports[rand.nextInt(airports.length)];
            while (destination.equals(source)) {
                destination = airports[rand.nextInt(airports.length)];
            }
            int price = rand.nextInt(100) + 15;
            DecimalFormat df = new DecimalFormat("#.###");
            double hours = Double.parseDouble(df.format(rand.nextDouble() * 5 + 1));
            boolean isLuxury = rand.nextBoolean();
            if(isLuxury){
                flights.get(source).add(new FlightData(destination, 2*price, 0.7*hours, isLuxury));
            }
            else{
                flights.get(source).add(new FlightData(destination, price, hours, isLuxury));
            }
        }
    }

    public String[] getAirports(){
        return airports;
    }

    public List<FlightData> getFlights(String airport){
        return flights.get(airport);
    }
}