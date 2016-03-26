package paymentManagement;

import vehicleManagement.Equipment;
import vehicleManagement.Vehicle;

public class paymentManager {

	private final double TAX = 0.05;
	private int numReceipts;
	private Receipt[] list;
	private Receipt currentReceipt;
	
	
	public paymentManager(){
		list = new Receipt[numReceipts];
	}

	public void create_new_Receipt(){
		
	}

	public int getNumReceipts() {
		return numReceipts;
	}


	public void setNumReceipts(int numReceipts) {
		this.numReceipts = numReceipts;
	}


	public Receipt[] getList() {
		return list;
	}


	public void setList(Receipt[] list) {
		this.list = list;
	}


	public Receipt getCurrentReceipt() {
		return currentReceipt;
	}


	public void setCurrentReceipt(Receipt currentReceipt) {
		this.currentReceipt = currentReceipt;
	}
	
	public void calculate_price(Vehicle vehicleType, double insurance){
		
	}
	public void calculate_price(Vehicle vehicleType, double insurance, Equipment equipment){
		
	}
	
}