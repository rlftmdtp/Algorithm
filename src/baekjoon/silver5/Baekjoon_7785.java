package baekjoon.silver5;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Baekjoon_7785 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		HashSet<String> hs = new HashSet<String>();
		for(int i=0; i<N; i++) {
			String strSplit[] = br.readLine().split(" ");
			
			if(strSplit[1].equals("enter")) {
				hs.add(strSplit[0]);
			}else {
				hs.remove(strSplit[0]);
			}
		}
		
		
		
		// 사전 역순
		List<String> list = hs.stream().sorted((o1, o2) -> {
			return o1.compareTo(o2);
		}).collect(Collectors.toList());
		list.forEach(p -> System.out.println(p));
	
		Collections.sort(list, new Comparator<String>() {
		});
		
	}

}
