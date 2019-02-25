package tests;



import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import serveur.Coordinate;

public class TestCoordinate {

	private Coordinate coordinate;
	
	@Before
	public void setUp() {
		coordinate = new Coordinate(2, 5);
	}
	
	@Test
	public void testGetX() {
		assertEquals(2,coordinate.getC_x());
	}

	
	@Test
	public void testGetY() {
		assertEquals(5,coordinate.getC_y());
	}
	
	@Test
	public void testSetX() {
		coordinate.setC_x(21);
		assertEquals(21,coordinate.getC_x());
	}

	
	@Test
	public void testSetY() {
		coordinate.setC_y(14);
		assertEquals(14,coordinate.getC_y());
	}

}
