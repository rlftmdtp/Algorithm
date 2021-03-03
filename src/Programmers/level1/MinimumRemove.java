package Programmers.level1;

import java.io.*;
import java.util.*;

public class MinimumRemove { // 제일 작은수 제거하기

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strSplit[] = br.readLine().split("\\s");
		int arr[] = new int[strSplit.length];
		for(int i=0; i<strSplit.length; i++) {
			arr[i] = Integer.parseInt(strSplit[i]);
		}
		
		solution(arr);
	}

	private static int[] solution(int[] arr) {
		// TODO Auto-generated method stub
		// 제일 작은 숫자 제거
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		// 배열에 존재하는 것 중 가장 작은 것
		int minIndex = 0;
		for(int i=0; i<arr.length; i++) {
			list.add(arr[i]);
			if(arr[i] < arr[minIndex]) minIndex = i;
		}
		list.remove(minIndex);
		
		
		int answer[] = new int[list.size()];
		if(list.size() == 0) {
			answer = new int[1];
			answer[0] = -1;
		}else {
			for(int i=0; i<list.size(); i++) {
				answer[i] = list.get(i);
			}
		}
		return answer;
	}

}
