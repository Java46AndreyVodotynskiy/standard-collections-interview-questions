package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;

class MapTest {

	@Test
	void occurrencesTest() {
		String strings [] = {"1pm", "abc", "ab", "a", "1pm", "abc", "1pm"};
		displayStringOccurrences(strings);
	}

	private void displayStringOccurrences(String[] strings) {
		Map<String, Integer> mapOccurrences = getMapOccurrences(strings);
		List<Map.Entry<String, Integer>> sortedListOccurrences = getSortedList(mapOccurrences);
		
	}

	private List<Entry<String, Integer>> getSortedList(Map<String, Integer> mapOccurrences) {
		List<Entry<String, Integer>> res = new ArrayList<>(mapOccurrences.entrySet());
		res.sort((e1, e2) -> {
			int cmpRes = Integer.compare(e1.getValue(), e2.getValue());
			if(cmpRes == 0) {
				cmpRes = e1.getKey().compareTo((e2.getKey()));
			}
			return cmpRes;
		});
		
		return res;
	}

	private Map<String, Integer> getMapOccurrences(String[] strings) {
		Map<String, Integer> res = new HashMap<>();
		for(String str: strings) {
			Integer count = res.getOrDefault(str, 0);
			res.put(str, count + 1);
		}
		return res;
	}

}
