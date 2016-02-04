package com.scg.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

public final class TimeCard {

	private static final String HEADER_FORMAT = "Consultant: %-29s Week Starting: %2$tb %2$td,%2$tY%n";
	private static final String TO_STRING_FORMAT = "TimeCard for: %s, Week Starting: %2$tb %2$td,%2$tY%n";
	private static final String LINE_HEADER_FORMAT = String.format("%-28s %-10s  %5s  %s%n"
		+ "---------------------------  ----------  ----- ---------------------%n",
		"Account", "Date", "Hours", "Skill");
	private static final String CARD_BORDER = "====================================================================%n";
	private static final String LINE_FORMAT = "%-28s %2$tm/%2$td/%2$tY  %3$5d  %4$s%n";
	private static final String SUMMARY_LINE_FORMAT = "%-39s  %5d%n";
	private static final String BILLABLE_TIME_HEADER_FORMAT = "%nBillable Time:%n";
	private static final String NON_BILLABLE_TIME_HEADER_FORMAT = "%nNon-billable Time:%n";
	private static final String SUMMARY_HEADER_FORMAT = "%nSummary:%n";
	
	private final Date weekStartingDay;
	private final Consultant consultant;
	private int totalBillableHours;
	private int totalNonBillableHours;
	private List<ConsultantTime> consultingHours;
	
	/**
	 * Returns a TimeCard instance
	 * @param consultant a Consultant of the consultant
	 * @param weekStartingDay a Date of the weekStartingDay
	 */
	public TimeCard(Consultant consultant, Date weekStartingDay) {
		this.consultant = consultant;
		this.weekStartingDay = new Date(weekStartingDay.getTime());
		this.totalBillableHours = 0;
		this.consultingHours = new ArrayList<ConsultantTime>();
	}
	
	public Consultant getConsultant() {
		return this.consultant;
	}
	
	public int getTotalBillableHours() {
		return this.totalBillableHours;
	}
	
	/**
	 * Adds ConsultantTime object to the TimeCard
	 * @param consultantTime a ConsultantTime of consultantTime
	 */
	public void addConsultantTime(final ConsultantTime consultantTime) {
		consultingHours.add(consultantTime);
		final int addedHours = consultantTime.getHours();
		if (consultantTime.isBillable()) {
			totalBillableHours += addedHours;
		} else {
			totalNonBillableHours += addedHours;
		}
	}
	
	public int getTotalHours() {
		return totalBillableHours + totalNonBillableHours;
	}
	
	public Date getWeekStartingDay() {
		return new Date(weekStartingDay.getTime());
	}
	
	/**
	 * Gets billable hours in TimeCard
	 * @param clientName a String of the client name
	 * @return a List of ConsultantTime for the given client name
	 */
	public List<ConsultantTime> getBillableHoursForClient(final String clientName) {
		final ArrayList<ConsultantTime> billableConsultingHours = new ArrayList<ConsultantTime>();
		for (final ConsultantTime currentTime : consultingHours) {
			if (clientName.equals(currentTime.getAccount().getName())) {
				if (currentTime.isBillable()) {
					billableConsultingHours.add(currentTime);
				}
			}
		}
		return billableConsultingHours;
	}
	
	public List<ConsultantTime> getConsultingHours() {
		return Collections.unmodifiableList(this.consultingHours);
	}
	
	private void appendTime(final Formatter formatter, final List<ConsultantTime> hours, final boolean billable) {
		for (final ConsultantTime currentTime : hours ) {
			if (currentTime.isBillable() == billable) {
				formatter.format(LINE_FORMAT, currentTime.getAccount().getName(),
						currentTime.getDate(),
						currentTime.getHours(),
						currentTime.getSkill());
			}
		}
	}
	
	public String toReportString() {
		final StringBuilder sb = new StringBuilder();
		final Formatter formatter = new Formatter(sb, Locale.US);
		formatter.format(CARD_BORDER)
				 .format(HEADER_FORMAT, consultant.getName(), weekStartingDay)
				 .format(BILLABLE_TIME_HEADER_FORMAT)
				 .format(LINE_HEADER_FORMAT);
		
		appendTime(formatter, consultingHours, true);
		
		formatter.format(NON_BILLABLE_TIME_HEADER_FORMAT)
				 .format(LINE_HEADER_FORMAT);
		
		appendTime(formatter, consultingHours, false);
		
		formatter.format(SUMMARY_HEADER_FORMAT)
				 .format(SUMMARY_LINE_FORMAT, "Total Billable:", totalBillableHours)
				 .format(SUMMARY_LINE_FORMAT, "Total Non-Billable:", totalNonBillableHours)
				 .format(SUMMARY_LINE_FORMAT, "Total Hours:", totalBillableHours + totalNonBillableHours)
				 .format(CARD_BORDER);
		
		final String s = formatter.toString();
		formatter.close();
		return s;
	}

	@Override
	public String toString() {
		return String.format(TO_STRING_FORMAT,  consultant.getName(), weekStartingDay);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((consultant == null) ? 0 : consultant.hashCode());
		result = prime * result + ((consultingHours == null) ? 0 : consultingHours.hashCode());
		result = prime * result + totalBillableHours;
		result = prime * result + totalNonBillableHours;
		result = prime * result + ((weekStartingDay == null) ? 0 : weekStartingDay.hashCode());
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
		TimeCard other = (TimeCard) obj;
		if (consultant == null) {
			if (other.consultant != null)
				return false;
		} else if (!consultant.equals(other.consultant))
			return false;
		if (consultingHours == null) {
			if (other.consultingHours != null)
				return false;
		} else if (!consultingHours.equals(other.consultingHours))
			return false;
		if (totalBillableHours != other.totalBillableHours)
			return false;
		if (totalNonBillableHours != other.totalNonBillableHours)
			return false;
		if (weekStartingDay == null) {
			if (other.weekStartingDay != null)
				return false;
		} else if (!weekStartingDay.equals(other.weekStartingDay))
			return false;
		return true;
	}
}
