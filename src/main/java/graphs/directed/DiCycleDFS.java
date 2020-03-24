package graphs.directed;

import graphs.undirected.CycleDFS;
import java.util.Stack;
import graphs.undirected.Graph;
import java.util.Arrays;
import graphs.directed.DiGraph;

public class DiCycleDFS extends CycleDFS {

	private boolean[] onStack;
	private Stack<Integer> cycle;

	public DiCycleDFS(DiGraph g) {
		super(g);
		if(!hasCycle)
			assert cycle.size() == 0 : "If there are no cycles, there should not be any nodes remaining on the stack trace";
	}

	@Override
	protected void build() {
		onStack = new boolean[g.V()];
		cycle = new Stack<Integer>();
		for(int v = 0; v < g.V(); v++)
			if(!marked[v] && !hasCycle)
				dfs(g, v);
	}

	@Override
	protected void dfs(Graph g, int node) {
		// The only additional function of the overridden method is to fill onStack and return the cycle if there is one.
		
		assert g instanceof DiGraph : "Make sure this method works on a digraph";

		marked[node] = true;
		onStack[node] = true;
		cycle.push(node);

		for(int child : g.adj(node))
			if(onStack[child]) {
				hasCycle = true;
				cycle.push(child);
				return;
			}
			else
				dfs(g, child);
		
		onStack[node] = false;
		cycle.pop();
	}

	public Iterable<Integer> cycle() {
		return cycle;
	}
}