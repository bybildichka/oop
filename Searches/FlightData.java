package Searches;

import java.io.Serializable;

public class FlightData implements Serializable{
    private String Name;
    private int Price;
    private double Hours;
    private boolean IsLuxury;

    public FlightData(String name, int price, double hours, boolean isLuxury){
        this.Name = name;
        this.Price = price;
        this.Hours = hours;
        this.IsLuxury = isLuxury;
    }
    public String getAirport(){
        return Name;
    }
    public int getPrice(){
        return Price;
    }
    public double getHours(){
        return Hours;
    }
    public boolean getIsLuxury(){
        return IsLuxury;
    }
}