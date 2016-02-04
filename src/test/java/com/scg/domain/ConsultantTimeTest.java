package com.scg.domain;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.scg.util.Name;

public class ConsultantTimeTest {

	private static Calendar calendar;
	private static Date now;
	private static ClientAccount clientAccount;
	private static ConsultantTime consultantTime;

	@Before
	public void setUp() throws Exception {
		this.calendar = new GregorianCalendar();
		this.now = this.calendar.getTime();
		this.clientAccount = new ClientAccount("TestClient", new Name("Foo", "Bar"));
		this.consultantTime = new ConsultantTime(now, clientAccount, Skill.SOFTWARE_ENGINEER, 200);
	}

	@After
	public void tearDown() throws Exception {
		this.clientAccount = null;
		this.consultantTime = null;
	}

	@Test
	public void testSetHours() throws Exception {
		// tests if the hours cannot be negative
		try {
			this.consultantTime.setHours(-1);
			fail("IllegalArgumentException should have been thrown");
		} catch (IllegalArgumentException e) {
			assertTrue("Negative hours test passes", true);
		}
	}

}
