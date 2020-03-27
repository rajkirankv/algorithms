package graphs.undirected.weighted;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import java.io.FileInputStream;
import graphs.undirected.weighted.Edge;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;

class WGraphTest {

	String fileLoc;
	WGraph wg;

	@BeforeEach void init() throws FileNotFoundException {
		String param = "algs4-data/tinyEWG.txt";
		File file = new File(getClass().getClassLoader().getResource(param).getFile());
		fileLoc = file.getAbsolutePath();
		wg = new WGraph(fileLoc);
	}

	@Test void testTemp() {
		assertTrue(true);
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 1000})
	void testWGraphIntConstructor(int V) {
		assertDoesNotThrow(() -> new WGraph(V));
	}

	@Test void testWGraphStreamConstructor() throws FileNotFoundException {
		FileInputStream in = new FileInputStream(fileLoc);
		assertDoesNotThrow(() -> new WGraph(in));
	}

	@Test void testV() {
		assertEquals(wg.V(), 8);
	}

	@Test void testE() {
		assertEquals(wg.E(), 16);
	}

	@Test void testAddEdge() {
		assertDoesNotThrow(() -> wg.addEdge(new Edge(4, 3, 0.8)));
		assertEquals(wg.E(), 17);
	}

	@Test void testAdj() {
		int i = 0;
		for(Edge e : wg.adj(0))
			i++;
		assertEquals(i, 4);
	}

	@Test void testEdges() {
		int i = 0;
		for(Edge e : wg.edges())
			i++;
		assertEquals(i, 16);
	}
}


















