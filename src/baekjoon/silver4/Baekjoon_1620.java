package baekjoon.silver4;

import java.io.*;
import java.util.*;

public class Baekjoon_1620 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strSplit[] = br.readLine().split(" ");
		int N = Integer.parseInt(strSplit[0]);
		int M = Integer.parseInt(strSplit[1]);
		
		// 번호 -> 이름, 이름 -> 번호
		HashMap<Integer, String> hm = new HashMap<>();
		HashMap<String, Integer> hm2 = new HashMap<>();
		for(int i=1; i<=N; i++) {
			String str = br.readLine();
			hm.put(i, str); // 숫자
			hm2.put(str, i); // 문자
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			
			// 숫자 문자 구분?
			if(hm2.containsKey(str)) {// 문자
				sb.append(hm2.get(str) + "\n");
			}else {
				sb.append(hm.get(Integer.parseInt(str)) + "\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}
