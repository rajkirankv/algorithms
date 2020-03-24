package graphs.directed;

import graphs.directed.DepthFirstOrder;
import graphs.directed.DiGraph;
import graphs.directed.DiCycleDFS;

public class TopologicalSort extends DepthFirstOrder {

	boolean isDAG;

	public TopologicalSort(DiGraph dg) {
		super(dg);
		isDAG = !(new DiCycleDFS(this.dg)).hasCycle();
	}

	public boolean isDAG() {
		return isDAG;
	}

	@Override
	public Iterable<Integer> traverse() {
		return isDAG ? reversePost() : null;
	}

}