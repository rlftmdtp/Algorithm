package baekjoon.regex;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Baekjoon_1543 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String find_str = br.readLine();
		
		Pattern p = Pattern.compile(find_str);
		Matcher m = p.matcher(str);
		
		int count = 0;
		while(m.find()) {
			count++;
		}
		System.out.println(count);
	}

}
