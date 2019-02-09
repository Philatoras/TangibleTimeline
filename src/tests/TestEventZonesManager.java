package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import serveur.Coordinate;
import serveur.EventZone;
import serveur.EventZonesManager;

public class TestEventZonesManager {
	
	private class FakeEventZone implements EventZone{

		@Override
		public boolean PointOnZone(Coordinate c) {
			return c.getC_x() > 0 && c.getC_x() < 5 
					&& c.getC_y() > 5 && c.getC_y() < 14;
		}

		@Override
		public void doAction(Object... params) {
			String s = (String)params[0];
			if (s.equals("OK")) {
				TestEventZonesManager.valeurDeTest = 1;
			}
		}
		
	}
	
	private static int valeurDeTest; 

	EventZonesManager ezm;
	
	@Before
	public void setup() {
		valeurDeTest = 0;
		ezm = new EventZonesManager();
	}
	
	@Test
	public void testManagerVide() {
		Coordinate c = new Coordinate(5,5);
		ezm.checkEventTrigger(c);
		assertEquals(0,valeurDeTest);
	}
	
	@Test
	public void testCheckTriggerMauvaiseCoordonne() {
		Coordinate c = new Coordinate(5,5);
		ezm.addZone(new FakeEventZone());
		ezm.checkEventTrigger(c,"OK");
		assertEquals(0,valeurDeTest);
	}
	
	@Test
	public void testCheckTriggeMauvaisMessage() {
		Coordinate c = new Coordinate(3,8);
		ezm.addZone(new FakeEventZone());
		ezm.checkEventTrigger(c,"KO");
		assertEquals(0,valeurDeTest);
	}
	
	@Test
	public void testCheckTriggerReussite() {
		Coordinate c = new Coordinate(3,8);
		ezm.addZone(new FakeEventZone());
		ezm.checkEventTrigger(c,"OK");
		assertEquals(1,valeurDeTest);
	}

}
