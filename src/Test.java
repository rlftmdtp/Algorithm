import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

import leetcode.basic.MyStack;

import java.io.*;

public class Test {
	public static String firtstRow;
	public static void main(String[] args) {
		int grade[] = {3,2,3,6,4,5,2};
		
		// 소수점 버리기
		
		String result = String.format("%.2f", 3.1436);
		System.out.println(result);
		// 소수점 올리기
		
		
		int total = 0;
		int sum = 0;
		Stack<Integer> st = new Stack<>();
		for(int i=0; i<grade.length; i++) {
			int cur = grade[i];
			total += cur;
			
			if(st.isEmpty()) st.push(cur);
			else {
				Stack<Integer> temp = new Stack<>();
				
				while(st.peek() > cur) {
					int top = st.pop();
					int interval = top - cur;
					sum += interval;
					temp.push(top - interval);
					
					if(st.isEmpty()) break;
				}
				
				// 원복djckvl
				while(!temp.isEmpty()) {
					st.push(temp.pop());
				}
				st.push(cur);
			}
		}
		
		// System.out.println(sum);
	}
	
	public static class Job implements Comparable<Job>{
		int processId;
		int jobTime;
		int arriveTime;
		
		public Job(int processId, int jobTime, int arriveTime) {
			this.processId = processId;
			this.jobTime = jobTime;
			this.arriveTime = arriveTime;
		}
		
		public int compareTo(Job j) {
			if(this.jobTime == j.jobTime) {
				return this.processId - j.processId;
			}else return this.jobTime - j.jobTime;
		}
	}


}

