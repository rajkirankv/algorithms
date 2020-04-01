/*
This class implements a weighted graph
*/
package graphs.undirected.weighted;

import java.io.FileInputStream;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import graphs.undirected.weighted.Edge;
import java.util.ArrayList;
import java.util.HashSet;

public class WGraph {

	protected final int V;
	protected int E;
	protected ArrayList<Edge>[] adj;

	public WGraph(int V) {
		this.V = V;
		build(V);
	}

	public WGraph(FileInputStream in) {
		Scanner sc = new Scanner(in);
		this.V = sc.nextInt();
		int E = sc.nextInt();
		build(V);

		while(sc.hasNextLine())
			addEdge(new Edge(sc.nextInt(), sc.nextInt(), sc.nextDouble()));
		
		assert E == this.E : String.format("%d edges were promised but % edges were provided", E, this.E);
		sc.close();
	}

	public WGraph(File f) throws FileNotFoundException {
		this(new FileInputStream(f));
	}

	public WGraph(String fLoc) throws FileNotFoundException {
		this(new FileInputStream(fLoc));
	}

	// A separate private method is written to circumvent the restriction that constructors
	// cannot use other constructors except as thier first statement.
	protected void build(int V) {
		adj = (ArrayList<Edge>[]) new ArrayList[V];
		for(int i = 0; i < V; i++)
			adj[i] = new ArrayList<Edge>();
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void addEdge(Edge e) {
		int v = e.either();
		int w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		this.E++;
	}

	public Iterable<Edge> adj(int v) {
		return adj[v];
	}

	public Iterable<Edge> edges() {
		HashSet edges = new HashSet(this.E);
		for(int v = 0; v < this.V(); v++)
			for(Edge e : this.adj(v))
				edges.add(e);
		return edges;
	}

	@Override
	public String toString() {
		String s = String.format("%d\n%d\n", V, E);
		for(Edge e : this.edges())
			s += e.toString() + "\n";
		return s;
	}

	public static void main(String[] args) throws FileNotFoundException {
	}
}












