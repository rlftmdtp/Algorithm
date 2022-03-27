package baekjoon.regex;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Baekjoon_2857 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<Integer> list = new ArrayList<>();
		for(int i=1; i<=5; i++) {
			String str = br.readLine();
			
			if(str.matches(".*FBI.*")) list.add(i);
		}
		
		if(list.size() != 0) {
			for(int i : list) System.out.println(i);
		}
		else System.out.println("HE GOT AWAY!");
	}

}
