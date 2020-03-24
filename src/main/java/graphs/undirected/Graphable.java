/*
This is the unweighted, undirected graph interface
*/
package graphs.undirected;

public interface Graphable {	
	public int V(); // Return number of vertices
	public int E(); // Return number of edges
	public void addEdge(int v, int w); // v and w are vertices
	public Iterable<Integer> adj(int v); // Iterate through v's adjecent vertices
	public String toString();
}
