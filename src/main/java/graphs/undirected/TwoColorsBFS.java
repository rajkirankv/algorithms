/*BFS implementation of bipartite graphs*/
package graphs.undirected;

import graphs.undirected.Graph;
import graphs.undirected.TwoColors;
import java.util.LinkedList;

class TwoColorsBFS extends TwoColors {

	public TwoColorsBFS(Graph g) {
		this.g = g;
		isBipartite = true;
		colors = new Color[g.V()];
		colorNodes(this.g);
	}

	// This seach is BFS based
	@Override
	protected void search(int node) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		colors[node] = Color.BLUE; // or Color.GREEN
		queue.add(node);
		while(!queue.isEmpty()) {
			int cNode = queue.poll(); // current node
			Color cColor = flipColor(cNode); // current color 
			for(int n : g.adj(cNode)) {
				if(!isColored(n)) {
					colors[n] = cColor;
					queue.add(n);
				}
				// there is a link between nodes of same color
				else if(colors[n] == colors[cNode]) {
					isBipartite = false;
					return;
				}
				else
					continue;
			}
		}
	}

}