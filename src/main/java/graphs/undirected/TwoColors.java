/*
This is a template class for classes providing the functionality of checking whether a given graph is bipartite
*/

package graphs.undirected;

import graphs.undirected.Graph;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import graphs.undirected.TwoColorsBFS;
import graphs.undirected.TwoColorsDFS;

enum Color {
	BLUE,
	GREEN
}

abstract class TwoColors {

	protected Graph g;
	protected boolean isBipartite;
	protected Color[] colors;

	protected boolean isColored(int node) {
		return colors[node] != null;
	}

	protected Color flipColor(int node) {
		return colors[node] == Color.BLUE ? Color.GREEN : Color.BLUE; 
	}

	protected void colorNodes(Graph g) {
		for(int i = 0; i < g.V(); i++)
			if (isBipartite && !isColored(i))
				// This method is called exactly as many times as there are disconnected components
				search(i);
	}

	public boolean isBipartite() {
		return isBipartite;
	}

	abstract void search(int node); 

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Graph g = new Graph(new FileInputStream(args[0]));
		// TwoColors tc = new TwoColorsBFS(g);
		TwoColors tc = new TwoColorsDFS(g);
		assert tc.isBipartite() : "The algorithm must detect that the graph is bipartite";
	}
} 

