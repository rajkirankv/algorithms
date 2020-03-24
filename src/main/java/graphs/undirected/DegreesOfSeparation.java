package graphs.undirected;

import graphs.undirected.SymbolGraph;
import graphs.undirected.Path;
import graphs.undirected.PathBFS;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;

class DegreesOfSeparation {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String filename = args[0];
		String delim = args[1];
		String source = args[2];
		SymbolGraph sg = new SymbolGraph(filename, delim);
		Path p = new PathBFS(sg.g(), sg.index(source));
		
		Scanner stdIn = new Scanner(System.in);
		while (stdIn.hasNextLine()) {
			String destination = stdIn.nextLine();
			if(destination.isEmpty())
				break;
			if(!sg.contains(destination)) {
				System.out.println("No such vertex in the graph");
				continue;
			}

			int destIdx = sg.index(destination);
			if(p.hasPath(destIdx))
				for(int n : p.pathTo(destIdx))
					System.out.println(sg.vertex(n));
		}
	}
}