package newPackage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NewClassTest {

	NewClass newClass;

	@BeforeEach void setUp() {
		newClass = new NewClass();
	}

	@Test void testNewMethod() {
		assertTrue(newClass.newMethod(), "New class' new method must return true");
	}

	@Test void testUseMethod() {
		assertTrue(newClass.useMethod(), "The imported method in new class must return true");
	}
}