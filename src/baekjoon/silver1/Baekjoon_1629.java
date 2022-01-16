package baekjoon.silver1;

import java.io.*;
import java.util.*;

public class Baekjoon_1629 {
	public static int result[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strSplit[] = br.readLine().split(" ");
		int A = Integer.parseInt(strSplit[0]);
		int B = Integer.parseInt(strSplit[1]);
		// int C = Integer.parseInt(strSplit[2]);
		result = new int[B+1];
		
		System.out.println(divide(A, B));
	}
	
	public static int divide(int n, int sq) {
		if(sq == 1) {
			return n;
		}else if(result[sq] != 0) return result[sq];
		else {
			if(sq%2 == 0) { // Â¦¼ö
				result[sq] = divide(n, sq/2) * divide(n, sq/2);
			}else {	// È¦¼ö
				result[sq] = divide(n, sq/2) * divide(n, sq/2) * n;
			}
		}
		return result[sq];
	}

}
