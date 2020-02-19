package clusters;

import lecture1.DoubleComparator;

public class Test_Cluster extends junit.framework.TestCase {

	public void test_yuiop1() {
		Cluster c= new Cluster(new Point(1.0f,1.0f));
		c.addPoint(new Point(2.0f,2.0f));
		Point p=new Point(2.0f,2.0f);
		assertTrue(
				DoubleComparator.equal(
					p.distanceFrom( c.getVectorSum() ),
					0.0f,
					0.00001
				)
				);	
	}
	public void test_dgmkg1() {
		Cluster c= new Cluster(new Point(1.0f,1.0f));
		Point p=new Point(2.0f,2.0f);
		float dist=c.getDistanceFrom(p);
		assertTrue(
				DoubleComparator.equal(
					dist,
					2.0f,
					0.00001
				)
				);	
		
	}
	public void test_qwert3() {
		Cluster c= new Cluster(new Point(1.0f,1.0f));
		c.addPoint(new Point(2.0f,2.0f));
		c.reset();
		Point p=new Point(0.0f,0.0f);
		assertTrue(
				DoubleComparator.equal(
					p.distanceFrom( c.getVectorSum() ),
					0.0f,
					0.00001
				)
				);	
		
	}	
}
