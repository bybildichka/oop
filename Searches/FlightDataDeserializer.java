package Searches;
import java.io.*;

public class FlightDataDeserializer {
    public static FlightData deserialize(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        FlightData flightData = (FlightData) in.readObject();
        in.close();
        fileIn.close();
        return flightData;
    }
}
