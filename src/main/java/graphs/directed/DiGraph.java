package graphs.directed;

import graphs.undirected.Graph;
import java.util.Scanner;
import java.io.InputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class DiGraph extends Graph {

    public DiGraph(int V) {
        super(V);
    }

    public DiGraph(InputStream in) throws IOException {
        super(in);
    }

    public DiGraph(String fileLoc) throws IOException, FileNotFoundException {
        super(fileLoc);
    }

	@Override
	public void addEdge(int v, int w) {
		adj[v].add(w);
		E++;
	}

	@Override
	public String toString() {
        String g = Integer.toString(E) + "\n" + Integer.toString(V) + "\n";
        for(int i = 0; i < adj.length; i++) {
            for(int j : adj(i))
                g += Integer.toString(i) + "-->" + Integer.toString(j) + "\n";
        }
        return g;
    }

    public DiGraph reverse() {
    	DiGraph reverse = new DiGraph(this.V);
    	for(int i = 0; i < this.V; i++)
    		for(int v: this.adj[i])
    			reverse.addEdge(v, i);
    	return reverse;
    }
}