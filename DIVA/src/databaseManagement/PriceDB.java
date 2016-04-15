package databaseManagement;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import paymentManagement.Receipt;
import vehicleManagement.Truck;
import vehicleManagement.Vehicle;

/**
 * Connect to Database to provide services related to PriceList
 * row order of car:
 * row order of truck:
 * 
 * @author Robin
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
	
	
	private ConnectDB dbm;
	
	PriceDB(){
		dbm = new ConnectDB();
	}

	
	BigDecimal[][] getCarPriceList() throws SQLException {
		// TODO Auto-generated method stub
  		BigDecimal[][] prices = new BigDecimal[NUMBER_CAR_TYPE][NUMBER_RENTAL_PRICE_TYPE];
  		
  		dbm.connect();
        String query = "SELECT `perHour`, `perDay`, `perWeek`, `perMonth`, `perKM` FROM `car_price`";
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

	BigDecimal[][] getTruckPriceList() throws SQLException {
		// TODO Auto-generated method stub
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

	BigDecimal[][] getEquipmentPriceList() throws SQLException {
		// TODO Auto-generated method stub
  		BigDecimal[][] prices = new BigDecimal[NUMBER_EQ_TYPE][NUMBER_INSURANCE_PRICE_TYPE];
  		
  		dbm.connect();
        String query = "SELECT `perHour`, `perDay`, `perWeek` FROM `equipment_price`";
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

	BigDecimal[][] getCarInsurancePriceList() throws SQLException {
		// TODO Auto-generated method stub
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

	BigDecimal[][] getTruckInsurancePriceList() throws SQLException {
		// TODO Auto-generated method stub
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
			// TODO Auto-generated method stub
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
	  * @author saud (sammy) almahri
	  * @param receipt
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
			 throw new Error("customer is registered in the system");
			 }
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
