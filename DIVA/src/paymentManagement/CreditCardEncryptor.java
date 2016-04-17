package paymentManagement;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * Used to encrypt and decrypt creditcard numbers
 * @author Alex Daniels
 */
class CreditCardEncryptor {
	
	private String key;
	private String initVector;
	
	CreditCardEncryptor() {
		key = "77A5329714E8E4C5";
		initVector = "5DD78779B2217F45";
	}
	
	/**
	 * Takes in a creditcard and outputs cyphertext
	 * @param cardNumber a creditcard number you would like to encrypt
	 * @return Cyphertext of the given creditcard number
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
    String encrypt(String cardNumber) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
    	
    	//Get the last 4 significant digits of the credit card
    	String lastFourDigits = cardNumber.substring(12);
    	
    	//Specify The Key and InitVector
    	IvParameterSpec iv = new IvParameterSpec(this.initVector.getBytes("UTF-8"));
    	SecretKeySpec skeySpec = new SecretKeySpec(this.key.getBytes("UTF-8"), "AES");

    	//Create an AES cypher with the keyspec and ivspec created previously 
    	Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
    	cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

    	//Encrypt the cardNumber and store in a byte array
    	byte[] encrypted = cipher.doFinal(cardNumber.getBytes());

    	//return a base 64 encoded cyphertext string of the given creditCard number
    	return lastFourDigits + Base64.encodeBase64String(encrypted);
    }

    /**
     * 
     * @param cypherText
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws InvalidAlgorithmParameterException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    String decrypt(String cypherText) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
     
    	//remove the last four digits of the cypher text
    	
    	String cypherTextWithoutFourDigits = cypherText.substring(4);
    	
    	//Set the Initialization Vector and key specifications 
    	IvParameterSpec iv = new IvParameterSpec(this.initVector.getBytes("UTF-8"));
    	SecretKeySpec skeySpec = new SecretKeySpec(this.key.getBytes("UTF-8"), "AES");

    	//Make an AES cypher based on they key and initV specs
    	Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
       	cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

       	//Decrypt the given cypherText
       	byte[] original = cipher.doFinal(Base64.decodeBase64(cypherTextWithoutFourDigits));

       	return new String(original);
    }
}
