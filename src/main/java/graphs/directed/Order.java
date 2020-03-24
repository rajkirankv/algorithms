package graphs.directed;

import graphs.directed.DiSymbolGraph;
import graphs.directed.TopologicalSort;
import java.io.IOException;
import java.io.FileNotFoundException;

abstract class Order {
	DiGraph dg;
	abstract Iterable<Integer> traverse();

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String fileName = args[0];
		String sep = args[1];
		DiSymbolGraph dsg = new DiSymbolGraph(fileName, sep);
		TopologicalSort ts = new TopologicalSort((DiGraph) dsg.g());
		// DiGraph dg = new DiGraph(fileName);
		// TopologicalSort ts = new TopologicalSort(dg);
		for(int i : ts.traverse())
			System.out.println(dsg.vertex(i));
			// System.out.println(i);
	}
}