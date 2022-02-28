package baekjoon.silver4;

import java.io.*;
import java.util.*;

public class Baekjoon_2217 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int list[] = new int[N];
		for(int i=0; i<N; i++) {
			int w = Integer.parseInt(br.readLine());
			list[i] = w;
		}
		
		Arrays.sort(list);
		int max = 0;
		for(int i=0; i<list.length; i++) {
			int w = list[i] * (N-i);
			// System.out.println(w);
			if(w > max) max = w;
		}
		System.out.println(max);
	}

}
