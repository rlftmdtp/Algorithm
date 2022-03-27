package baekjoon.regex;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Baekjoon_2673 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();

		
		if(str.matches("(100+1+|01)+")) System.out.println("SUBMARINE");
		else System.out.println("NOISE");

	}

}
