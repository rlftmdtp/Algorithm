package CodeUp.BinarySearch;

import java.util.*;
import java.io.*;

public class CodeUp_4766 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int list[] = new int[n];
		
		String strSplit[] = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			list[i] = Integer.parseInt(strSplit[i]);
		}
		
		int m = Integer.parseInt(br.readLine());
		Arrays.sort(list);
		int result = upperBoundary(list, m);
		System.out.println(result);
	}
	
	public static int upperBoundary(int list[], int search) {
		// 범위가 예산
		int start = 0;
		int end = list[list.length-1]+1;
		
		while(start < end) {
			int limit = (start+end) / 2;
			int sum = 0;
			
			for(int i=0; i<list.length; i++) {
				if(limit <= list[i]) sum += limit;
				else sum += list[i];
			}
			
			if(search < sum ) end = limit;
			else start = limit + 1;
			// System.out.println("전체 배정 결과 " + sum + " limi = " + limit + " end " + end + " start " + start);
		}
		
		return start-1;
	}

}
