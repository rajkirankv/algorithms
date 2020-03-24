/*
This class computes strongly connected components in DiGraphs
Exercise 4.2.23: A O2(V + E) algorithm for strongly connected components in a DiGraph
See Kosaraju's algorithm for a more efficient alternative.
*/
package graphs.directed;

import graphs.undirected.CC;
import graphs.undirected.CCDFS;
import graphs.directed.DiGraph;
import graphs.directed.DiPathDFS;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

class DiCCDFS extends CC {

	private DiGraph dg, dgRev;

	public DiCCDFS(DiGraph dg) {
		this.g = this.dg = dg;
		this.dgRev = this.dg.reverse();
		this.id = new int[dg.V()];
		this.count = 0;

		for(int v = 0; v < dg.V(); v++)
			id[v] = -1;

		for(int v = 0; v < dg.V(); v++)
			if(id[v] == -1)
				cc(v, count++);
		}

	private void cc(int v, int count) {
		boolean[] to = new boolean[dg.V()];
		boolean[] fro = new boolean[dg.V()];

		dfs(dg, v, to);
		dfs(dgRev, v, fro);
		
		for(int i = 0; i < dg.V(); i++)
			if(to[i] && fro[i])
				id[i] = count;
	}

	private void dfs(DiGraph dg, int v, boolean[] marked) {

		marked[v] = true;
		for(int w : dg.adj(v))
			if(!marked[w])
				dfs(dg, w, marked);
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {		
		DiGraph dg = new DiGraph(args[0]);
		CC cc = new DiCCDFS(dg);
		System.out.println(cc);
	}
}