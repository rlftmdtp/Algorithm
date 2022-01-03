package CodeUp.Basic;

import java.io.*;
import java.util.*;

public class CodeUp_4726 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strSplit[] = br.readLine().split(" ");
		
		int K = Integer.parseInt(strSplit[1]);
		strSplit = br.readLine().split(" ");
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<strSplit.length; i++) {
			list.add(Integer.parseInt(strSplit[i]));
		}
		
		// KÀÏ ¸¸Å­
		int result = Integer.MIN_VALUE;
		for(int i=0; i<=list.size()-K; i++) {
			int sum = 0;
			for(int j=i; j<i+K; j++) {
				// System.out.println("i " + i + " j " + j);
				sum += list.get(j);
			}
			// System.out.println("sum " + sum);
			result = result<sum ? sum : result;
		}
		
		System.out.println(result);
	}

}
