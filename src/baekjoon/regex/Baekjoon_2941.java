package baekjoon.regex;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Baekjoon_2941 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		// 크로아티 알파벳과 그냥 알파벳
		Pattern p = Pattern.compile("c=|c-|dz=|d-|lj|nj|s=|z=|[a-z]");
		Matcher m = p.matcher(str);
		
		int count = 0;
		while(m.find()) {
			// System.out.println(m.group());
			count++;
		}
		System.out.println(count);
	}

}
