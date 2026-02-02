package java_20260202;
import java.util.*;

public class TreeSetExam {
	public static void main(String[] args) {
		TreeSet<Integer> scores = new TreeSet<Integer>();
		
		for(int i = 0; i < 5; i++) scores.add((int)(Math.random() * 100 + 1));
		
		for(Integer i : scores) System.out.printf("%d : \n",i);
		
		System.out.println(scores.first());
		System.out.println(scores.last());
		System.out.printf("95점 아래 점수 : %d \n",scores.lower(95));
		System.out.printf("95점 위 점수 : %d \n",scores.higher(95));
		System.out.printf("95점 이거나 아래 점수 : %d \n",scores.floor(95));
		System.out.printf("95점 이거나 위 점수 : %d \n",scores.ceiling(95));
		
		NavigableSet<Integer> nav = scores.descendingSet();
		System.out.println(nav);
		
		NavigableSet<Integer> rangeSet = scores.tailSet(80, !false);
		for(Integer i : rangeSet)
		{
			System.out.println(i);
		}
		
		NavigableSet<Integer> rangeSet2 = scores.subSet(70, !false, 90, true);
		for(Integer i : rangeSet2)
		{
			System.out.println(i);
		}
	}
}
