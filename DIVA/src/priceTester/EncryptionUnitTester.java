package priceTester;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import paymentManagement.CreditCardEncryptor;

/**
 * Creates a CreditCardEncryptor, Encrypts a string and decrypts the string
 * @author Alex Daniels
 */
public class EncryptionUnitTester {

	public static void main(String[] args) throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		
		CreditCardEncryptor x = new CreditCardEncryptor();
		
		String cardNumber = "1234567890123456";
	
		String cypherText = x.encrypt(cardNumber);
	
		System.out.println("Plaintext: " + cardNumber);
		System.out.println("Cypher: " + cypherText);
		System.out.println("Second Plaintext: " + x.decrypt(cypherText));
	}
}
