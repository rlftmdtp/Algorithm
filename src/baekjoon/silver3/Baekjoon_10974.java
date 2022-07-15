package baekjoon.silver3;

import java.util.*;
import java.io.*;

public class Baekjoon_10974 {
	public static List<String> result = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int list[] = new int[n];
		for(int i=0; i<list.length; i++) {
			list[i] = i+1;
		}
		// 순열
		perm(list,0);
		
		// System.out.println("---- 정답 ");
		Collections.sort(result);
		result.forEach(str -> System.out.println(str));
		
	}
	
	public static void perm(int list[],int depth) {
		if(depth == list.length) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<list.length; i++) {
				// System.out.print(list[i] + " ");
				sb.append(list[i] + " ");
			}
			result.add(sb.toString());
			
			// 정답을 사전순으로 한다
		}else {
			for(int i=depth; i<list.length; i++) {
				swap(i,depth,list);
				perm(list, depth+1);
				swap(i,depth,list);
			}
		}
	}
	
	public static void swap(int i, int j, int list[]) {
		int tmp = list[i];
		list[i] = list[j];
		list[j] = tmp;
	}

}
