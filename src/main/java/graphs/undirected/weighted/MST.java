/*
This is an abstract class implementing the Minimum spanning tree
*/
package graphs.undirected.weighted;

import graphs.undirected.weighted.WGraph;
import graphs.undirected.weighted.Edge;
import graphs.undirected.weighted.PrimLazy;
import java.io.FileNotFoundException;

abstract class MST {

	Iterable<Edge> edges;
	Double weight;
	WGraph wg;

	// public MST(WGraph wg);
	public Iterable<Edge> edges() {
		return edges;
	}

	public Double weight() {
		return weight;
	}

	public static void main(String[] args) throws FileNotFoundException {
		String fileLoc = args[0];
		WGraph wg = new WGraph(fileLoc);
		MST mst = new PrimLazy(wg);
		for(Edge e : mst.edges())
			System.out.println(e);
		System.out.println(mst.weight());
	}
}