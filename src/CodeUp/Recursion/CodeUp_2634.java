package CodeUp.Recursion;

import java.io.*;

public class CodeUp_2634 { // °Å½º¸§µ· 2
	public static int list[];
	public static int result[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int total = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		String strSplit[] = br.readLine().split("\\s");
		list = new int[n+1];
		result = new int[n+1][total+1];
		for(int i=1; i<=n; i++) {
			list[i] = Integer.parseInt(strSplit[i-1]);
		}
		
		System.out.println(coinCount(n, total));
	}

	private static int coinCount(int n, int total) {
		// TODO Auto-generated method stub
		for(int i=1; i<=n; i++) {
			for(int j=1; j <= total; j++) {
				if(list[i] >= j) result[i][j] = result[i-1][j];
				else {
					result[i][j] = Math.min(result[i-1][j], result[i-1][j-list[i]] + calculation(i,j));
				}
			}
		}
		return result[n][total];
	}

	private static int calculation(int n, int total) {
		// TODO Auto-generated method stub
		return total / list[n];
	}
	
	
}
