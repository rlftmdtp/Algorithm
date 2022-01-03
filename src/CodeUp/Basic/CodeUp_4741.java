package CodeUp.Basic;

import java.io.*;

public class CodeUp_4741 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strSplit[] = br.readLine().split(" ");
		
		int A = Integer.parseInt(strSplit[0]);
		int B = Integer.parseInt(strSplit[1]);
		
		int C = Integer.parseInt(br.readLine());
		
		int m = (B+C)%60;
		A = A + (B+C)/60;
		int h = A%24;
		
		System.out.println(h + " " + m);
	}

}
