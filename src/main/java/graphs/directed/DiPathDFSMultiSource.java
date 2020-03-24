package graphs.directed;

import graphs.undirected.PathDFS;

class DiPathDFSMultiSource extends PathDFS {

	public DiPathDFSMultiSource(DiGraph dg, Iterable<Integer> sources) {
		super(dg);

		for(int source : sources)
			if(!marked[source])
				dfs(g, source);
	}

	public boolean isReachable(int v) {
		return hasPath(v);
	}
}