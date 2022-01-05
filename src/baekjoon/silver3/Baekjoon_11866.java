package baekjoon.silver3;

import java.io.*;
import java.util.*;

public class Baekjoon_11866 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strSplit[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(strSplit[0]);
		int K = Integer.parseInt(strSplit[1]);
		
		List<Integer> result = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		
		int count = 0;
		while(q.size() >= K) {
			count++;

			int n = q.poll();
			if(count%K == 0) {
				result.add(n);
				count = 0;
			}
			else q.add(n);
		}
		
		while(!q.isEmpty()) result.add(q.poll());
		
		
		for(int i=0; i<result.size(); i++) {
			if(i == 0) System.out.print("<"+result.get(i)+", ");
			else if(i == result.size()-1) System.out.print(result.get(i)+">");
			else System.out.print(result.get(i) + ", ");
		}
	}

}
