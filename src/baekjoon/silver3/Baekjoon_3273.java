package baekjoon.silver3;

import java.util.*;
import java.io.*;

public class Baekjoon_3273 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int list[] = new int[n];
		String strSplit[] = br.readLine().split(" ");
		for(int i=0; i<list.length; i++) {
			list[i] = Integer.parseInt(strSplit[i]);
		}
		int x = Integer.parseInt(br.readLine());
		Arrays.sort(list);
		
		System.out.println(twoPointer(list, x));
	}
	
	public static int twoPointer(int[] list, int search) {
		int result = 0;
		
		int start = 0;
		int end = list.length-1;
		while(start < end) {
			if(list[start] + list[end] == search) result++;
			
			if(list[start] + list[end] < search) start++;
			else end--;
		}
		return result;
	}

}
