package baekjoon.bronze;

import java.io.*;

public class Baekjonn_2231 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int result = 0;
		int start = 1;
		while(start < N) {
			int sum = start;
			int temp = start;
			while(temp != 0) {
				sum += temp%10;
				temp = temp/10;
			}
			
			// System.out.println("start " + start + " sum " + sum);
			if(sum == N) {
				result = start;
				break;
			}
			
			start++;
		}
		
		System.out.println(result);
	}

}
