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

	// @ParameterizedTest
	// @ValueSource(strings = {"tinyEWG.txt"})
	// @BeforeEach void init(String fileLoc) throws FileNotFoundException {
	// 	System.out.println("File location: ");
	// 	System.out.println(fileLoc);
	// 	System.out.println(this.getClass().getResource(fileLoc));
	// 	System.out.println("File location: ");
	// 	wg = new WGraph(fileLoc);
	// }


	@BeforeEach void init() throws FileNotFoundException {
		// String resourceName = "algs4-data/tinyEWG.txt";
		// ClassLoader classLoader = getClass().getClassLoader();
		// File file = new File(classLoader.getResource(resourceName).getFile());
		// String absolutePath = file.getAbsolutePath();
		// System.out.println(absolutePath);

		fileLoc = "algs4-data/tinyEWG.txt";
		File file = new File(getClass().getClassLoader().getResource(fileLoc).getFile());
		String s = file.getAbsolutePath();
		System.out.println(s);
		// wg = new WGraph(s);
	}

	@Test void testTemp() {
		assertTrue(true);
	}

	// @ParameterizedTest
	// @ValueSource(ints = {0, 1, 1000})
	// @Test void testWGraphIntConstructor(int V) {
	// 	assertDoesNotThrow(() -> new WGraph(V));
	// }

	// @Test void testWGraphStreamConstructor() throws FileNotFoundException {
	// 	FileInputStream in = new FileInputStream(fileLoc);
	// 	assertDoesNotThrow(() -> new WGraph(in));
	// }

	// @Test void testV() {
	// 	assertEquals(wg.V(), 8);
	// }

	// @Test void testE() {
	// 	assertEquals(wg.V(), 16);
	// }

	// @Test void testAddEdge() {
	// 	assertDoesNotThrow(() -> wg.addEdge(new Edge(4, 3, 0.8)));
	// 	assertEquals(wg.E(), 17);
	// }

	// @Test void testAdj() {
	// 	int i = 0;
	// 	for(Edge e : wg.adj(0))
	// 		i++;
	// 	assertEquals(i, 4);
	// }

	// @Test void testEdges() {
	// 	int i = 0;
	// 	for(Edge e : wg.edges())
	// 		i++;
	// 	assertEquals(i, 16);
	// }

	// @Test void testToString() throws IOException {
	// 	byte[] encoded = Files.readAllBytes(Paths.get(fileLoc));
	// 	String s = new String(encoded);
	// 	assertEquals(wg.toString(), s);
	// }
}


















