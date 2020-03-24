/**
Implements the symbol graph API
*/
package graphs.undirected;

import java.io.FileInputStream;
import java.util.Scanner;
import graphs.undirected.Graph;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class SymbolGraph {

	private String[] index;
	private HashMap<String, Integer> names;
	private Graph g;

	/**
	Accepts a text file that describes the graph and a delimiter
	@param graphFile contains lines of vertices, each line describes the edges between the vertex
	at the beginning of that line to all other vertices in that line
	@param delim is the delimiter that separates the vertices in a given line
	*/
	public SymbolGraph(String graphFile, String delim) throws FileNotFoundException, IOException {
		int V = 0;
		names = new HashMap<String, Integer>();
		
		// Pattern p = Pattern.compile("\h*" + delim + "\h*");
		Pattern p = Pattern.compile(delim);
		Scanner sc = new Scanner(new FileInputStream(graphFile)).useDelimiter(delim);
		while(sc.hasNextLine()) {
			String[] vertices = p.split(sc.nextLine());
			for(String vertex : vertices)
				if(!names.containsKey(vertex))
					names.put(vertex, V++);
		}
		sc.close();

		g = g(V); // This is instantiated separatey in a method to facilitate overriding by subclasses
		index = new String[V];
		for (String vertex : names.keySet())
			index[names.get(vertex)] = vertex;

		sc = new Scanner(new FileInputStream(graphFile)).useDelimiter(delim);
		while(sc.hasNextLine()) {
			String[] vertices = p.split(sc.nextLine());
			String root = vertices[0];
			for(int i = 1; i < vertices.length; i++)
				g.addEdge(names.get(root), names.get(vertices[i]));
		}
	}

	public boolean contains(String vertex) {return names.containsKey(vertex);}

	public int index(String vertex) {return names.get(vertex);}

	public String vertex(int i) {return index[i];}

	protected Graph g(int V) {return new Graph(V);}

	public Graph g() {return g;}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String filename = args[0];
		String delim = args[1];
		SymbolGraph sg = new SymbolGraph(filename, delim);
		Graph G = sg.g();

		Scanner stdIn = new Scanner(System.in);
		while (stdIn.hasNextLine()) {
			String source = stdIn.nextLine();
			if(source.isEmpty())
				break;
			for (int w : sg.g().adj(sg.index(source)))
				System.out.println(" " + sg.vertex(w));
		}
	}

}