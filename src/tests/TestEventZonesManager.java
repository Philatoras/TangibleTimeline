package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import serveur.Coordinate;
import serveur.Zone;
import serveur.ZoneManager;

public class TestEventZonesManager {
	
	private class FakeEventZone extends Zone{

		public FakeEventZone(String id) {
			super(id);
		}

		@Override
		public boolean PointOnZone(Coordinate c) {
			return c.getC_x() > 0 && c.getC_x() < 5 
					&& c.getC_y() > 5 && c.getC_y() < 14;
		}
		
	}
	
	private static int valeurDeTest; 

	ZoneManager ezm;
	
	@Before
	public void setup() {
		//TODO
	}
	
	@Test
	public void testManagerVide() {
		//TODO
	}
	
	@Test
	public void testCheckTriggerMauvaiseCoordonne() {
		//TODO
	}
	
	@Test
	public void testCheckTriggeMauvaisMessage() {
		//TODO
	}
	
	@Test
	public void testCheckTriggerReussite() {
		//TODO
	}

}
