package com.scg.domain;

import java.io.Serializable;

public enum Skill implements Serializable, Comparable<Skill> {
	PROJECT_MANAGER("Project Manager skill", 250),
	SOFTWARE_ENGINEER("Engineer skill", 200),
	SOFTWARE_TESTER("Tester skill", 150),
	SYSTEM_ARCHITECT("Architect skill", 100),
	UNKNOWN_SKILL("Unknown skill", 0);
	
	/** Holds the value of property name. */
	private final String friendlyName;
	private final int rate;
	
	private Skill(final String name, final int rate) {
		this.friendlyName = name;
		this.rate = rate;
	}
	
	public int getRate() {
		return this.rate;
	}
	
	public String toString() {
		return this.friendlyName;
	}
}
