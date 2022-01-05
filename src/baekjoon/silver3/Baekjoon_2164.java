package baekjoon.silver3;

import java.util.*;
import java.io.*;

public class Baekjoon_2164 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		
		while(q.size() != 1) {
			
			// 맨 위에 것 버리고
			q.poll();
			
			// 그 다음 위에거를 맨뒤로
			int top2 = q.poll();
			q.add(top2);
		}
		
		System.out.println(q.peek());
	}

}
