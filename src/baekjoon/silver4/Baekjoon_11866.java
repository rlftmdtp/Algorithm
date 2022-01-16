package baekjoon.silver4;

import java.io.*;
import java.util.*;

public class Baekjoon_11866 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strSplit[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(strSplit[0]);
		int K = Integer.parseInt(strSplit[1]);
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=0; i<N; i++) {
			q.add(i+1);
		}
		
		int count = 1;
		List<Integer> result = new ArrayList<>();
		while(q.size() >= K) {
			if(count == K) {
				result.add(q.poll());
				count = 1;
			}else {
				q.add(q.poll());
				count++;
			}
		}
		while(!q.isEmpty()) {
			result.add(q.poll());
		}
		
		for(int i=0; i<result.size(); i++) {
			if(i == 0) System.out.print("<" + result.get(i) + ",");
			else if(i == result.size()-1) System.out.print(" " + result.get(i) + ">");
			else System.out.print(" " + result.get(i)+",");
		}
	}

}
