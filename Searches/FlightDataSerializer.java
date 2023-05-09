package Searches;
import java.io.*;

public class FlightDataSerializer {
    public static void serialize(FlightData flightData, String filename) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(flightData);
        out.close();
        fileOut.close();
    }
}