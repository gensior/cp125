package com.scg.domain;

import com.scg.util.Name;

public final class ClientAccount implements Account {

	/** String of the client name */
	private String name;
	/** Name of the client contact */
	private Name contact;
	
	/**
	 * Creates a ClientAccount instance
	 * @param name a String of the client name
	 * @param contact a Name of the client contact
	 */
	public ClientAccount(final String name, final Name contact) {
		this.name = name;
		this.contact = contact;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	/**
	 * Getter for the property contact
	 * @return a Name of the contact
	 */
	public Name getContact() {
		return this.contact;
	}
	
	/**
	 * Setter for property contact
	 * 
	 * @param contact a Name of the contact
	 */
	public void setContact(final Name contact) {
		this.contact = contact;
	}

	/**
	 * Determines if the account is billable.
	 * 
	 * @return true
	 */
	@Override
	public boolean isBillable() {
		return true;
	}

}
