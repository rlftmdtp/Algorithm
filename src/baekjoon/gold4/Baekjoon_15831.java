package baekjoon.gold4;

import java.io.*;
import java.util.*;


public class Baekjoon_15831 { // 즌표의 조약돌

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strSplit[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(strSplit[0]);
		int B = Integer.parseInt(strSplit[1]);
		int W = Integer.parseInt(strSplit[2]);
		
		String list[] = new String[n];
		String str = br.readLine();
		for(int i=0; i<str.length(); i++) {
			list[i] = str.charAt(i) + "";
		}
		
		System.out.println(twoPointer(list,B,W));
	}

	private static int twoPointer(String[] list, int b, int w) {
		// TODO Auto-generated method stub
		int st = 0;
		int en = 0;
		int result = 0;
		int count_b = 0;
		int count_w = 0;
		
		while(en<=list.length) {
			
			if(count_b <= b && count_w >= w) result = Math.max(en-st, result);
			if(en == list.length) break;
			
			
			if(count_b <= b) {
				if(list[en].equals("B")) count_b++;
				else count_w++;
				en++;	
			}else { // b > count_b
				if(list[st].equals("B")) count_b--;
				else count_w--;
				st++;
			}
			
		}
		// System.out.println("result = "  + result);
		return result;
	}

}
