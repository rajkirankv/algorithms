package graphs.undirected.weighted;

import edu.princeton.cs.algs4.UF;
import java.util.PriorityQueue;
import graphs.undirected.weighted.WGraph;
import graphs.undirected.weighted.Edge;
import java.util.LinkedList;

class Kruskal extends MST {
	
	private PriorityQueue<Edge> bridges;
	private UF mst;

	public Kruskal(WGraph wg) {
		this.wg = wg;
		mst = new UF(wg.V());
		edges = new LinkedList<Edge>();
		weight = 0.0;
		bridges = new PriorityQueue<Edge>();
		for(Edge e : wg.edges())
			bridges.add(e);

		Edge e;
		int v, w;
		while(edges.size() < wg.V() - 1) {
			e = bridges.poll();
			v = e.either(); w = e.other(v);
			if(mst.find(v) == mst.find(w)) continue;
			edges.add(e);
			weight += e.weight();
			mst.union(v, w);
		}
	}
}