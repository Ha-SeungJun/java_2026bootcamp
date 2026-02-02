package java_quiz;
import java.util.*;

/*
 * 해쉬맾에 아이디와 점수가 저장되어있고 실행결과와 같이 평균점수 최고점수 최고점수아이디 출력
 */
public class quiz_7 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("blue",96);
		map.put("white",82);
		map.put("red",82);
		
		String name = null;
		int maxScore = 0;
		int totalScore = 0;
		
		Set<String> keySet = map.keySet();
		Iterator<String> keyIter = keySet.iterator();
		
		while(keyIter.hasNext()) {
			String k = keyIter.next();
			Integer v = map.get(k);
			if (maxScore < v) {
				name = k;
				maxScore = v;
			}
			totalScore += (int)v;
		}

		System.out.printf("평균점수 : %.2f \n", (double)(totalScore)/map.size());
		System.out.printf("최고점수 : %d \n",maxScore);
		System.out.printf("최고 점수를 받은 ID : %s",name);
	}
}