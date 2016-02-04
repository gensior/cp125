package com.scg.domain;

public interface Account {
	
	/**
	 * Getter for the account name
	 * @return a String of the account name
	 */
	public String getName();
	
	/**
	 * Checks if the account is billable
	 * @return boolean of true if the account is billable, false if it is not
	 */
	public boolean isBillable();

}
