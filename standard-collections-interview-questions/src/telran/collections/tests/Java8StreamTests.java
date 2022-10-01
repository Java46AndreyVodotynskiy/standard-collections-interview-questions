package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Java8StreamTests {
	
	static class Programmer {
		String name;
		int age;
		String [] technologies;
		
		public Programmer(String name, int age, String[] technologies) {
			this.name = name;
			this.age = age;
			this.technologies = technologies;
		}

		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}

		public String[] getTechnologies() {
			return technologies;
		}
		
		

	}
	List<Programmer> programmers;
	String[] technologies1 = {"Java", "SQL", "C++"};
	String[] technologies2 = {"Java"};
	String[] technologies3 = {"Java", "React", "SQL"};
	
	
	
	@BeforeEach
	void setUp() {
		programmers = Arrays.asList(new Programmer("Vasya", 30, technologies1), 
				new Programmer("Peter", 25, technologies2),
				new Programmer("Sara", 35, technologies3));
	}
	

	@Test
	void testSumTwoDimArray() {
		int ar[][] = {{1,2}, {3,4,5}, {7}};
		assertEquals(22, sumTwoDimArray(ar));
	}

	private Integer sumTwoDimArray(int[][] ar) {
		
		return Arrays.stream(ar).flatMapToInt(a -> Arrays.stream(a)).sum();
	}
	
	@Test
	void averageProgrammersAgeTest() {
		assertEquals(30.0, getAverageAge());
	}


	private Double getAverageAge() {
		
//		return programmers.stream().mapToInt(p -> p.getAge())
//				.average().orElse(0);
		return programmers.stream().collect(Collectors.averagingInt(Programmer::getAge));
	}
	
	@Test
	void mostPopularTechnologyTest() {
		assertEquals("Java", getPopularTechnology());

}


	private Object getPopularTechnology() {
	
		return programmers.stream().flatMap(p -> Arrays.stream(p.getTechnologies()))
				.collect(Collectors.groupingBy(s -> s, Collectors.counting()))
				.entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
				.map(Map.Entry<String, Long>::getKey)
				.findFirst().orElse(null);
	}
	
	@Test
	void printDigitOccurrences() {
		//TODO
		//generate 1_000_000 random numbers from 0 to Integer.MAX_VALUE
		//print digits occurrences in descending order of occurrences
		// 1: <occurrences>
		// 2: <occurrences>
		// ......
	}
}
