package graphs.undirected.weighted;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import graphs.undirected.weighted.WGraph;
import graphs.undirected.weighted.Edge;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import com.google.common.collect.Sets;

class PrimLazyTest {

	private PrimLazy mst;
	private WGraph wg;
	private String fileLoc;

	@BeforeEach void init() throws FileNotFoundException {
		String param = "algs4-data/tinyEWG.txt";
		File file = new File(getClass().getClassLoader().getResource(param).getFile());
		fileLoc = file.getAbsolutePath();
		wg = new WGraph(fileLoc);
		mst = new PrimLazy(wg);
	}

	@Test void testWeight() {
		assertEquals(mst.weight(), 1.81);
	}

	@Test void testEdges() {
		HashSet<Edge> groundTruth = Sets.newHashSet(
			new Edge(0, 7, 0.16),
			new Edge(1, 7, 0.19),
			new Edge(0, 2, 0.26),
			new Edge(2, 3, 0.17),
			new Edge(5, 7, 0.28),
			new Edge(4, 5, 0.35),
			new Edge(6, 2, 0.40)
			);
		HashSet<Edge> mstEdges = new HashSet<Edge>(mst.edges());
		assertEquals(groundTruth.hashCode(), mstEdges.hashCode());
	}

	// public static void main(String[] args) throws FileNotFoundException {
	// 	// File file = new File(getClass().getClassLoader().getResource(args[0]).getFile());
	// 	System.out.println("The file: " + args[0]);
	// 	// File file = new File(PrimLazy.class.getResource(args[0]).getFile());
	// 	File file = new File(args[0]);
	// 	String fileLoc = file.getAbsolutePath();
	// 	System.out.println(fileLoc);
	// 	WGraph wg = new WGraph(fileLoc);
	// 	int n = 10;
	// 	double[] times = new double[n];
	// 	long startTime, stopTime;
	// 	for(int i = 0; i < n; i++) {
	// 		startTime = System.nanoTime();
	// 		MST mst = new PrimLazy(wg);
	// 		stopTime = System.nanoTime();
	// 		times[i] = (double) (stopTime - startTime)/Math.pow(10.0, 6.0);
	// 	}
	// 	System.out.println("Average execution time: " + StatUtils.mean(times));
	// 	System.out.println("Standard deviation of execution time: " + Math.sqrt(StatUtils.variance(times)));
	// }
}

