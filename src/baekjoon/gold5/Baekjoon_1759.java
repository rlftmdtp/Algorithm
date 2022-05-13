package baekjoon.gold5;

import java.io.*;
import java.util.*;

public class Baekjoon_1759 {
	public static List<String> result = new ArrayList<>();
	public static List<String> voewl = new ArrayList<>();
	public static List<String> answer = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strSplit[] = br.readLine().split(" ");
		int L = Integer.parseInt(strSplit[0]);
		int C = Integer.parseInt(strSplit[1]);
		
		voewl.add("a");
		voewl.add("e");
		voewl.add("i");
		voewl.add("o");
		voewl.add("u");
		
		List<String> list = new ArrayList<>();
		strSplit = br.readLine().split(" ");
		for(int i=0; i<C; i++) {
			list.add(strSplit[i]);
		}
		
		Collections.sort(list);
		
		combi(list, 0, L);
		answer.forEach(s -> System.out.println(s));
	}
	
	public static void combi(List<String> list, int depth, int r) {
		if(r == 0) {
			// 자음 모음 개수 확인
			int a = 0;
			int b = 0;
			
			for(int i=0; i<result.size(); i++) {
				if(voewl.contains(result.get(i))) a++;
				else b++;
			}
			
			StringBuilder sb = new StringBuilder();
			if(a >= 1 && b>=2) {
				result.forEach(s -> sb.append(s));
				answer.add(sb.toString());
			}
		}else if(depth == list.size()) return;
		else {
			result.add(list.get(depth));
			combi(list, depth+1, r-1); // 선택
			
			result.remove(result.size()-1);
			combi(list, depth+1, r); // 미선택
		}
	}

}
