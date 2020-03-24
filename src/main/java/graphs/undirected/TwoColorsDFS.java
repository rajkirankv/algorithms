/*DFS implementation of bipartite graphs*/
package graphs.undirected;

import graphs.undirected.Graph;
import graphs.undirected.TwoColors;
import java.util.LinkedList;
import java.util.Arrays;

class TwoColorsDFS extends TwoColors {

	public TwoColorsDFS(Graph g) {
		this.g = g;
		isBipartite = true;
		colors = new Color[g.V()];
		colorNodes(this.g);
	}

	// This seach is DFS based
	@Override
	protected void search(int node) {
		search(node, Color.BLUE); // or search(i, Color.GREEN)

	}

	private void search(int node, Color c) {
		colors[node] = c;
		for(int n : g.adj(node))
			if(isBipartite) {
				if(!isColored(n))
					search(n, flipColor(node));
				else if(colors[n] == colors[node])
					isBipartite = false;
				else
					continue;
			}
	}

}