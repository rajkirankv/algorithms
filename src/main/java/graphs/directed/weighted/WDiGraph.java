package graphs.directed.weighted;

import graphs.undirected.weighted.WGraph;
import graphs.directed.weighted.DEdge;
import graphs.undirected.weighted.Edge;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class WDiGraph extends WGraph {

	public WDiGraph(int V) {super(V);}
	public WDiGraph(FileInputStream in) throws FileNotFoundException {super(in);}
	public WDiGraph(File f) throws FileNotFoundException {super(f);}
	public WDiGraph(String fLoc) throws FileNotFoundException {super(fLoc);}

	@Override
	protected void build(int V) {
		adj = (ArrayList<Edge>[]) new ArrayList[V];
		for(int i = 0; i < V; i++)
			adj[i] = new ArrayList<Edge>();
	}

	@Override
	public void addEdge(Edge e) {
		DEdge de = (DEdge) e;
		int v = de.from();
		adj[v].add(de);
		E++;
	}
}