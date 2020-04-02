package graphs.directed.weighted;

import graphs.directed.weighted.WDiGraph;
import graphs.directed.weighted.DEdge;
import graphs.undirected.weighted.Edge;
import edu.princeton.cs.algs4.IndexMinPQ;
import java.util.Arrays;

class SPDijkstra extends SP {
	
	private IndexMinPQ<Double> pq;

	public SPDijkstra(WDiGraph wdg, int source) {
		this.source = source;
		this.wdg = wdg;
		distTo = new double[wdg.V()];
		edgeTo = new DEdge[wdg.V()];
		pq = new IndexMinPQ<Double>(wdg.V());

		Arrays.fill(distTo, Double.POSITIVE_INFINITY);
		distTo[source] = 0;
		pq.insert(source, 0.0);

		while(!pq.isEmpty())
			relax(pq.delMin());
	}

	private boolean isEligible(DEdge de) {
		return distTo[de.from()] + de.weight() < distTo[de.to()];
	}

	private void relax(int v){
		for(Edge de : wdg.adj(v))
			relax((DEdge) de);
	}

	private void relax(DEdge de) {
		if(isEligible(de)) {
			int to = de.to();
			distTo[to] = distTo[de.from()] + de.weight();
			edgeTo[to] = de;
			if(pq.contains(to)) pq.changeKey(to, distTo[to]);
			else pq.insert(to, distTo[to]);
		}
	}
}