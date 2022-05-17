package com.nttdata.logback_t1.entities;

/**
 * @author Fernando Pérez Nieto
 *
 */
public final class ConstantsTransactions {

	/** TRANSACTIONS MSG CONSTANT */
	public static final String AGE_ERROR = "You need to be over 18 years old to use this app";
	public static final String OPTION_MSG = "Select one option. ";
	public static final String ERROR_OPTION_MSG = "This option doesn't exists. Please select another one instead";
	public static final String EXIT_MSG = "Thanks for using this software";
	public static final String SECURITY_MSG = "Are you sure about that? (Y/N)";
	public static final String ADD_MONEY_MSG = "What's amount want to introduce?";
	public static final String DRAW_MONEY_MSG = "What's amount want to draw?";
	public static final String DRAW_MONEY_ERROR = "You need to have a minimum amount in your balance to draw";
	public static final String INPUT_MISMATCH_ERROR = "Introduce a number instead of character please";

	/**
	 * Empty constructor to report that it's an utility class
	 */
	private ConstantsTransactions() {
		throw new IllegalStateException("Utility class");
	}

}
