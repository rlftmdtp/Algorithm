package baekjoon.silver1;

import java.util.*;
import java.io.*;

public class Baekjoon_1074 {
	public static int R;
	public static int C;
	public static int COUNT = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strSplit[] = br.readLine().split(" ");
		int N = Integer.parseInt(strSplit[0]);
		R = Integer.parseInt(strSplit[1]);
		C = Integer.parseInt(strSplit[2]);
		
		int size = (int) Math.pow(2, N);
		// System.out.println(size);
		
		System.out.println(divide(0,0, size, size, size));
	}
	
	public static int divide(int startX, int startY, int endX, int endY, int size) {
		int result = 0;
		if(size/2 == 1) { // 탐색
			for(int i=startX; i<endX; i++) {
				for(int j=startY; j<endY; j++) {
					if(i == R && j == C) return COUNT;
					System.out.println("행 " + i + " 열 " + j + " COUNT " + COUNT);
					COUNT++;
				}
			}
		}else {
			int new_size = size/2;
			result = divide(startX, startY, startX+new_size, startY+new_size, new_size)
			+ divide(startX, startY+new_size, startX+new_size, endY, new_size)
			+ divide(startX+new_size, startY, endX, startY+new_size, new_size)
			+ divide(startX+new_size, startY+new_size, endX, endY, new_size);
		}
		// System.out.println("모든 것이 종료되었따...");
		return result;
	}

}
