package CodeUp.Basic;

import java.io.*;
import java.util.*;

public class CodeUp_7576 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int MAX = 0;
		int current = 0;
		int input = 0;
		int output = 0;
		for(int i=0; i<4; i++) {
			String strSplit[] = br.readLine().split(" ");
			output = Integer.parseInt(strSplit[0]);
			input = Integer.parseInt(strSplit[1]);
			if(i == 0) {
				MAX = input;
				current = input;
			}
			else {
				current = current + input - output;
				MAX = Math.max(current, MAX);
			}
		}
		System.out.println(MAX);
	}

}
