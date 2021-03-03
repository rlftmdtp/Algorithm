package Programmers.level1;

import java.io.*;
import java.util.*;


public class HateSameNumber { // 같은 숫자는 싫어

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] splitStr = br.readLine().split("\\s");
		int arr[] = new int[splitStr.length];
		for(int i=0; i<splitStr.length; i++) {
			arr[i] = Integer.parseInt(splitStr[i]);
		}
		
		solution(arr);
	}

	private static int[] solution(int[] arr) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		// 초기화
		list.add(arr[0]);
		for(int i=1; i<arr.length; i++) {
			if(arr[i-1] != arr[i]) list.add(arr[i]);
		}
		
		int answer[] = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}

}
