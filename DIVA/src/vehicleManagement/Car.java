package vehicleManagement;

/**
 * 
 * A Car Class which represents the type of a Vehicle.
 *
 */
public class Car extends Vehicle{



	/**
	 * Creates a car object initialized with the given fields. 
	 * @param location
	 * @param capacity
	 * @param type
	 * @param manufacturer
	 * @param year
	 * @param color
	 * @param status
	 * @param features
	 */
		public Car(String location, int capacity, int dailyRate, int weeklyRate,
			int hourlyRate, int perKMRate, int dailyInsuranceRate,
			int hourlyInsuranceRate, int weeklyInsuranceRate, String type,
			String manufacturer, String year, String color, String status,
			String features) {
		super(location, capacity, dailyRate, weeklyRate, hourlyRate, perKMRate,
				dailyInsuranceRate, hourlyInsuranceRate, weeklyInsuranceRate, type,
				manufacturer, year, color, status, features);
		// TODO Auto-generated constructor stub
	}
	
	
}
