package baekjoon.gold4;

import java.io.*;
import java.util.*;

public class Beakjoon_7662 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<T; i++) {
			int k = Integer.parseInt(br.readLine());
			
			TreeSet<Integer> ts = new TreeSet<>();
			for(int j=0; j<k; j++) {
				String strSplit[] = br.readLine().split(" ");
				String input = strSplit[0];
				int n = Integer.parseInt(strSplit[1]);
				
				if(input.equals("I")) {
					ts.add(n);
				}else { // D 
					// 큐가 비어있을 때는 연산 무시하기
					if(!ts.isEmpty()) {
						if(n == 1) { // 큰값제거
							ts.remove(ts.last());
						}else { // -1
							ts.remove(ts.first());
						}
					}
				}
			}
			
			if(ts.isEmpty()) sb.append("EMPTY \n");
			else sb.append(ts.last() + " " + ts.first() + "\n");
		}
		System.out.println(sb.toString());
	}

}
