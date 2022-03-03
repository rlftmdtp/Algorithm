package CodeUp.BinarySearch;

import java.util.*;
import java.io.*;

public class CodeUp_3002 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int list[] = new int[n];
		for(int i=0; i<n; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		
		int m = Integer.parseInt(br.readLine());
		int ask[] = new int[m];
		for(int i=0; i<m; i++) {
			ask[i] = Integer.parseInt(br.readLine());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<ask.length; i++) {
			sb.append(binarySearch(list, ask[i]) + " ");
		}
		System.out.println(sb.toString());
		
	}
	
	public static int binarySearch(int list[], int search) {
		// 그 숫자의 위치 리턴
		int start = 0;
		int end = list.length-1;
		
		while(start <= end) {
			// System.out.println("start " + start + " end " + end);
			int mid = (start+end+1)/2;
			if(search == list[mid]) return mid+1;
			else if(search < list[mid]) end = mid-1;
			else start = mid+1;
		}
		
		return -1;
	}

}
