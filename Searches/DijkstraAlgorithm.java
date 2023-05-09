package Searches;
import java.util.*;

public class DijkstraAlgorithm {
    
    public static Map<String, Double> findShortestPaths(Map<String, Map<String, Double>> graph, String sourceVertex) {
        Map<String, Double> shortestDistances = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>((v1, v2) -> Double.compare(shortestDistances.get(v1), shortestDistances.get(v2)));
        
        for (String vertex : graph.keySet()) {
            if (vertex.equals(sourceVertex)){
                shortestDistances.put(vertex, 0.0);
            }
            else{
                shortestDistances.put(vertex, Double.MAX_VALUE);
            }
            queue.offer(vertex);
        }
        
        while (!queue.isEmpty()) {
            String currentVertex = queue.poll();
            
            if (shortestDistances.get(currentVertex) == Double.MAX_VALUE) {
                break;
            }
            
            for (Map.Entry<String, Double> neighborEntry : graph.get(currentVertex).entrySet()) {
                String neighborVertex = neighborEntry.getKey();
                Double edgeWeight = neighborEntry.getValue();
                
                Double pathDistance = shortestDistances.get(currentVertex) + edgeWeight;
                
                if (pathDistance < shortestDistances.get(neighborVertex)) {
                    queue.remove(neighborVertex);
                    shortestDistances.put(neighborVertex, pathDistance);
                    queue.offer(neighborVertex);
                }
            }
        }
        
        return shortestDistances;
    }
}
