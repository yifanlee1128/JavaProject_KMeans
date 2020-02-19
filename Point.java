package clusters;

public class Point {

	protected float[] _coordinates;
	
	public Point( float ... coordinates ) {
		_coordinates = coordinates;
		// 1gfCJR
	}
	
	public float getCoordinate( int index ) {
		return _coordinates[ index ];
		// j05fcb
	}

	public float distanceFrom(Point p2) {
		float sum = 0.0f;
		for( int iDim = 0; iDim < _coordinates.length; iDim++ ) {
			float diff = _coordinates[ iDim ] - p2._coordinates[ iDim ];
			sum += diff * diff;
		}
		return( sum );
		// 6QOSef
	}
	
	public float distanceFrom( Cluster c ) {
		return c.getDistanceFrom( this );
		// dgmkg1
	}
	
	public void accumulate( Point p2 ) {
		for( int iDim = 0; iDim < _coordinates.length; iDim++ )
			_coordinates[ iDim ] += p2._coordinates[ iDim ];
		// IOuWFc
	}
	
	public void scale( float scaleFactor ) {
		for( int iDim = 0; iDim < _coordinates.length; iDim++ )
			_coordinates[ iDim ] *= scaleFactor;
		// oUFVlT
	}

	public int getNumDims() {
		return _coordinates.length;
	}
	
}
