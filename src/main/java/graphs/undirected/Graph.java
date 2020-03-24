/*
This is the adjecency list based implementation of unweighted, undirected graph
*/
package graphs.undirected;

import graphs.undirected.Graphable;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.InputStream;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import graphs.undirected.PathBFS;
import graphs.undirected.CCDFS;
import graphs.undirected.Path;
import graphs.undirected.CC;

public class Graph implements Graphable {
    // Build a graph with V vertices and no edges
    protected ArrayList<Integer>[] adj;
    protected int E;
    protected final int V;
    private Path path;
    private Search search;
    private CC cc;


    public Graph(int V) {
    this.V = V;
    this.E = 0;
	adj = (ArrayList<Integer>[]) new ArrayList[V];
	for(int i = 0; i < adj.length; i++)
		adj[i] = new ArrayList<Integer>();
    }

    private Graph(Scanner sc) {
    	this(sc.nextInt());
    	int E = sc.nextInt();
    	while(sc.hasNextInt())
			addEdge(sc.nextInt(), sc.nextInt());
		assert this.E == E: "The number of edges declared" +
	    "should match the number of edges provided";
	    sc.close();
   }

    /* Build a graph from input stream. The input has the format
     V, E, v1-w1, v2-w2 ...*/
    public Graph(InputStream in) throws IOException {
    	this(new Scanner(in));
    	in.close();
    }

    public Graph(String fileLoc) throws IOException, FileNotFoundException {
        this(new FileInputStream(fileLoc));
    }

    public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		E++;
    }

    public int V() {
    	return V;
    }

    public int E() {
    	return E;
    }

    public Iterable<Integer> adj(int v) {
    	return adj[v];
    }

    // This method provides the shortest path between v and w if it exists, otherwise return null
    public Path path(int source) {
        return new PathBFS(this, source);
    }

    public CC components() {
        return new CCDFS(this);
    }

    // public String toString() {
    // 	String g = Integer.toString(adj.length) + " " + Integer.toString(E) + "\n";
    // 	for(int i = 0; i < adj.length; i++) {
    // 		g += Integer.toString(i) + " ";
    // 		for(int j = 0; j < adj[i].size(); j++)
    // 			g += Integer.toString(adj[i].get(j)) + "\n";
    // 	}
    // 	return g;
    // }

    public String toString() {
        String g = Integer.toString(E) + "\n" + Integer.toString(V) + "\n";
        for(int i = 0; i < adj.length; i++) {
            for(int j : adj(i))
                g += Integer.toString(i) + " " + Integer.toString(j) + "\n";
        }
        return g;
    }

    public static void main(String[] args) throws IOException, FileNotFoundException {
    	System.out.println(args[0]);
    	Graph g = new Graph(args[0]);
    	System.out.println(g);
    }
}
