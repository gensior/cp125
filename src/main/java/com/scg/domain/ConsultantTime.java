package com.scg.domain;

import java.util.Date;

public final class ConsultantTime {

	/** A Date of the date */
	private Date date;
	/** An Account of the account */
	private Account account;
	/** An int of the hours */
	private int hours;
	/** A Skill of the skill */
	private final Skill skill;
	
	/**
	 * Creates a ConsultantTime instance
	 * @param date a Date of the date
	 * @param account an Account of the account
	 * @param skillType a Skill of the skilltype
	 * @param hours an int of the hours
	 */
	public ConsultantTime(final Date date, final Account account, final Skill skillType, final int hours) {
		setHours(hours);
		this.date = new Date(date.getTime());
		this.account = account;
		this.skill = skillType;
	}
	
	/**
	 * Getter for the date property
	 * @return a Date of the date
	 */
	public Date getDate() {
		return (date == null) ? (Date)null : new Date(date.getTime());
	}
	
	/**
	 * Setter for the date property
	 * @param date a Date of the new date
	 */
	public void setDate(final Date date) {
		this.date = (date != null) ? (new Date(date.getTime())) : (Date)null;
	}
	
	/** 
	 * Getter for the account property
	 * @return an Account of the account
	 */
	public Account getAccount() {
		return this.account;
	}
	
	/**
	 * Setter for the account property
	 * @param account an Account of the new account
	 */
	public void setAccount(final Account account) {
		this.account = account;
	}
	
	/**
	 * Getter for the skill property
	 * @return a Skill of the skill
	 */
	public Skill getSkill() {
		return this.skill;
	}
	
	public boolean isBillable() {
		return this.account.isBillable();
	}
	
	/**
	 * Getter for the hours property
	 * @return an int of the hours
	 */
	public int getHours() {
		return this.hours;
	}
	
	/**
	 * Setter for the hours property
	 * @param hours an int of the hours
	 * 
	 * @throws IllegalArgumentException if the hours param is not greater than zero
	 */
	public void setHours(final int hours) {
		if (hours > 0) {
			this.hours = hours;
		} else {
			throw new IllegalArgumentException("Hours must be a positive integer.");
		}
	}
	
	@Override
	public String toString() {
		return String.format("%-28s %2$tm/%2$td/%2$tY %3$5d %4$s%n", 
			account.getName(), date, hours, skill);
	}
}
