package phpTravels;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Booking extends TestCase {
	public Booking(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(Booking.class);
	}

	public void testApp() {
		assertTrue(true);
	}
}
