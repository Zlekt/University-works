package model;
import java.util.*;

public class MiniRoom {
    
    private boolean available;
    private double defaultPrice;
    private String miniRoomIdentifier;
    private boolean powerSupply;
    
    public ArrayList<Server> servers;

    public MiniRoom(boolean available, double defaultPrice, String miniRoomIdentifier, boolean powerSupply){
        this.available=available;
        this.defaultPrice=defaultPrice;
        this.miniRoomIdentifier=miniRoomIdentifier;
        this.powerSupply=powerSupply;
        servers=new ArrayList<Server>();
    }
    
    public String toString(){
        String message="";
        return message+=miniRoomIdentifier+" "+defaultPrice+" "+available;
    }

    public boolean getavailable(){
        return available;
    }
    public void setAvailable(boolean available) {
    	this.available=available;
    }
    public double getDefaultPrice(){
        return defaultPrice;
    }
    public void setDefaultPrice(double price){
        defaultPrice = price;
    }
    public String getMiniRoomIdentifier() {
    	return miniRoomIdentifier;
    }
    public void setMiniRoomsIdentifier(String id) {
    	this.miniRoomIdentifier=id;
    }
    public void setPowerSupply(boolean powerSupply) {
    	this.powerSupply=powerSupply;
    }
    public boolean getPowerSupply() {
    	return powerSupply;
    }

    
}
