package com.scg.domain;

public enum NonBillableAccount implements Account {

	SICK_LEAVE("Sick Leave"),
	VACATION("Vacation"),
	BUSINESS_DEVELOPMENT("Business Development");
	
	private final String friendlyName;
	
	private NonBillableAccount(final String friendlyName) {
		this.friendlyName = friendlyName;
	}

	@Override
	public String getName() {
		return this.friendlyName;
	}

	@Override
	public boolean isBillable() {
		return false;
	}
	
	public String toString() {
		return this.friendlyName;
	}
}
