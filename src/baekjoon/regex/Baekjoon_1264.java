package baekjoon.regex;

import java.io.*;
import java.util.*;

public class Baekjoon_1264 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			String str = br.readLine();
			
			if(str.equals("#")) break;
			// 모음의 개수?
			int count = 0;
			for(int i=0; i<str.length(); i++) {
				String one_str = str.charAt(i)+"";
				if(one_str.matches("[aeiouAEIOU]")) count++;
			}
			sb.append(count + "\n");
		}
		System.out.println(sb.toString());
	}

}
