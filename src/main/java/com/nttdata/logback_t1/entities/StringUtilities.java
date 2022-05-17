package com.nttdata.logback_t1.entities;

/**
 * @author Fernando Pérez Nieto - Utility class
 *
 */
public class StringUtilities {

	/**
	 * @param args
	 * 
	 * Concat any number of Strings with an StringBuilder
	 * 
	 * @return String
	 */
	public static String toStrBuilder(final String... args) {

		StringBuilder strb = new StringBuilder();
		for (String str : args) {
			strb.append(str);
		}
		return strb.toString();
	}

	
	/**
	 * Print a separator for console output
	 */
	public static void printSeparator() {
		System.out.println("\n=======================================================\n");
	}

	/**
	 * Empty constructor to report that it's an utility class
	 */
	private StringUtilities() {
		throw new IllegalStateException("Utility class");
	}
}
