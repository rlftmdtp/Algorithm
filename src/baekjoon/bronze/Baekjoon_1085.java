package baekjoon.bronze;

import java.io.*;
import java.util.*;

public class Baekjoon_1085 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strSplit[] = br.readLine().split(" ");
		int x = Integer.parseInt(strSplit[0]);
		int y = Integer.parseInt(strSplit[1]);
		int w = Integer.parseInt(strSplit[2]);
		int h = Integer.parseInt(strSplit[3]);
		
		// 경계선까지의 거리 최소값 구하기
		int distance_x = Math.min(x-0, w-x);
		int distance_y = Math.min(y-0, h-y);
		int result = Math.min(distance_x, distance_y);
		System.out.println(result);
	}

}
