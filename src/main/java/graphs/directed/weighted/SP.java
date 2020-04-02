package graphs.directed.weighted;

import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import graphs.directed.weighted.WDiGraph;
import graphs.directed.weighted.DEdge;

abstract class SP {
	
	protected WDiGraph wdg;
	protected int source;
	protected double[] distTo;
	protected DEdge[] edgeTo;

	public boolean hasPathTo(int w) {return distTo[w] < Double.POSITIVE_INFINITY;}
	
	public Collection<DEdge> pathTo(int w) {
		if(!hasPathTo(w)) return null;
		Deque<DEdge> path = new LinkedList<DEdge>();
		DEdge edge = null;
		for(int v = w; v != source; v = edge.from()) {
			edge = edgeTo[v];
			path.add(edge);
		}
		return path;
	}

	public double distTo(int w) {return distTo[w];}
}