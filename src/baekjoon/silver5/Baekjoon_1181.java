package baekjoon.silver5;

import java.io.*;
import java.util.*;

public class Baekjoon_1181 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		HashSet<String> hs = new HashSet<>();
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			hs.add(str);
		}
		
		List<String> list = new ArrayList<>();
		Iterator<String> it = hs.iterator();
		while(it.hasNext()) {
			list.add(it.next());
		}
		
		Collections.sort(list, new Comparator<>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}else return o1.length() - o2.length();
			}
			
		});
		
		StringBuilder sb = new StringBuilder();
		for(String str : list) {
			sb.append(str + "\n");
		}
		System.out.println(sb);
	}

}
