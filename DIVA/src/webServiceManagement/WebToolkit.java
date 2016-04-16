package webServiceManagement;

/**
 * This class provides tools for many different aspects of handling post mothod
 * invokation and pre response tasks such as data marshalling, formatting and
 * other routines that are common to more than one WebService Endpoint
 * @author Alex Daniels
 */
 class WebToolkit {
	
	String[] toArrayOfStrings(ArrayOfStringsable[] objectArray) {
		
		String[] stringArray = new String[objectArray.length];
		
		for (int i = 0; i < objectArray.length; i++) {
			String currentString = objectArray[i].toString();
			stringArray[i] = currentString;
		}
		
		return stringArray;
	}
	
	
}