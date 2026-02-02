package java_20260202;

import java.util.*;

public class StackExam {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 1; i < 6; i++) {stack.push(i);}
		
		while(!stack.isEmpty()) {
			int data = stack.pop();
			System.out.println(data);
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1; i < 6; i++) {q.offer(i);}
		
		while(!q.isEmpty()) {
			int data = q.poll();
			System.out.println(data);
		}
	}
}
