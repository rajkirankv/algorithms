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
import java.io.File;
import java.io.FileNotFoundException;

class PrimLazyTest {

	private PrimLazy mst;
	private WGraph wg;
	private String fileLoc;

	@BeforeEach void init() throws FileNotFoundException {
		String param = "algs4-data/tinyEWG.txt";
		File file = new File(getClass().getClassLoader().getResource(param).getFile());
		fileLoc = file.getAbsolutePath();
		wg = new WGraph(fileLoc);
		// System.out.println(wg);
		mst = new PrimLazy(wg);
	}

	@Test void testWeight() {
		assertEquals(mst.weight(), 1.81);
	}
}