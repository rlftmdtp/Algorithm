package CodeUp.Basic;

import java.io.*;
import java.util.*;

public class CodeUp_4776 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] list1 = {0,1,2,3,4,5,6,7,8,9};
		String[] list2 = {"A","B","C","D","E","F","G","H","I","J","K","L"};
		
		// System.out.println("N " + N);
		int index1 = (N+6)%10;
		int index2 = (N+8)%12;

		String result = list2[index2] + list1[index1] + "";
		System.out.println(result);
	}

}
