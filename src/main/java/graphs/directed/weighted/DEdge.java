package graphs.directed.weighted;

import java.util.Objects;
import graphs.undirected.weighted.Edge;

class DEdge extends Edge {
	// v == from; w == to;

	DEdge(int to, int from, double weight) {super(from, to, weight);}

	int to() {return w;}
	int from() {return v;}
}