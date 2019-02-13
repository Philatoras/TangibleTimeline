package tests;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import serveur.CircularZone;
import serveur.Coordinate;
import serveur.Pion;
import serveur.Zone;
import serveur.ZoneEvent;
import serveur.ZoneListener;

public class TestZone {

	public Zone zone;
	
	public ZoneEvent zoneEvent;
	
	public static int valeurTest;
	
	public class ListenerTest implements ZoneListener{

		@Override
		public void zoneEntered(ZoneEvent zoneEvent) {
			valeurTest ++;
			
		}

		@Override
		public void zoneExited(ZoneEvent zoneExited) {
			valeurTest --;
			
		}
		
	}
	
	@Before
	public void setup() {
		valeurTest = 0;
		Coordinate c = new Coordinate(5, 5);
		zone = new CircularZone(c,3f);
		Pion pion = new Pion("Pion", c, new Color(0));
		zoneEvent = new ZoneEvent(pion, 0l, "Source");
	}
	
	@Test
	public void testEntree() {
		zone.doEnterAction(zoneEvent);
		assertEquals(1,valeurTest);
	}
	
	@Test
	public void testSortie() {
		zone.doEnterAction(zoneEvent);
		assertEquals(-1,valeurTest);
	}

}
