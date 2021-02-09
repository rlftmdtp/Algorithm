package CodeUp.Recursion;

import java.io.*;

public class CodeUp_4564 { // 계단 오르기
	public static int stair[];
	public static int result[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		stair = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			stair[i] = Integer.parseInt(br.readLine()); 
		}
		
		upStair(n);
		System.out.println(result[n]);
	}

	private static void upStair(int n) {
		// TODO Auto-generated method stub
		// 3번째 계단까지는 강제 초기화
		result = new int[n+1];
		for(int i=1; i<=n; i++) {
			if(i ==1) result[1] = stair[1];
			else if(i == 2) result[2] = stair[1] + stair[2];
			else if(i == 3) result[3] = compare(stair[2] + stair[3], stair[1] + stair[3]);
			else {
				result[i] = compare(stair[i] + stair[i-1] + result[i-3], stair[i] + result[i-2]);
			}
		}
	}

	private static int compare(int a, int b) {
		// TODO Auto-generated method stub
		if(a>b) return a;
		else return b;
	}

}
