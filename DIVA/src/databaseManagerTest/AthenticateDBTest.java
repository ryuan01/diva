package databaseManagerTest;

import java.sql.SQLException;

import databaseManagement.AuthenticateDB;

public class AthenticateDBTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AuthenticateDB ad = new AuthenticateDB();
		
		try {
			System.out.println(ad.getAccountType("Alex"));
			System.out.println(ad.getAccountType("jdoe01"));
			System.out.println(ad.getAccountType("njohnson01"));
			System.out.println(ad.getAccountType("obarnes01"));
			System.out.println(ad.getAccountType("ehunter01"));
			System.out.println(ad.retrievePassword("Alex"));
		} catch (IllegalArgumentException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
