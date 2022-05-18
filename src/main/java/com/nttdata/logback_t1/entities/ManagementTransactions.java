package com.nttdata.logback_t1.entities;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Fernando Pérez Nieto
 *
 */
public class ManagementTransactions {

	/** LOGGER */
	private static final Logger LOG = LoggerFactory.getLogger(ManagementTransactions.class);
	Scanner sc = new Scanner(System.in);

	/**
	 * @param client
	 * 
	 * Launcher for the ManagementTransaction module
	 * 
	 */
	public static void launch(Client client) {

		LOG.info("TRACE INIT");

		if (client.isAdult()) {
			int option;

			do {
				showMenu();
				option = ask4Number(0, 9, ConstantsTransactions.OPTION_MSG);
				switch (option) {
				case 1:// Opcion
					StringUtilities.printSeparator();
					addMoney(client);
					StringUtilities.printSeparator();
					break;
				case 2:
					StringUtilities.printSeparator();
					drawMoney(client);
					StringUtilities.printSeparator();
					break;
				case 3:
					StringUtilities.printSeparator();
					showBalance(client);
					StringUtilities.printSeparator();
					break;
				case 9:// Exit Option
					StringUtilities.printSeparator();
					System.out.println(ConstantsTransactions.EXIT_MSG);
					StringUtilities.printSeparator();
					break;
				default:// Otra opcion error
					StringUtilities.printSeparator();
					System.out.println(ConstantsTransactions.ERROR_OPTION_MSG);
					LOG.debug("Out of range value");
					StringUtilities.printSeparator();
					break;
				}
				LOG.debug(String.valueOf(option));
			} while (option != 9);
		} else {
			System.out.println(ConstantsTransactions.AGE_ERROR);
			LOG.warn(StringUtilities.toStrBuilder("Client birthday - ", client.getbDay().toString()));
		}

		LOG.info("TRACE END");

	}

	/**
	 * Show the options from the app menu
	 */
	private static void showMenu() { // Show menu options

		LOG.info("TRACE INIT");

		System.out.println("Menu:\n");
		System.out.println("1. Add money");
		System.out.println("2. Draw money");
		System.out.println("3. Show Wallet");
		System.out.println("9. Exit \n");

		LOG.info("TRACE END");

	}

	/**
	 * @param question
	 * 
	 * Ask for a particular boolean option between [Y] or [N]
	 * 
	 * @return boolean
	 */
	private static boolean askYesNo(String question) {

		LOG.info("TRACE INIT");
		boolean option = askBooleanOption(question, "[Y]", "[N]");
		LOG.info("TRACE END");
		return option;
	}

	/**
	 * @param question
	 * @param positive
	 * @param negative
	 * 
	 * Ask for one of two options (option positive, option negative)
	 * 
	 * @return boolean
	 */
	@SuppressWarnings("resource")
	private static boolean askBooleanOption(String question, String positive, String negative) {

		LOG.info("TRACE INIT");

		Scanner input = new Scanner(System.in);
		// Convert everything to upper case for simplicity...
		positive = positive.toUpperCase();
		negative = negative.toUpperCase();
		String answer;
		do {
			System.out.println(question);
			answer = input.next().trim().toUpperCase();
		} while (!answer.matches(positive) && !answer.matches(negative));
		// Assess if we match a positive response

		LOG.info("TRACE END");
		return answer.matches(positive);
	}

	/**
	 * @param start
	 * @param end
	 * @param message
	 * 
	 * Ask for a int between two values
	 * 
	 * @return
	 */
	@SuppressWarnings("resource")
	private static int ask4Number(int start, int end, String message) {

		LOG.info("TRACE INIT");

		int number = 0;
		Scanner sc;
		sc = new Scanner(System.in);
		do {
			try {
				String msj = StringUtilities.toStrBuilder(message, "Introduce a number between ", String.valueOf(start),
						" and ", String.valueOf(end), ": ");
				System.out.println(msj);
				number = sc.nextInt();
			} catch (InputMismatchException | NumberFormatException ex) {
				LOG.error(StringUtilities.toStrBuilder("Error cause by ",String.valueOf(ex)));
				System.out.println(ConstantsTransactions.INPUT_MISMATCH_ERROR);
				sc.next();
			}
		} while (number < start || number > end);

		LOG.info("TRACE END");
		return number;
	}

	/**
	 * @param start
	 * @param end
	 * 
	 * Ask for a double between two values
	 * 
	 * @return double
	 */
	@SuppressWarnings("resource")
	private static double ask4Number(double start, double end) {

		LOG.info("TRACE INIT");

		double number = 0.00;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				String msj = StringUtilities.toStrBuilder("Introduce an amount between ",
						String.format("%,.2f", start), "€ and ", String.format("%,.2f",  end), "€:\n");
				System.out.println(msj);
				number = sc.nextDouble();

			} catch (InputMismatchException ime) {
				LOG.error(StringUtilities.toStrBuilder("Error cause by ",String.valueOf(ime)));
				System.out.println(ConstantsTransactions.INPUT_MISMATCH_ERROR);
				sc.next();
			}
		} while (number < start || number > end);

		LOG.info("TRACE END");
		return number;
	}

	/**
	 * Add an amount of money to the client's balance
	 * @param client
	 */
	private static void addMoney(Client client) {

		LOG.info("TRACE INIT");

		System.out.println(ConstantsTransactions.ADD_MONEY_MSG);
		double amount = ask4Number(1.00, 600.00);
		if (askYesNo(ConstantsTransactions.SECURITY_MSG)) {// Confirmation message
			double balance = client.getBalance();
			balance += amount;
			client.setBalance(balance);
		}
		showBalance(client);

		LOG.info("TRACE END");
	}

	/**
	 * Draw an amount of money from the client's balance
	 * @param client
	 */
	private static void drawMoney(Client client) {

		LOG.info("TRACE INIT");

		if (client.getBalance() > 1.00) {
			System.out.println(ConstantsTransactions.DRAW_MONEY_MSG);
			double amount = ask4Number(1.00, client.getBalance());
			if (askYesNo(ConstantsTransactions.SECURITY_MSG)) {// Confirmation message
				double balance = client.getBalance();
				balance -= amount;
				client.setBalance(balance);
			}
			showBalance(client);
		} else {
			System.out.println(ConstantsTransactions.DRAW_MONEY_ERROR);
			LOG.error("Error caused by user trying to draw money with their balance lower than 1.00");
		}

		LOG.info("TRACE END");
	}

	/**
	 * Show the client's balance
	 * @param client
	 */
	private static void showBalance(Client client) {

		LOG.info("TRACE INIT");

		String msj = StringUtilities.toStrBuilder("Your current balance is ",
				String.format("%,.2f", client.getBalance()), "€");
		System.out.println(msj);

		LOG.info("TRACE END");
	}
}
