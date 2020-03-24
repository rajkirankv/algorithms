package graphs.undirected.weighted;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EdgeTest {
	
	Edge e;

	@BeforeEach void setUp() {
		e = new Edge(1, 2, 0.5);
	}

	@Test void testEither() {
		int v = e.either();
		assertTrue(v == 1 || v == 2);
	}

	@Test void testOther() {
		int v, w;
		v = e.either(); w = e.other(v);
		assertTrue((v == 1 && w == 2) || (w == 1 && v == 2));
	}

	@Test void testWeight() {
		double w = e.weight();
		assertEquals(w, 0.5);
	}

	@Test void testToString() {
		assertTrue(e.toString().equals(String.format("%d %d %.4f", 1, 2, 0.5)) ||
					e.toString().equals(String.format("%d %d %.4f", 2, 1, 0.5)));
	}
}