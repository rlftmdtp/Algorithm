package baekjoon.silver2;

import java.io.*;
import java.util.*;

public class Baekjoon_11047 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strSplit[] = br.readLine().split(" ");
		int N = Integer.parseInt(strSplit[0]);
		int K = Integer.parseInt(strSplit[1]);
		int wallet[] = new int[N];
		
		for(int i=0; i<N; i++) {
			int coin = Integer.parseInt(br.readLine());
			wallet[i] = coin;
		}
		
		int i = wallet.length-1;
		int total_count = 0;
		while(K != 0) {
			int coin = wallet[i--];
			
			if(K/coin != 0) {
				int count = K/coin;
				K -= coin * count;
				total_count += count;
				// System.out.println("count " + count + " K " + K + " total_count " + total_count);
			}
		}
		
		System.out.println(total_count);
	}

}
