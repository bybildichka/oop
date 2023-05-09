package Searches;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import GUI.*;
import Users.*;


public class SearchMinSum{
    public static String findMin(Map<String, Map<String, Double>> SearchMap, String FirstCity, String SecondCity, double parameter, String searchType){
        Map<String, Double> distancesFromStart1 = DijkstraAlgorithm.findShortestPaths(SearchMap, FirstCity);
        Map<String, Double> distancesFromStart2 = DijkstraAlgorithm.findShortestPaths(SearchMap, SecondCity);
        double minSumDistance = Integer.MAX_VALUE;
        String vertexWithMinSumDistance = null;

        for (String vertex : distancesFromStart1.keySet()) {
            double sumDistance = distancesFromStart1.get(vertex) + distancesFromStart2.get(vertex);
            if (sumDistance < minSumDistance) {
                minSumDistance = sumDistance;
                vertexWithMinSumDistance = vertex;
            }
        }
        if(minSumDistance == Integer.MAX_VALUE || vertexWithMinSumDistance == null){
            return "There is no way";
        }
        else if(minSumDistance < parameter){
            return "Your desination is: " + vertexWithMinSumDistance + "\nFlights " + searchType + ":" + minSumDistance;
        }
        else{
            return "There are no flights upon your requirements. Here is the best one: \nCity: " + vertexWithMinSumDistance + "\nPrice: " + minSumDistance;
        }
    }
}