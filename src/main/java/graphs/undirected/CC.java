/*
This defines the abstract class for connected components
*/
package graphs.undirected;

import graphs.undirected.Graph;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class CC {
	protected Graph g;
	protected boolean[] marked;
	protected int[] id;
	protected int count;

	public boolean connected(int v, int w) {
		return (id[v] == id[w]);
	}

	public int count() {
		return count;
	}

	public int id(int v) {
		return id[v];
	}

	public String toString() {
		
		ArrayList<Integer>[] comps = (ArrayList<Integer>[]) new ArrayList[count];
		for(int i = 0; i < count; i++) comps[i] = new ArrayList<Integer>();
		for(int v = 0; v < g.V(); v++)
			comps[id[v]].add(v);

		String s = String.format("Vertices: %d, Components: %d\n", g.V(), count);
		for(int i = 0; i < count; i++)
			s += comps[i].toString() + "\n";
		return s;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {		
		Graph g = new Graph(new FileInputStream(args[0]));
		CC cc = new CCDFS(g);
		System.out.println(cc);
	}
}