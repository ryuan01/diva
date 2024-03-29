package databaseManagement;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;

import paymentManagement.Receipt;

/**
 * Connect to Database to provide services related to PriceList
 * row order of car: {"economy","compact","midsized","standard","fullsized","premium","SUV","van","luxury"}
 * row order of truck: "24-foot","15-foot","12-foot","box-truck"
 *
 */
class PriceDB {
	
	private static final int PRICE_ROW_SIZE = 3;
	
	private static final int NUMBER_RENTAL_PRICE_TYPE = 5;
	private static final int NUMBER_CAR_TYPE = 9;
	private static final int NUMBER_TRUCK_TYPE = 4;
	private static final int NUMBER_INSURANCE_PRICE_TYPE = 3;
	private static final int NUMBER_EQ_TYPE = 4;
	
	private static final String CUSTOMER = "customer";
	private static String CAR = "car";
	private ConnectDB dbm;
	
	/**
	 * Constructor connects to database 
	 */
	PriceDB(){
		dbm = new ConnectDB();
	}

	/**
	 * Gets all car prices 
	 * @return all car prices 
	 * @throws SQLException
	 */
	BigDecimal[][] getCarPriceList() throws SQLException {
  		BigDecimal[][] prices = new BigDecimal[NUMBER_CAR_TYPE][NUMBER_RENTAL_PRICE_TYPE];
  		
  		dbm.connect();
        String query = "SELECT `perHour`, `perDay`, `perWeek`, `perMonth`, `perKM` "
        		+ "FROM `car_price`";
  		Statement stmt = dbm.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        //parse result and add to the BigDecimal array
        for (int i=0;i < NUMBER_CAR_TYPE + 1;i++){
        	if (rs.next()){
    			for (int j=0;j<NUMBER_RENTAL_PRICE_TYPE;j++){
        			prices[i][j] = rs.getBigDecimal(j+1);
        			//System.out.print(prices[i][j] + " ");
        		}
    			//System.out.println();
        	}
        }
        
        //clean up
        rs.close();
        stmt.close();	
        dbm.disconnect();
        
        return prices;
	}

	/**
	 * Gets all truck prices 
	 * @return all truck prices 
	 * @throws SQLException
	 */
	BigDecimal[][] getTruckPriceList() throws SQLException {
		// 
  		BigDecimal[][] prices = new BigDecimal[NUMBER_TRUCK_TYPE][NUMBER_RENTAL_PRICE_TYPE];
  		
  		dbm.connect();
        String query = "SELECT `perHour`, `perDay`, `perWeek`, `perMonth`, `perKM` FROM `truck_price`";
  		Statement stmt = dbm.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        //parse result and add to the BigDecimal array
        for (int i=0;i<prices.length;i++){
    		if (rs.next()){
    			for (int j=0;j<prices[i].length;j++){
        			prices[i][j] = rs.getBigDecimal(j+1);
        			//System.out.print(prices[i][j]);
        		}
    			//System.out.println();
        	}
        }
        
        //clean up
        rs.close();
        stmt.close();	
        dbm.disconnect();
        
        return prices;
	}

	/**
	 * Gets all equipment prices 
	 * @return all equipment prices 
	 * @throws SQLException
	 */
	BigDecimal[][] getEquipmentPriceList() throws SQLException {
		// 
  		BigDecimal[][] prices = new BigDecimal[NUMBER_EQ_TYPE][NUMBER_INSURANCE_PRICE_TYPE];
  		
  		dbm.connect();
        String query = "SELECT `perHour`, `perDay`, `perWeek` FROM `equipment_price`";
  		Statement stmt = dbm.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        //parse result and add to the BigDecimal array
        for (int i=0;i<prices.length;i++){
    		if (rs.next()){
    			for (int j=0;j<prices[i].length;j++){
    				// 
        			prices[i][j] = rs.getBigDecimal(j+1);
        			//System.out.print(prices[i][j] + " ");
        		}
    			//System.out.println();
        	}
        }
        
        //clean up
        rs.close();
        stmt.close();	
        dbm.disconnect();
        
        return prices;
	}

