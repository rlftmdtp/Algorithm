package CodeUp.Basic;

import java.io.*;

public class CodeUp_4041 { // 숫자 다루기

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		n = deleteZero(n);
		reberseNumberPluse(n, 0);
	}

	private static void reberseNumberPluse(int n, int pluseNumber) {
		// TODO Auto-generated method stub
		if(n/10 == 0) {
			System.out.println(n%10);
			System.out.println(pluseNumber + n%10);
		}else {
			System.out.print(n%10);
			reberseNumberPluse(n/10, pluseNumber + n%10);
		}
	}

	private static int deleteZero(int n) {
		// TODO Auto-generated method stub
		if(n%10 != 0) return n;
		else
			return deleteZero(n/10);
	}

}
