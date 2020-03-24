	/*
Implements Cycle functionality using DFS
*/
package graphs.undirected;

import graphs.undirected.Graph;

public class CycleDFS extends Cycle {

	protected boolean[] marked;
	protected boolean hasCycle;

	public CycleDFS(Graph g) {
		this.g = g;
		marked = new boolean[g.V()];
		hasCycle = false;
		for(int i = 0; i < marked.length; i++)
			marked[i] = false;
		build();
	}

	protected void build() {
		for(int v = 0; v < g.V(); v++)
			if(!marked[v] && !hasCycle)
				dfs(g, v);
	}

	protected void dfs(Graph g, int node) {
		marked[node] = true;
		for(int child : g.adj(node)) {
			if(!marked[child]) dfs(g, child);
			/* The only situation when it is ok for the child to be already marked 
			is if the child is the parent itself i.e. the node just came from there. 
			The only other possibility is that there is a cycle in the graph*/
			else if(child != node) hasCycle = true;
		}
	}

	@Override
	public boolean hasCycle() {
		return hasCycle;
	}
}