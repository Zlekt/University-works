package model;


public class Server {

	
	private int cacheMemory;
	private int processorsNumber;
	private int ramQuantity; //in GB//
	private int disksNumber; 
	private int disksCapacity; //in TB//
	
	
	public Server(int cacheMemory, int processorsNumber, int ramQuantity, int disksNumber, int disksCapacity) {
		this.cacheMemory=cacheMemory;
		this.disksCapacity=disksCapacity;
		this.processorsNumber=processorsNumber;
		this.ramQuantity=ramQuantity;
		this.disksNumber=disksNumber;
	}
	public String toString() {
		String message="";
		message+=cacheMemory+" "+disksCapacity+" "+disksNumber+" "+processorsNumber+" "+ramQuantity;
		return message;
	}
	public int getCacheMemory() {
		return cacheMemory;
	}
	public void setCacheMemory(int cacheMemory) {
		this.cacheMemory = cacheMemory;
	}
	public int getProcessorsNumber() {
		return processorsNumber;
	}
	public void setProcessorsNumber(int processorsNumber) {
		this.processorsNumber = processorsNumber;
	}
	public int getRamQuantity() {
		return ramQuantity;
	}
	public void setRamQuantity(int ramQuantity) {
		this.ramQuantity = ramQuantity;
	}
	public int getDisksNumber() {
		return disksNumber;
	}
	public void setDisksNumber(int disksNumber) {
		this.disksNumber = disksNumber;
	}
	public int getDisksCapacity() {
		return disksCapacity;
	}
	public void setDisksCapacity(int disksCapacity) {
		this.disksCapacity = disksCapacity;
	}
	public int getGetCacheMemory() {
		return cacheMemory;
	}
	public void setGetCacheMemory(int getCacheMemory) {
		this.cacheMemory = getCacheMemory;
	}
}
