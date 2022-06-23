package baekjoon.silver3;

import java.io.*;
import java.util.*;

public class Baekjoon_11478 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		Set<String> hs = new HashSet<String>();
	
		for(int i=0; i<str.length(); i++) {
			int count = i+1;
			
			for(int j=0; j+count<=str.length(); j++) {
				String subStr = str.substring(j, j+count);
				hs.add(subStr);
			}
		}
		
		System.out.println(hs.size());
	}

}
