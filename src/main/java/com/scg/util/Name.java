package com.scg.util;

/**
 * Provides first name, middle name, and last name of a person.
 * @author Jesse Franceschini
 *
 */
public final class Name {
	
	/** Constant for default first name */
	public final static String NFN = "";
	/** Constant for default middle name */
	public final static String NMN = "";
	/** Constant for default last name */
	public final static String NLN = "";
	
	/** String of the first name */
	private String firstName;
	/** String of the last name */
	private String lastName;
	/** String of the middle name */
	private String middleName;

	/**
	 * Creates an instance of a Name.
	 */
	public Name() { 
		this(NFN, NMN, NLN);
	}
	
	/** 
	 * Creates an instance of a Name.
	 * @param lastName a String of the last name
	 * @param firstName a String of the first name
	 */
	public Name(String lastName, String firstName) {
		this(lastName, firstName, NMN);
	}
	
	/**
	 * Creates an instance of a Name.
	 * @param lastName a String of the last name
	 * @param firstName a String of the first name
	 * @param middleName a String of the middle name
	 */
	public Name(String lastName, String firstName, String middleName) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleName = middleName;
	}
	
	/**
	 * Getter for the first name
	 * @return a String of the first name
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	/**
	 * Setter for property first name
	 * 
	 * @param firstName String of new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Getter for the last name
	 * @return a String of the last name
	 */
	public String getLastName() {
		return this.lastName;
	}
	
	/**
	 * Setter for last name
	 * @param lastName String of the last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Getter for middle name
	 * @return String of the middle name
	 */
	public String getMiddleName() {
		return this.middleName;
	}
	
	/**
	 * Setter for middle name
	 * @param middleName String of middle name
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Name other = (Name) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%s, %s %s", this.lastName, this.firstName, this.middleName);
	}
}
