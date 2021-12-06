package ui;
import model.*;
import java.util.Scanner;

public class Main {
	public static NewBuilding buildingM = new NewBuilding("M");
	public static Scanner reader= new Scanner(System.in);
    public static void main(String[] args){
        boolean execute = true;
        int option = 0;
        while(execute){
            System.out.println("1. See all available rooms");
            System.out.println("2. Rent a mini room");
            System.out.println("3. Cancel a rental service");
            System.out.println("4. Map the DataCenter");
            System.out.println("5. Turn on power supply for all mini rooms ");
            System.out.println("6. Turn off mini rooms using a letter");
            System.out.println("7. Exit");
            option = reader.nextInt();
            reader.nextLine();
            switch(option){
                case 1: {
                    listOfAvailableRooms();
                    break;
                }
                case 2: {
                    rentMiniRoom();
                    break;
                }
                case 3: {
                    cancelRent();
                    break;
                }
                case 4: {
                    mapDataCenter();
                    break;
                }
                case 5: {
                    turnOnAllMiniRooms();
                    break;
                }
                case 6: {
                    turnOfMiniRooms();
                    break;
                }
                case 7: {
                    execute = false;
                    break;
                }
            }
                
            
        }
    }
    public static void listOfAvailableRooms() {
    	System.out.println(buildingM.listOfAvailableRooms());
    }
    public static void rentMiniRoom() {
    	System.out.println("Enter the mini room you want to rent");
    	String miniRoomID = reader.nextLine();
    	System.out.println("Enter the number of servers to rent");
    	int servers = reader.nextInt();
    	System.out.println("Enter the day, the month, then the year");
    	int day = reader.nextInt();
    	int month = reader.nextInt();
    	int year = reader.nextInt();
    	reader.nextLine();
    	System.out.println("Enter the client name");
    	String client = reader.nextLine();
    	System.out.println(buildingM.rent(day, month, year, servers, miniRoomID, client));
    }
    public static void cancelRent() {
    	System.out.println("Enter the identifier of the miniRoom to cancel its rent");
    	String miniRoomID = reader.nextLine();
    	System.out.println(buildingM.cancelRent(miniRoomID));
    }
    public static void mapDataCenter() {
    	System.out.println(buildingM.DataCenterMap());
    }
    public static void turnOnAllMiniRooms() {
    	buildingM.turnOnAllMiniRoomsTest();
    }
    public static void turnOfMiniRooms() {
    	System.out.println("Enter the type of simulation: (L), (Z), (H), (O), (M), (P)");
    	String option = reader.nextLine();
    	switch(option) {
	    	case "L": {
	            buildingM.turnOffL();
	            break;
	    	}
	    	case "Z": {
	            buildingM.turnOffZ();
	            break;
	    	}
	    	case "H": {
	            buildingM.turnOffH();
	            break;
	    	}
	    	case "O": {
	            buildingM.turnOffO();
	            break;
	    	}
	    	case "M": {
	    		System.out.println("Enter the column to apply the effect");
	    		int column = reader.nextInt();
	            buildingM.turnOffM(column);
	            break;
	    	}
	    	case "P": {
	    		System.out.println("Enter the hall to apply the effect");
	    		int hall = reader.nextInt();
	            buildingM.turnOffP(hall);
	            break;
	    	}
    	}
    	System.out.println(buildingM.DataCenterMap());
    }
}