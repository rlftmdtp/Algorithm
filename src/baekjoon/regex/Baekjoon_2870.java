package baekjoon.regex;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Baekjoon_2870 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			
			// 숫자를 찾아서 넣는다
			Pattern p = Pattern.compile("[0-9]+");
			Matcher m = p.matcher(str);
			
			while(m.find()) {
				list.add(Integer.parseInt(m.group()));
			}
		}
		
		Collections.sort(list);
		for(int i : list) {
			System.out.println(i);
		}
	}

}
