/*
This class implements search and path using BFS
*/
package graphs.undirected;

import graphs.undirected.Graph;
import java.util.LinkedList;

public class PathBFS extends Path {

	public PathBFS(Graph g, int source) {
		this.g = g;
		this.source = source;
		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
		bfs(g, source);
	}

	private void bfs(Graph g, int s) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		marked[s] = true;
		queue.add(s);
		int v;
		while(!queue.isEmpty()) {
			v = queue.poll();
			for(int w : g.adj(v)) {
				if(!marked[w]) {
					marked[w] = true;
					edgeTo[w] = v;
					queue.add(w);
				}
			}
		}
	}
}