package com.nttdata.logback_t1.entities;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Maydo
 *
 */
public class Client {
	
	private static int counter;
	private double balance;
	private int idClient;
	private String name;
	private String surname;
	private LocalDate bDay;
	
	/**
	 * Constructor for the Client class
	 * @param name
	 * @param surname
	 * @param bDay
	 */
	public Client(String name, String surname, LocalDate bDay) {
		
		this.balance = 0;
		this.idClient = counter++;
		this.name = name;
		this.surname = surname;
		this.bDay = bDay;
	}
	
	/**
	 * Empty constructor for the Client class
	 */
	public Client() {
		
		this.idClient = counter++;
	}

	/**
	 * @return balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Set balance
	 * @param balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Set surname
	 * @param surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return bDay
	 */
	public LocalDate getbDay() {
		return bDay;
	}

	/**
	 * Set bDay
	 * @param bDay
	 */
	public void setbDay(LocalDate bDay) {
		this.bDay = bDay;
	}

	/**
	 * @return idClient
	 */
	public int getIdClient() {
		return idClient;
	}

	/**
	 *	Show the Client's attibutes
	 */
	@Override
	public String toString() {
		return "Client [balance=" + balance + ", idClient=" + idClient + ", name=" + name + ", surname=" + surname
				+ ", bDay=" + bDay + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idClient);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return idClient == other.idClient;
	}
	
	/**
	 * Ask if he's of legal age
	 * 
	 * @return boolean
	 */
	public boolean isAdult() {
		LocalDate today = LocalDate.now();
		return (today.getYear() - bDay.getYear()) > 18;
	}
}
