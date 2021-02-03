package CodeUp.Recursion;

import java.io.*;

public class CodeUp_1930 { // SuperSum 
	public static int memorization[][]; // 메모리제이션 변수
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		
		while((input = br.readLine()) != null) {
			String[] strSplit = input.split("\\s");
			int k = Integer.parseInt(strSplit[0]);
			int n = Integer.parseInt(strSplit[1]);
			
			memorization = new int[k+1][n+1];
			int result = superSum(k, n);
			System.out.println(result);
		}
	}

	private static int superSum(int k, int n) {
		// TODO Auto-generated method stub
		if(k == 0) return n;
		else if(memorization[k][n] != 0) return memorization[k][n];
		else {
			for(int i=1; i<=n; i++) {
				memorization[k][n] += superSum(k-1, i);
			}
			return memorization[k][n];
		}
	}

}
