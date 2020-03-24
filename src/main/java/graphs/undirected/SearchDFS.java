package graphs.undirected;

import graphs.undirected.Search;

public class SearchDFS extends Search {
	
	private boolean[] marked;
	private int count;

	public SearchDFS(Graph g, int source) {
		this.g = g;
		this.source = source;
		this.count = 0;

		dfs(g, source);
	}

	// This method performs the search and saves the reuslts in instance variables
	private void dfs(Graph g, int source) {
		marked[source] = true;
		count++;
		for(int v : g.adj(source))
			if(!marked[v])
				dfs(g, v);
	}

	public boolean marked(int v) {
		return marked[v];
	}

	public int count() {
		return count;
	}

	public static void main(String[] args) {
		/*Read and build a graph, print a SearchDFS trace on some vertex */
	}
}