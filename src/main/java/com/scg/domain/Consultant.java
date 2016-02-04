package com.scg.domain;

import com.scg.util.Name;

public class Consultant {

	/** A name of the consultant name */
	private final Name name;
	
	/**
	 * Creates a Consultant instance
	 * @param name a Name of the consultant name
	 */
	public Consultant(final Name name) {
		this.name = name;
	}
	
	/**
	 * Getter for the name property
	 * @return a Name of the name
	 */
	public final Name getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return this.name.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Consultant other = (Consultant) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
