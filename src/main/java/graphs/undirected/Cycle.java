/*
This class looks for a cycle in a given graph
Assumptions about the graph:
No self loops
No parallel edges

The graph may or may not be connected
*/
package graphs.undirected;

import graphs.undirected.Graph;
import graphs.undirected.CycleDFS;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import graphs.directed.DiCycleDFS;
import graphs.directed.DiGraph;

abstract class Cycle {
	protected Graph g;
	abstract boolean hasCycle();
	abstract void build();

	public static void main(String[] args) throws FileNotFoundException, IOException {
		DiGraph dg = new DiGraph(new FileInputStream(args[0]));
		// Cycle c = new CycleDFS(g);
		DiCycleDFS c = new DiCycleDFS(dg);
		System.out.println(String.format("Does the graph have a cycle?: %b", c.hasCycle()));
		System.out.println("The cycle found is: " +  c.cycle());
	}
}