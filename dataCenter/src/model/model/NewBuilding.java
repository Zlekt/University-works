package model;
import java.util.*;

public class NewBuilding{

    public final static int HALLS = 8;
    public final static int COLUMS = 50;
    private String buildingID;
    private ArrayList<String> bills;
    
    private MiniRoom[][] miniRooms;
    

    public NewBuilding(String buildingID){
        miniRooms = new MiniRoom[HALLS][COLUMS];
        bills = new ArrayList<String>();
        int identifierSetter=01;
        for(int i=0; i<HALLS; i++) {
        	for(int j=0;j<COLUMS; j++) {
        		miniRooms[i][j]=new MiniRoom(true, 1000, Integer.toString(identifierSetter), false);
            	identifierSetter++;
        	}
        }
        this.buildingID = buildingID;
    }
    public String rent(int d, int m, int y, int servers, String identifier, String name) {
    	double cost = 0;
    	String message ="";
    	for(int i=0; i<HALLS; i++) {
    		for(int j=0; j<COLUMS; j++) {
    			if(identifier.equals(miniRooms[i][j].getMiniRoomIdentifier())) {
    				if(miniRooms[i][j].getavailable()) {
    					if(servers<4) {
    						cost =miniRooms[i][j].getDefaultPrice();
    						cost+=cost*0.15;
    						message+=name +" Day: "+d+" Month: "+m+" Year: "+y+" "+cost;
    						bills.add(message);
    						miniRooms[i][j].setAvailable(false);
    						miniRooms[i][j].setPowerSupply(true);
    					}
    				}else {
    					message="MiniRoom not available";
    				}
    			}
    		} 
    	}
    	
    	return message;
    }
    public String cancelRent(String identifier) {
    	String message="";
    	for(int i=0; i<HALLS; i++) {
    		for(int j=0; j<COLUMS; j++) {
    			if(identifier.equals(miniRooms[i][j].getMiniRoomIdentifier())) {
    				miniRooms[i][j].setAvailable(true);
    				message+="rental service deactivated";
    				miniRooms[i][j].setPowerSupply(false);
    			}
    		}
    	}
    	return message;
    }
    public void cost(){    //Calculates the base cost of all the miniRooms// 
        double result;
        for(int i=0; i<HALLS; i++){
            for(int j=0; j<COLUMS; j++){
            	if(i==0){
                       result = miniRooms[i][j].getDefaultPrice();
                       result-=result*0.1;
                       
                       miniRooms[i][j].setDefaultPrice(result);
                   }
                   else if(i==6){
                       result = miniRooms[i][j].getDefaultPrice();
                       result-=result*0.15;
                     
                       miniRooms[i][j].setDefaultPrice(result);
                   }
                   else if(i>0&&i<6){
                       result = miniRooms[i][j].getDefaultPrice();
                       result+=result*0.25;
                      
                       miniRooms[i][j].setDefaultPrice(result);
                   }
                   else{
                       result=miniRooms[i][j].getDefaultPrice();
                      
                    }
            }
        }
    }
    public void energySchedule() {//Turns on and turns off the energy supply to the miniRooms depending on the availability//
    	for(int i=0; i<HALLS; i++) {
    		for(int j=0; j<COLUMS; j++) {
    			if(miniRooms[i][j].getavailable()) {
    				miniRooms[i][j].setPowerSupply(false);
    			}else {
    				miniRooms[i][j].setPowerSupply(true);
    			}
    		}
    	}
    }
    public void turnOffL() {
    	for(int i=0; i<HALLS; i++) {
    		for(int j=0; j<COLUMS; j++) {
    			if(i==0) {
    				miniRooms[i][j].setPowerSupply(false);
    			}
    			if(j==0) {
    				miniRooms[i][j].setPowerSupply(false);
    			}
    		}
    	}
    }
    public void turnOffZ() {
    	for(int i=0; i<HALLS; i++) {
    		for(int j=0; j<COLUMS; j++) {
    			if(i==0) {
    				miniRooms[i][j].setPowerSupply(false);
    			}
    			if(i==7) {
    				miniRooms[i][j].setPowerSupply(false);
    			}
    		}
    	}
    }
    public void turnOffH() {
    	for(int i=0; i<HALLS; i++) {
    		for(int j=0; j<COLUMS; j++) {
    			if(i%2!=0) {
    				miniRooms[i][j].setPowerSupply(false);
    			}
    		}
    	}
    }
    public void turnOffO() {
    	for(int i=0; i<HALLS; i++) {
    		for(int j=0; j<COLUMS; j++) {
    			if(i==0) {
    				miniRooms[i][j].setPowerSupply(false);
    			}
    			if(i==7) {
    				miniRooms[i][j].setPowerSupply(false);
    			}if(j==0) {
    				miniRooms[i][j].setPowerSupply(false);
    			}if(j==49) {
    				miniRooms[i][j].setPowerSupply(false);
    			}
    		}
    	}
    }
    public void turnOffM(int column) {
    	for(int i=0; i<HALLS; i++) {
    		for(int j=0; j<COLUMS; j++) {
    			if(j==column) {
    				miniRooms[i][j].setPowerSupply(false);
    			}
    		}
    	}
    }
    public void turnOffP(int hall) {
    	for(int i=0; i<HALLS; i++) {
    		for(int j=0; j<COLUMS; j++) {
    			if(i==(hall-1)) {
    				miniRooms[i][j].setPowerSupply(false);
    			}
    		}
    	}
    }
    public String listOfAvailableRooms() {
    	cost();
    	String message="";
    	for(int i=0; i<HALLS; i++) {
    		for(int j=0; j<COLUMS; j++) {
    			if(miniRooms[i][j].getavailable()) {
    				message+=miniRooms[i][j].getMiniRoomIdentifier()+" "+i+" "+j+" "+miniRooms[i][j].getDefaultPrice();
    				if(i==0 || i==7 || j==0 || j==49) {
    					message+="Window\n";
    				}else {
    					message+="Not window\n";
    				}
    			}
    		}
    	}
    	return message;
    }
   public void turnOnAllMiniRoomsTest() {
	   for(int i=0; i<HALLS; i++) {
		   for(int j=0; j<COLUMS; j++) {
			   miniRooms[i][j].setPowerSupply(true);
		   }
	   }
   }
   public String DataCenterMap() {
	   String message="";
	   for(int i=0; i<HALLS; i++) {
		   for(int j=0; j<COLUMS; j++) {
			   message+=miniRooms[i][j].getMiniRoomIdentifier()+": "+miniRooms[i][j].getPowerSupply()+", ";
		   }
		   message+="\n";
	   }
	   return message;
   }
}