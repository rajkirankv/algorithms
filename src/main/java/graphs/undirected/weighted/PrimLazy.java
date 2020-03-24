/*
Prim's algorithm for undirected weighted graphs, lazy version
*/
package graphs.undirected.weighted;

import graphs.undirected.weighted.MST;
import graphs.undirected.weighted.WGraph;
import graphs.undirected.weighted.Edge;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Arrays;

public class PrimLazy extends MST {

	private Boolean[] marked;
	private LinkedList<Edge> edges;
	private PriorityQueue<Edge> bridges;


	public PrimLazy(WGraph wg) {
		this.wg = wg;
		marked = new Boolean[wg.V()];
		edges = new LinkedList<Edge>();
		bridges = new PriorityQueue<Edge>();
		weight = 0.0;

		int v = 0; // The choice to start with this vertex is arbitrary
		while(edges.size() < wg.V() - 1) {
			visit(v);
			v = buildMST();
		}

		assert Arrays.stream(marked).reduce(true, Boolean::logicalAnd) :
				"All vertices must be included in the MST";

		// assert Arrays.asList(marked).stream().reduce(true, (a, b) -> a && b) :
		// 		"All vertices must be included in the MST";

	}

	private void visit(int v) {
		marked[v] = true;
		for(Edge e : wg.adj(v))
			if(!marked[e.other(v)])
				bridges.add(e);
	}

	private int buildMST() {
		boolean isMarked = true;
		Edge e = null;
		int v, w; v = w = -1;
		while(bridges.size() > 0 && isMarked) {
			e = bridges.poll();
			v = e.either(); w = e.other(v);
			isMarked = marked[v] && marked[w];
		}
		
		if(bridges.size() == 0)
			throw new RuntimeException("MST is not complete yet but there are not edges left to choose from");
		
		assert !(marked[v] && marked[w]) : 
		"Both vertices can't be unmarked because this edge should not be on the priority queue if that's the case";

		bridges.add(e);
		weight += e.weight();
		
		return marked[v] ? w : v;
	}
}