package telran.collections.tests;
import static org.junit.Assert.assertArrayEquals;

import java.util.*;

import org.junit.jupiter.api.*;


public class HashSetTests {
	Integer numbers[] = {32, 64, 20, 40, 9};
	HashSet<Integer> hashSet;
	LinkedHashSet<Integer> linkedHashSet;
	
	@BeforeEach
	void setUp() {
		hashSet = new HashSet<>(Arrays.asList(numbers));
		linkedHashSet = new LinkedHashSet<>(Arrays.asList(numbers));
	}
	
	@Test
	void toArrayTest() {
		Integer expectedHashSet[] = {32 ,64, 20, 40, 9};
		Integer expectedLinkedHashSet[] = Arrays.copyOf(numbers, numbers.length);
		assertArrayEquals(expectedHashSet, hashSet.toArray(Integer[] :: new));
		assertArrayEquals(expectedLinkedHashSet, linkedHashSet.toArray(Integer[] :: new));
	}
}
