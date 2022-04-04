package baekjoon.bronze;

import java.io.*;
import java.util.*;

public class Baekjoon_1259 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			String str = br.readLine();
			if(str.equals("0")) break;
			
			// 펠린드롬수인지 확인
			StringBuffer sf = new StringBuffer();
			sf.append(str);
			sf.reverse();
			
			if(str.equals(sf.toString())) sb.append("yes \n");
			else sb.append("no \n");
		}
		
		System.out.println(sb.toString());
	}

}
