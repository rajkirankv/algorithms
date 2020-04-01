package graphs.directed.weighted;

import graphs.directed.weighted.WDiGraph;
import graphs.directed.weighted.DEdge;

abstract class ShortestPath {
	
	protected WDiGraph wdg;
	protected int dest;	

	// public abstract ShortestPath(WDiGraph wdg, int source);
	public abstract double distTo(int dest);
	public abstract boolean hasPathTo(int dest);
	public abstract Iterable<DEdge> pathTo(int dest);

	// public static void main(String[] args) {
	// 	String fLoc = args[0];
	// 	int source = String.parseInt(args[1]);
	// 	WDiGraph wdg = new WDiGraph(fLoc);
	// 	ShortestPath sp = new ShortestPath(wdg, source);
		
	// 	System.out.print(source);
	// 	for(int i = 0; i < wdg.V(); i++)
	// 		if(sp.hasPathTo(v))
	// 			for(DEdge de : sp.pathTo(v))
	// 				System.out.print("-->" + de.to());
	// }
}