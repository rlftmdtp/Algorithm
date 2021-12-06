package baekjoon.bronze;

import java.util.*;
import java.io.*;

public class Baekjoon_2231 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N; i++) {
			int sum = i;
			int temp = i;
			while(temp != 0) {
				System.out.println("sum " + sum + " temp " + temp);
				sum += temp%10;
				temp = temp/10;
			}
			
			if(sum == N) {
				System.out.println(i);
				break;
			}
		}
	}

}
