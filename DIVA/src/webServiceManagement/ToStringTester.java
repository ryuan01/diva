package webServiceManagement;

import java.math.BigDecimal;

import accountManagement.Customer;
import accountManagement.Employee;
import accountManagement.SuperCustomer;
import paymentManagement.Receipt;
import rentalManagement.Rental;
import rentalManagement.Reservation;
import systemManagement.Branch;
import vehicleManagement.Car;
import vehicleManagement.Equipment;
import vehicleManagement.Truck;

public class ToStringTester {

	public static void main(String[] args) {
		
//Make an Instance of each entity
		
		//Customer
		
		Customer customer = new Customer("temp", "temp", "temp", "temp", "temp", 0, "temp", "temp", "temp", "temp", "temp", "temp", "temp","temp");
		
		//SuperCustomer

		SuperCustomer superCustomer = new SuperCustomer(customer, 500);
		
		//Car
		
		Car car = new Car(0, "temp", "temp", "temp", "temp", "temp", "temp", "temp", 0, "temp", false, false, 0);
		
		//Truck
		
		Truck truck = new Truck(0, "temp", "temp", "temp", "temp", "temp", "temp", "temp", "temp", "temp", "temp", 0);
		
		//Manager
		
		Employee manager = new Employee("temp", "temp", "temp","temp","temp", 0, "temp", 0);
		
		//Branch
		
		Branch branch = new Branch(0, "temp", "temp", "temp", "temp");
		
		//Receipt
		
		Receipt receipt = new Receipt(0, 0, 0, "temp", "temp");
		
		//Equiptment
		
		Equipment equiptment = new Equipment(0,"temp" , 2);
		
		//Reservation
		
		Reservation reservation = new Reservation("startD", "endD", 1, new int[]{1}, 1, 1, 1, 
				 1, new BigDecimal(22.22), false);
		
		//Rental
		
		Rental rental = new Rental(reservation);
		
		//Print those entities to string
		
		System.out.println(customer.toString());
		System.out.println(superCustomer.toString());
		System.out.println(car.toString());
		System.out.println(truck.toString());
		
		System.out.println(manager.toString());
		System.out.println(branch.toString());
		System.out.println(receipt.toString());
		System.out.println(equiptment.toString());
		System.out.println(reservation.toString());
		System.out.println(rental.toString());
	}
}
