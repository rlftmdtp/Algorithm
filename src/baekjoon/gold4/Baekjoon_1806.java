package baekjoon.gold4;

import java.util.*;
import java.io.*;

public class Baekjoon_1806 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strSplit[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(strSplit[0]);
		int S = Integer.parseInt(strSplit[1]);
		int list[] = new int[N];
		strSplit = br.readLine().split(" ");
		for(int i=0; i<list.length; i++) {
			list[i] = Integer.parseInt(strSplit[i]);
		}
		
		int result = twoPointer(list, S);
		if(result == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(result);	
	}
	
	public static int twoPointer(int list[], int s) {
		int st = 0;
		int en = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		while(true) {
			
			// 마지막까지 st를 계산해야한다
			if(sum >= s) {
				min = Math.min(min, en-st);
				sum -= list[st++];
			}
			else if(en == list.length) break;
			else { // sum < S
				sum += list[en++];
			}
		}
		// System.out.println(min);
		return min;
	}

}
