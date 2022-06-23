package baekjoon.silver3;

import java.io.*;
import java.util.*;

public class Baekjoon_14425 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strSplit[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(strSplit[0]);
		int M = Integer.parseInt(strSplit[1]);
		
		Set<String> hs = new HashSet<>();
		for(int i=0; i<N; i++) {
			hs.add(br.readLine());
		}
		
		int result = 0;
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			if(hs.contains(str)) result++;
		}
		
		System.out.println(result);
	}

}
