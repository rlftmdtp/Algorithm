package baekjoon.silver3;

import java.io.*;
import java.util.*;

public class Baekjoon_1269 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<String, Integer> hm = new HashMap<>();
		String strSplit[] = br.readLine().split(" ");
		for(int i=0; i<2; i++) {
			strSplit = br.readLine().split(" ");
			
			for(int j=0; j<strSplit.length; j++) {
				hm.put(strSplit[j], hm.getOrDefault(strSplit[j], 0) + 1);
			}
		}

		// 1개 인것만
		int result = (int) hm.entrySet()
			.stream()
			.filter(set -> set.getValue() == 1)
			.count();
		
		System.out.println(result);
			
	}

}
