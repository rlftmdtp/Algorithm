package baekjoon.regex;

import java.io.*;
import java.util.*;

public class Baekjoon_1013 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			
			if(str.matches("(100+1+|01)+")) sb.append("YES \n");
			else sb.append("NO \n");
		}
		System.out.println(sb.toString());
	}

}
