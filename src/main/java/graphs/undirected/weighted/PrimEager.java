package graphs.undirected.weighted;

import graphs.undirected.weighted.MST;
import java.util.Arrays;
import edu.princeton.cs.algs4.IndexMinPQ;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import org.apache.commons.math3.stat.StatUtils;
import java.io.File;

class PrimEager extends MST {
	private double[] distTo;
	private int[] edgeTo;
	private boolean[] marked;
	private IndexMinPQ<Edge> bridges;

	public PrimEager(WGraph wg) {
		this.wg = wg;
		marked = new boolean[wg.V()];
		distTo = new double[wg.V()]; Arrays.fill(distTo, Double.POSITIVE_INFINITY);
		edgeTo = new int[wg.V()];
		edges = new LinkedList<Edge>();
		bridges = new IndexMinPQ<Edge>(wg.E());
		weight = 0.0;

		Edge e = new Edge(0, 0, 0.0); // This choice is arbitrary
		while(edges.size() < wg.V() - 1) {
			cross(e);
			e = bridges.minKey(); bridges.delMin();
			edges.add(e);
			weight += e.weight();
		}
	}

	private void cross(Edge e) {
		int v1, v2, v, w;
		v1 = e.either(); v2 = e.other(v1);
		if(marked[v1] && marked[v2])
			throw new RuntimeException("Both vertices of the edge can't already be marked");
		v = marked[v1] ? v2 : v1; 

		marked[v] = true;
		edgeTo[v] = e.other(v);
		distTo[v] = e.weight();
		
		for(Edge eNext : wg.adj(v)) {
			w = eNext.other(v);
			if(!marked[w]) // If this edge is not on the MST already
				if(Double.isFinite(distTo[w])) // A costlier path was already discovered
					bridges.changeKey(w, eNext);
				else	
					bridges.insert(w, eNext);
		}
	}

	@Override
	public String toString() {
		String s = String.format("%d\n%d\n", wg.V(), wg.E());
		for(Edge e : edges())
			s += e.toString() + "\n";
		return s.trim();
	}
}