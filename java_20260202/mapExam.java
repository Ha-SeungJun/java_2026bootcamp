package java_20260202;

import java.util.*;
import java.util.Map.Entry;

public class mapExam {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>()
;		
		map.put("a",40);
		map.put("b",80);
		map.put("c",60);
		map.put("a",100);
		System.out.printf("총 entry 수 : %d \n", map.size());
		
		String key = "a";
		int val = map.get(key);
		System.out.printf("%s : %d \n",key,val);
		
		Set<String> keySet = map.keySet();
		Iterator<String> keyIter = keySet.iterator();
		
		while(keyIter.hasNext()) {
			String k = keyIter.next();
			Integer v = map.get(k);
			System.out.printf("%s : %d \n",k,v);
		}
		
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Entry<String,Integer>> entryIt = entrySet.iterator();
		
		while(entryIt.hasNext()) {
			Entry<String, Integer> entry = entryIt.next();
			String k = entry.getKey();
			Integer v = entry.getValue();
			System.out.printf("k : %s, v : %d \n",k,v);
		}
	}
}
