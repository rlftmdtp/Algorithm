package CodeUp.Recursion;

import java.io.*;

public class CodeUp_2699 { // 사투리 (LCS)

	public static char str1[];
	public static char str2[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str1 = br.readLine().toCharArray();
		str2 = br.readLine().toCharArray();
		
		System.out.println(lcs(str1.length, str2.length));
	}
	private static int lcs(int i, int j) {
		// TODO Auto-generated method stub
		int result[][] = new int[i+1][j+1];
		
		// 초기화
		for(int n=0; n<=i; n++) {
			result[n][0] = 0;
		}
		for(int m=0; m<=j; m++) {
			result[0][j] = 0;
		}
		//
		for(int n=0; n<i; n++) {
			for(int m=0; m<j; m++) {
				if(str1[n] == str2[m]) result[n+1][m+1] = result[n][m]+1;
				else result[n+1][m+1] = Math.max(result[n][m+1], result[n+1][m]);
			}
		}
		return result[i][j];
		
		// 재귀, 메모리제이션 방법 모두 시간초과
//		int result[][] = new int[i+1][j+1];
//		if(i == -1 || j == -1) return 0;
//		else if(result[i][j] != 0) return result[i][j];
//		else if(str1[i] == str2[j]) {
//			return result[i][j] = lcs(i-1, j-1) + 1;
//		}
//		else {
//			return result[i][j] = Math.max(lcs(i-1, j), lcs(i, j-1));
//		}
	}
	
}