	/**
	 * Gets all car insurance prices
	 * @return all car insurance prices 
	 * @throws SQLException
	 */
	BigDecimal[][] getCarInsurancePriceList() throws SQLException {
		// 
  		BigDecimal[][] prices = new BigDecimal[NUMBER_CAR_TYPE][NUMBER_INSURANCE_PRICE_TYPE];
  		
  		dbm.connect();
        String query = "SELECT `perHour`, `perDay`, `perWeek` FROM `insurance_car_price`";
  		Statement stmt = dbm.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        //parse result and add to the BigDecimal array
        for (int i=0;i<prices.length;i++){
    		if (rs.next()){
    			for (int j=0;j<prices[i].length;j++){
        			prices[i][j] = rs.getBigDecimal(j+1);
        			//System.out.println(prices[i][j]);
        		}
    			//System.out.println();
        	}
        }
        
        //clean up
        rs.close();
        stmt.close();	
        dbm.disconnect();
        
        return prices;
	}

	/**
	 * Gets all truck insurance prices
	 * @return all truck insurance prices 
	 * @throws SQLException
	 */
	BigDecimal[][] getTruckInsurancePriceList() throws SQLException {
		// 
 		BigDecimal[][] prices = new BigDecimal[NUMBER_TRUCK_TYPE][NUMBER_INSURANCE_PRICE_TYPE];
  		
  		dbm.connect();
        String query = "SELECT `perHour`, `perDay`, `perWeek` FROM `insurance_truck_price`";
  		Statement stmt = dbm.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        //parse result and add to the BigDecimal array
        for (int i=0;i<prices.length;i++){
    		if (rs.next()){
    			for (int j=0;j<prices[i].length;j++){
        			prices[i][j] = rs.getBigDecimal(j+1);
        			//System.out.println(prices[i][j]);
        		}
    			//System.out.println();
        	}
        }
        
        //clean up
        rs.close();
        stmt.close();	
        dbm.disconnect();
        
        return prices;
	}

	/**
	 * Get a row of price (perHour, perDay, perWeek
	 * @param type 
	 * @param table_name
	 * @throws SQLException 
	 */
	 BigDecimal[] getPriceRow(String type, String table_name) throws SQLException {
			// 
	 		BigDecimal[] prices = new BigDecimal[PRICE_ROW_SIZE];
	  		
	  		dbm.connect();
	        String query = "SELECT `perHour`, `perDay`, `perWeek` FROM " +table_name
	        				+" WHERE class = \'" +type+"\'";
	       // System.out.println(query);
	        //System.exit(0);
	  		Statement stmt = dbm.getConnection().createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        
	        //parse result and add to the BigDecimal array 
	    	if(rs.next()){
	    		for (int i=0; i< prices.length;i++){
	    			prices[i] = rs.getBigDecimal(i+1);
	    			//System.out.println(prices[i][j]);
	    		}
	        }
	        
	        /*//print out prices
	        System.out.println("inside priceDB: ");
	        for (int j =0; j< prices.length;j++){
	        	System.out.print(prices[j]+" ");
	        }*/
	        //clean up
	        rs.close();
	        stmt.close();	
	        dbm.disconnect();
	        
	        return prices;
		
	}
	 
	 /**
	  * Gets all extra charge prices 
	  * @return all extra charge prices 
	  * @throws SQLException 
	  */
	 BigDecimal[] getAllExtraChargePrice() throws SQLException{
		 Connection conn;
		 Statement stmt;
		 String query;
		 ResultSet rs;
		 
		 BigDecimal[] extraCharge = new BigDecimal[PRICE_ROW_SIZE];
		 
		 query = "SELECT price FROM `extra_charge`;";
		 
		 dbm.connect();
		 conn = dbm.getConnection();
		 stmt = conn.createStatement();
		 
		 rs = stmt.executeQuery(query);
		 
		 for(int i = 0; rs.next(); i++){
			 extraCharge[i] = rs.getBigDecimal("price");
		 }
		 
		 rs.close();
		 stmt.close();
		 dbm.disconnect();
		 
		 return extraCharge;
	 }
	 
