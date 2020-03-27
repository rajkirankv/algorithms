/*
Prim's algorithm for undirected weighted graphs, lazy version
*/
package graphs.undirected.weighted;

import graphs.undirected.weighted.MST;
import graphs.undirected.weighted.WGraph;
import graphs.undirected.weighted.Edge;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Arrays;
import org.apache.commons.math3.stat.StatUtils;
import java.io.FileNotFoundException;
import java.io.File;

public class PrimLazy extends MST {

	private boolean[] marked;
	private int E; // Number of edges in MST
	private PriorityQueue<Edge> bridges;


	public PrimLazy(WGraph wg) {
		this.wg = wg;
		marked = new boolean[wg.V()];
		edges = new LinkedList<Edge>();
		bridges = new PriorityQueue<Edge>();
		weight = 0.0;
		E = 0;

		int v = 0; // The choice to start with this vertex is arbitrary
		while(E < wg.V() - 1) {
			visit(v);
			v = buildMST();
		}
		//TODO: Build a stream from a primitive boolean array
		// assert Arrays.stream(marked).reduce(true, Boolean::logicalAnd) :
		// 		"All vertices must be included in the MST";
	}

	private void visit(int v) {
		marked[v] = true;
		for(Edge e : wg.adj(v))
			if(!marked[e.other(v)])
				bridges.add(e);
	}

	private int buildMST() {
		boolean isMarked = true;
		Edge e = null;
		int v, w; v = w = -1;
		while(isMarked) {
			e = bridges.poll();
			v = e.either(); w = e.other(v);
			isMarked = marked[v] && marked[w];
		}

		if(bridges.size() == 0)
			throw new RuntimeException("MST is not complete yet but there are not edges left to choose from");
		
		assert !(marked[v] && marked[w]) : 
		"Both vertices can't be unmarked because this edge should not be on the priority queue if that's the case";

		edges.add(e);
		weight += e.weight(); E++;
		
		return marked[v] ? w : v;
	}

	@Override
	public String toString() {
		String s = String.format("%d\n%d\n", wg.V(), E);
		for(Edge e : edges())
			s += e.toString() + "\n";
		return s.trim();
	}

	public static void main(String[] args) throws FileNotFoundException {
		// File file = new File(getClass().getClassLoader().getResource(args[0]).getFile());
		System.out.println("The file: " + args[0]);
		// File file = new File(PrimLazy.class.getResource(args[0]).getFile());
		File file = new File(args[0]);
		String fileLoc = file.getAbsolutePath();
		System.out.println(fileLoc);
		WGraph wg = new WGraph(fileLoc);
		int n = 10;
		double[] times = new double[n];
		long startTime, stopTime;
		for(int i = 0; i < n; i++) {
			startTime = System.nanoTime();
			MST mst = new PrimLazy(wg);
			stopTime = System.nanoTime();
			times[i] = (double) (stopTime - startTime)/Math.pow(10.0, 6.0);
		}
		System.out.println("Average execution time: " + StatUtils.mean(times));
		System.out.println("Standard deviation of execution time: " + Math.sqrt(StatUtils.variance(times)));
	}
}



















