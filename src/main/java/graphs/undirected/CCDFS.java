/*
This implements Connected components using DFS
*/
package graphs.undirected;

import graphs.undirected.Graph;

public class CCDFS extends CC {
	public CCDFS(Graph g) {
		this.g = g;
		this.count = 0;
		marked = new boolean[g.V()];
		id = new int[g.V()];

		for(int i = 0; i < g.V(); i++)
			if(!marked[i]) {
				dfs(g, i);
				count++;
			}
			
	}

	private void dfs(Graph g, int v) {
		marked[v] = true;
		id[v] = count;
		for(int w : g.adj(v))
			if(!marked[w])
				dfs(g, w);
	}
}