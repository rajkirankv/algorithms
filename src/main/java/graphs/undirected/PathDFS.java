/*
This class implements Path API using DFS
*/
package graphs.undirected;

import graphs.undirected.Graph;
import graphs.undirected.Path;

public class PathDFS extends Path {

	protected PathDFS(Graph g) {
		this.g = g;
		this.marked = new boolean[g.V()];
		this.edgeTo = new int[g.V()];
	}

	public PathDFS(Graph g, int source) {
		this(g);
		this.source = source;
		dfs(g, source);
	}

	protected void dfs(Graph g, int v) {
		marked[v] = true;
		for(int w: g.adj(v))
			if(!marked[w]) {
				edgeTo[w] = v;
				dfs(g, w);
			}
	}
}