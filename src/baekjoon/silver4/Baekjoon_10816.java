package baekjoon.silver4;

import java.util.*;
import java.io.*;

public class Baekjoon_10816 {
	public static int findArray[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		findArray = new int[N];

		String strSplit[] = br.readLine().split(" ");
		for (int j = 0; j < strSplit.length; j++) {
			findArray[j] = Integer.parseInt(strSplit[j]);
		}
		Arrays.sort(findArray);
		
		N = Integer.parseInt(br.readLine());
		int array[] = new int[N];
		strSplit = br.readLine().split(" ");
		for (int j = 0; j < strSplit.length; j++) {
			array[j] = Integer.parseInt(strSplit[j]);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<array.length; i++) {
			int search = array[i];
			sb.append(upper(0, findArray.length, search) - lower(0, findArray.length, search) + " ");
		}
		
		System.out.println(sb);
	}
	
	public static int upper(int start, int end, int search) {
		while(start < end) {
			int mid = (start + end) / 2;
			if(search < findArray[mid]) {
				end = mid;
			}else {
				start = mid + 1;
			}
		}
		return start;
	}
	
	public static int lower(int start, int end, int search) {
		while(start < end) {
			int mid = (start+end) / 2;
			if(search <= findArray[mid]) {
				end = mid;
			}else {
				start = mid + 1;
			}
		}
		return start;
	}

}
