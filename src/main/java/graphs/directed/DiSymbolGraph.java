package graphs.directed;

import graphs.undirected.SymbolGraph;
import graphs.directed.DiGraph;
import java.io.IOException;
import java.io.FileNotFoundException;
import graphs.undirected.Graph;

public class DiSymbolGraph extends SymbolGraph {
	
	public DiSymbolGraph(String graphFile, String delim) throws FileNotFoundException, IOException {
		super(graphFile, delim);
	}

	@Override
	protected Graph g(int V) {return new DiGraph(V);}
}