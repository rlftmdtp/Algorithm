package baekjoon.silver2;

import java.io.*;
import java.util.*;

public class Baekjoon_1931 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Meeting> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			String strSplit[] = br.readLine().split(" ");
			pq.add(new Meeting(Integer.parseInt(strSplit[0]), Integer.parseInt(strSplit[1])));
		}
		
		int result = 0;
		while(!pq.isEmpty()) {
			Meeting m = pq.poll();
			result++;
			
			while(!pq.isEmpty()) {
				Meeting m2 = pq.poll();
				
				// 다른 회의의 시작시간이 회의가 끝나고 나서부터이다
				if(m2.startTime >= m.endTime) {
					pq.add(m2);
					break;
				}
			}
		}
		
		System.out.println(result);
	}

}

class Meeting implements Comparable<Meeting>{
	int startTime;
	int endTime;
	
	public Meeting(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public int compareTo(Meeting m) {
		if(this.endTime == m.endTime) {
			return this.startTime - m.startTime; // 시작 시간이 빠른 것
		}else return this.endTime - m.endTime;
	}
}
