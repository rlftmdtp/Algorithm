package baekjoon.gold4;

import java.io.*;
import java.util.*;

public class Baekjoon_1062 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strSplit[] = br.readLine().split(" ");
		int N = Integer.parseInt(strSplit[0]);
		int K = Integer.parseInt(strSplit[1]);
		
		if(K < 5) {
			System.out.println(0);
		}else {
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				String temp = str.substring(3, str.length()-4);
				String result = temp.replaceAll("[antic]", "");
				
				System.out.println(temp + " " + result);
			}
		}
	
	}
}