	 /**
	  * Gets all insurance prices for car or truck 
	  * @param vehicleType car or truck 
	  * @return all insurance prices of that type 
	 * @throws SQLException 
	  */
	 BigDecimal[][] getAllInsurancePrice(String vehicleType) throws SQLException{
		Connection conn;
		Statement stmt;
		ResultSet rs;
		String query;
		
		String table;
		int numberOfVehicleTypes;
		
		if (vehicleType == CAR){
			table = "insurance_car_price";
			numberOfVehicleTypes = NUMBER_CAR_TYPE;
		} else{
			table = "insurance_truck_price";
			numberOfVehicleTypes = NUMBER_TRUCK_TYPE;
		}
		
		 
		
		BigDecimal[][] insurancePrices = new BigDecimal[numberOfVehicleTypes][NUMBER_INSURANCE_PRICE_TYPE];
		query = "SELECT * FROM " + table + ";";
		
		dbm.connect();
		
		conn = dbm.getConnection();
		stmt = conn.createStatement();
		
		rs = stmt.executeQuery(query);
		
		for (int i = 0; rs.next() && i < numberOfVehicleTypes ; i++){
			
			insurancePrices[i][0] = rs.getBigDecimal("perHour");
			insurancePrices[i][1] = rs.getBigDecimal("perDay");
			insurancePrices[i][2] = rs.getBigDecimal("perWeek");
			
			
		}
		
		return insurancePrices;
	 }
	 
	 
	 /**
	  * Add receipt to database
	  * @param receipt receipt object 
	  * @throws Error 
	  * @throws SQLException 
	  */
	 void addReceipt(Receipt receipt) throws SQLException, Error{
		 
		 Connection conn;
		 Statement stmt;
		 String query;
		 
		 //local variabls 
		 int customerID;
		 String basic_info;
		 String payment_info;
		
		 customerID = receipt.getReceiptCustomer();
		 
		 dbm.connect();
		 
		 if(isElementAvailable(customerID, CUSTOMER)){
			 basic_info = receipt.getBasicInfo();
			 payment_info = receipt.getPaymentInfo();
			 
			 query = "INSERT INTO `receipt`(`customer_id`,  `payment_info`, `basic_info`) "
			 		+ "VALUES(" + customerID +",\"" + payment_info + "\",\"" + basic_info +"\");";
			 
			 
			 conn = dbm.getConnection();
			 stmt = conn.createStatement();
			 
			 stmt.executeUpdate(query);
			 
			 stmt.close();
			 dbm.disconnect();
		 } else{
			 dbm.disconnect();
			 throw new Error("customer is not registered in the system");
			 }
		 }
		 
 	/**
 	 * Gets receipt from customer id
 	 * @param customer_id ID of customer
 	 * @return receipts 
 	 * @throws Error 
 	 * @throws SQLException 
 	 */	 
	 Receipt[] getReceipt(int customer_id) throws SQLException, Error{
		 //
		 Connection conn;
		 Statement stmt;
		 String query;
		 ResultSet rs;
		 
		 //receipt variables
		 int receipt_id;
		 int clerk_id;
		 String basic_info;
		 String payment_info;
		 
		 ArrayList<Receipt> r = new ArrayList<Receipt>();
		 
		 dbm.connect();
		 
		 if (isElementAvailable(customer_id, CUSTOMER)){
			 query = "SELECT * FROM receipt "
			 		+ "WHERE customer_id = " + customer_id +";";
			 conn = dbm.getConnection();
			 stmt = conn.createStatement();
			 
			 rs = stmt.executeQuery(query);
			 
			 while(rs.next()){
				 if(rs.getInt("customer_id") == customer_id){
					 receipt_id = rs.getInt("receipt_id");
					 clerk_id = rs.getInt("clerk_id");
					 basic_info = rs.getString("basic_info");
					 payment_info = rs.getString("payment_info");
					 
					 r.add(new Receipt(receipt_id, customer_id, clerk_id, basic_info, payment_info));
				 }
			 }
			
		 }else{
			 dbm.disconnect();
			 throw new Error("customer is not registered in the system");
		 }
		 
		 rs.close();
		 stmt.close();
		 dbm.disconnect(); 
		 return r.toArray(new Receipt[r.size()]);
	 }
	 
	 
	 /**
	  * @author saud (sammy) almahri
	  * @param receiptID
	  * @return
	  * @throws SQLException
	  */
	 private boolean isElementAvailable(int elementID, String elementName) throws SQLException{
		 Connection conn;
		 Statement stmt;
		 ResultSet rs;
		 String query;
		 
		 conn = dbm.getConnection();
		 stmt = conn.createStatement();
		 
		 query = "SELECT id_number FROM " + elementName + " WHERE id_number = " + elementID +";";
		 
		 rs = stmt.executeQuery(query);
		 
		 while(rs.next()){
			 if (rs.getInt("id_number") == elementID){ 
				 rs.close();
				 stmt.close();
				 return true;
			 } 
		 }
		 
		 rs.close();
		 stmt.close();
		 return false;
	 }

}
