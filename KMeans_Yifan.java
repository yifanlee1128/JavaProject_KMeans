package clusters;

import java.util.Random;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Iterator;

public class KMeans_Yifan {
	
	public static Random rand = new Random();
	
	/** Compute distance between two points */

	
	/**  initialization - randomly sample from points to create indices */
	public static LinkedList<Cluster> getInitialClusters( LinkedList<Point> points, int numClusters ) {
		LinkedList<Cluster> clusters= new LinkedList<Cluster>();
		for( int i = 0; i < numClusters; i++ ) {
			int index = (int)( rand.nextDouble() * points.size() );
			clusters.addLast(new Cluster(points.get(index)));;
		}
		return clusters;
	}
	
	/** Initialize x by y space - Problem specific */
	public static LinkedList<Point> getInitialPoints( int xSize, int ySize ) {
		LinkedList<Point> points = new LinkedList<Point>();
		for( int x = 0; x < xSize; x++ ) {
			for( int y = 0; y < ySize; y++ ) {
				points.addLast(new Point(x,y));
			}
		}
		return points;
	}
	
	/** For each point, find the index of the cluster to which it belongs */
	public static LinkedList<Cluster> computeClusterIndices( LinkedList<Point> points, LinkedList<Cluster> oldclusters ) {
		Iterator<Point> pointIterator = points.iterator();
		float tempDistance;
		int index;
		LinkedList<Cluster> newclusters=new LinkedList<Cluster>();
		Iterator<Cluster> clusterIterator1=oldclusters.iterator();
		while(clusterIterator1.hasNext()){
			Cluster c= clusterIterator1.next();
			Cluster newC=new Cluster(new Point(Arrays.copyOf(c._centroid._coordinates, 2)));
			newC._points=(LinkedList<Point>)c._points.clone();
			newC._vectorSum=new Point(Arrays.copyOf(c._vectorSum._coordinates, 2));
			newclusters.addLast(newC);
		}
		
		while( pointIterator.hasNext() ) {
			Point point = pointIterator.next();
			Iterator<Cluster> clusterIterator=newclusters.iterator();
			tempDistance=10000000.0f;index=0;
			while(clusterIterator.hasNext()) {
				Cluster cluster=clusterIterator.next();
				if(point.distanceFrom(cluster)<tempDistance) {
					tempDistance=point.distanceFrom(cluster);
					index=newclusters.indexOf(cluster);
					}
			}	
			newclusters.get(index).addPoint(point);
		}
		
		Iterator<Cluster> clusterIterator=newclusters.iterator();
		while(clusterIterator.hasNext()) {
			Cluster cluster=clusterIterator.next();
			cluster.recomputeCentroid();
		}
		
		
		return newclusters;
	}
		
	/** Return true if the centroids have not moved */
	public static boolean isFinished(
		LinkedList<Cluster> oldClusters,
		LinkedList<Cluster> newClusters
	) {
		float tempDistance;
		int i;
		for(i=0;i<oldClusters.size();i++){
			tempDistance=oldClusters.get(i)._centroid.distanceFrom(newClusters.get(i)._centroid);
			if(tempDistance>0.000001f) break;
		}
		if(i==oldClusters.size()) return true;
		else return false;
	}
	
	/** This is the entry point to our code */
	public static LinkedList<Cluster> solve() {
		LinkedList<Cluster> clusters=new LinkedList<Cluster>();
		rand.setSeed( System.currentTimeMillis() ); // Change to something predictable
		LinkedList<Point> points = getInitialPoints( 100, 100 );
		int numClusters = 2;
		LinkedList<Cluster> oldclusters = getInitialClusters( points, numClusters );
		while( true ) {
			LinkedList<Cluster> newclusters = computeClusterIndices(points, oldclusters );
			if( isFinished( oldclusters, newclusters ) )
				return newclusters;
			else oldclusters=newclusters;
		}
	}
	
	public static void main( String[] args ) {
		float x,y;
		LinkedList<Cluster> solution = solve();
		System.out.println("Finished!");
		for(Cluster cluster:solution) {
			x=cluster._centroid._coordinates[0];
			y=cluster._centroid._coordinates[1];
			System.out.println(x+"|"+y);
		}
	}

}
