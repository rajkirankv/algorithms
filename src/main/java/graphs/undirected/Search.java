/*
This is the rudimentary search interface that performs searches on Graphs
*/

package graphs.undirected;

// import edu.princeton.cs.algs4.Graph;
import graphs.undirected.Graph;

abstract class Search {

	Graph g;
	int source;
	
	// Return true if v is connected to source, otherwise false
	public abstract boolean marked(int v);

	// Return the number of vertices connected to source
	public abstract int count();

}