package clusters;

import java.util.LinkedList;

public class Cluster {
	
	protected Point _centroid;
	protected LinkedList<Point> _points;
	protected Point _vectorSum;
	
	public Cluster( Point centroid ) {
		_centroid = centroid;
		reset();
		// dgmkg1
	}
	
	protected void reset() {
		_points = new LinkedList<Point>();
		float[] f = new float[ _centroid.getNumDims() ];
		_vectorSum = new Point( f );
		//qwert3
	}

	public float getDistanceFrom(Point point) {
		return _centroid.distanceFrom( point );
		// dgmkg1
	}
	
	public void addPoint( Point point ) {
		_vectorSum.accumulate( point );
		_points.addLast( point );
		//yuiop1
	}
	
	public void recomputeCentroid() {
		_vectorSum.scale( 1.0f / _points.size() );
		_centroid = _vectorSum;
		reset();
	}
	public Point getVectorSum() {
		return _vectorSum;
	}
	

}
