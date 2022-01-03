package CodeUp.Basic;

import java.io.*;
import java.util.*;

public class CodeUp_4891 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String strSplit[] = br.readLine().split(" ");
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<strSplit.length; i++) {
			list.add(Integer.parseInt(strSplit[i]));
		}
		
		Collections.sort(list);
		System.out.println(list.get(list.size()-1) - list.get(0));
	}

}
