package paymentManager;
import java.util.Date;
import vehicleManager.Equipment;

/**
 * 
 * Payment Manager 
 *
 */

public class paymentManager {
			
	static final double TAX = 0.05;
	static double priceEquipment;
	
	
	public static double calculate_price (double priceVehicle, double priceEquipment, final double TAX){
		double final_price = 0.00;
		return final_price;
	}
	
	public static double calculate_price (double priceVehicle, final double TAX){
		double final_price = 0.00;
		return final_price;
	}
	
	public static double add_rate_child_safety_seat(int numSeats){
		return priceEquipment;
	}
	
	public static double add_rate_ski_Rack(Equipment equipment){
		return priceEquipment;
	}
	
	public static double add_rate_car_tow(Equipment equipment){
		return priceEquipment;
	}
	
	public static double add_rate_lift_gate(Equipment equipment){
		return priceEquipment;
	}
	
	
	public Receipt search_transaction_history (String customerId, Date date, String vehicleId){
		Receipt receipt = null;
		return receipt;
	}
	
	public Receipt[] search_transaction_history_list(Date date){
		Receipt[] receiptList = null;
		return receiptList;
	}
	
	public Receipt[] search_transaction_history_list_by_Customer(String customerId){
		Receipt[] receiptList = null;
		return receiptList;
	}
	
	public Receipt[] search_transaction_history_list_by_Vehicle(String vehicleId){
		Receipt[] receiptList = null;
		return receiptList;
	}
	
	
	public void process_payment_credit(String creditCard){	
	}
	
	public void process_payment_cash(double amount){
	}
	
	public void process_payment_points(int points){
	}
	
	public void calculate_earned_points(){	// Every $5 spent = 1 point earned. What a shitty deal. - Kevin
		
	}

	public void increment_points(){
		
	}
}
