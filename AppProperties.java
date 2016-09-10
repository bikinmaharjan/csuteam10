/**
 * @author Bishal Sapkota (sapkotabishal10)
 * AppProperties
 * Edits: All the required comments are added and made the code presentable
 */
package datamanagement; //The class AppProperties is inside the package data management

import java.util.*; //importing all the classes from the util package
import java.io.*; //importing all the classes from the input-output package

public class AppProperties {
	// private data types are created to store specific data
	private static AppProperties self = null; // declaring a private class
												// variable and assigning it to
												// null
	private Properties properties; // declaring a private variable

	// Class method is created to take input from parameter, perform action and
	// give a reuslt
	public static AppProperties getInstance() { // factory method use for
												// singleton class creation
		if (self == null) {
			self = new AppProperties();
		}
		return self;
	}

	// Class method is created for IOexception
	private AppProperties() {
		properties = new Properties();
		try {
			properties.load(new FileInputStream("Properties.prop"));
		} catch (IOException e) {
			throw new RuntimeException("Could not read property file");
		}
	} // For catching any error using exception for handling it

	public Properties getProperties() {
		return properties; // returns properties
	}

}