/*
This is an abstract class implementing the Minimum spanning tree
*/
package graphs.undirected.weighted;

import graphs.undirected.weighted.WGraph;
import graphs.undirected.weighted.Edge;
import graphs.undirected.weighted.PrimLazy;
import java.io.FileNotFoundException;
import java.util.Collection;

abstract class MST {

	Collection<Edge> edges;
	Double weight;
	WGraph wg;

	public Collection<Edge> edges() {
		return edges;
	}

	public Double weight() {
		return weight;
	}
}