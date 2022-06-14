package baekjoon.silver4;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Baekjoon_1764 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strSplit[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(strSplit[0]);
		int m = Integer.parseInt(strSplit[1]);
		int sum = n+m;
		
		HashMap<String, Integer> hm = new HashMap<>();
		for(int i=0; i<sum; i++) {
			String name = br.readLine();
			hm.put(name, hm.getOrDefault(name, 0) + 1);
		}
		
		List<String> list = hm.entrySet()
			.stream()
			.filter(hashMap -> hashMap.getValue() >= 2)
			.map(hashMap -> hashMap.getKey())
			.sorted()
			.collect(Collectors.toList());
		
		System.out.println(list.size());
		list.forEach(name -> System.out.println(name));
	}

}
