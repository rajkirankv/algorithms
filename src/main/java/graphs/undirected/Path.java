/*
This is the abstract class that specifies what a path object should support
*/
package graphs.undirected;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.Stack;
import graphs.undirected.Graph;

abstract class Path {
	protected Graph g;
	protected int source;
	protected boolean[] marked;
	protected int[] edgeTo;

	// Return true if a path exists between source and v, else false
	public boolean hasPath(int v) {
		return marked[v];
	}

	// Return a path from source to vertex v if it exists, otherwise return null
	public Iterable<Integer> pathTo(int v) {
		if(!hasPath(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int w = v; w != source; w = edgeTo[w])
			path.push(w);
		path.push(source);
		return path;
	}

	public String toString() {
		String s = "\n";
		for(int i = 0; i < g.V(); i++) {
			s += i + " to " + source  + ": ";
			for(int w : pathTo(i))
				s +=  w + " --> ";
			s = s.substring(0, s.length() - 5) + "\n";
		}
		return s;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Graph g = new Graph(new FileInputStream(args[0]));
		int s = Integer.parseInt(args[1]);
		// Path p = new PathDFS(g, s);
		Path p = new PathBFS(g, s);
		System.out.println(p);
	}
}