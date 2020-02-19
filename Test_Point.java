package clusters;

import lecture1.DoubleComparator;

public class Test_Point extends junit.framework.TestCase {

	public void test_1gfCJR() {
		Point p = new Point( 100f, 200f );
		// j05fcb
		assertTrue( DoubleComparator.equal( p.getCoordinate( 0 ), 100f, 0.00001 ) );
		assertTrue( DoubleComparator.equal( p.getCoordinate( 1 ), 200f, 0.00001 ) );
	}
	
	public void test_6QOSef() {
		Point p1 = new Point( 1.0f, 2.0f );
		Point p2 = new Point( 2.0f, 4.0f );
		assertTrue(
			DoubleComparator.equal(
				p1.distanceFrom( p2 ),
				5.0f,
				0.00001
			)
		);
	}
	
	public void test_dgmkg1() {
		Point p1 = new Point( 1.0f, 2.0f );
		Cluster c = new Cluster( new Point( 2.0f, 4.0f ) );
		assertTrue(
			DoubleComparator.equal(
				p1.distanceFrom( c ),
				5.0f,
				0.00001
			)
		);
	}
	
	public void test_IOuWFc() {
		Point p1 = new Point( 1.0f, 2.0f );
		Point p2 = new Point( 2.0f, 4.0f );
		p1.accumulate( p2 );
		assertTrue(
			DoubleComparator.equal(
				p1.getCoordinate(0),
				3.0f,
				0.00001
			)
		);
		assertTrue(
			DoubleComparator.equal(
				p1.getCoordinate(1),
				6.0f,
				0.00001
			)
		);
	}
	
	public void test_oUFVlT() {
		Point p1 = new Point( 1.0f, 2.0f );
		Point p2 = new Point( 2.0f, 4.0f );
		p1.accumulate( p2 );
		p1.scale( 0.5f );
		assertTrue(
			DoubleComparator.equal(
				p1.getCoordinate(0),
				1.5f,
				0.00001
			)
		);
		assertTrue(
			DoubleComparator.equal(
				p1.getCoordinate(1),
				3.0f,
				0.00001
			)
		);
	}
	
}
