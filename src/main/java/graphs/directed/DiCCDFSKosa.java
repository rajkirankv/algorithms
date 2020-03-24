/*
This class computes strongly connected components in DiGraphs using Kosaraju's algorithm.
Time and Space O(V+E)
*/
package graphs.directed;

import java.util.Deque;
import java.util.ArrayDeque;
import graphs.undirected.CC;
import graphs.directed.DiGraph;
import graphs.directed.DepthFirstOrder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DiCCDFSKosa extends CC {

	private DiGraph dg, dgR;
	private ArrayDeque reversePost; // A better stack

	public DiCCDFSKosa(DiGraph dg) {
		this.g = this.dg = dg;
		this.dgR = dg.reverse();
		this.id = new int[dg.V()];
		this.count = 0;
		reversePost = (ArrayDeque<Integer>) (new DepthFirstOrder(dgR)).reversePost();

		for(int v = 0; v < dg.V(); v++)
			id[v] = -1;

		int v;
		while(!reversePost.isEmpty()) {
			v = (int) reversePost.pop();
			// If this vertex does not yet belong to any connected component
			if(id[v] == -1) 
				dfs(v, count++);
		}
	}

	private void dfs(int v, int cc) {
	id[v] = cc;
	for(int w : dg.adj(v))
		//If this node is not yet visited
		if(id[w] == -1)
			dfs(w, cc);
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {		
		DiGraph dg = new DiGraph(new FileInputStream(args[0]));
		DiCCDFSKosa cc = new DiCCDFSKosa(dg);
		System.out.println(cc);
	}
}













