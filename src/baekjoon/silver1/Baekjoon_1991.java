package baekjoon.silver1;

import java.util.*;
import java.io.*;

public class Baekjoon_1991 {
	public static HashMap<String, List<String>> tree = new HashMap<>();
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			String strSplit[] = br.readLine().split(" ");
			String vertex = strSplit[0];
			String left = strSplit[1];
		    String right = strSplit[2];
			
		    List<String> list = new ArrayList<>();
		    list.add(left);
		    list.add(right);
		    
		    tree.put(vertex, list);
		}
		
		preOrder("A");
		sb.append("\n");
		
		inOrder("A");
		sb.append("\n");
		
		postOrder("A");
		sb.append("\n");
		
		System.out.println(sb);
	}
	
	public static void preOrder(String vertex) {
		sb.append(vertex);
		List<String> list = tree.get(vertex);
		if(!list.get(0).equals(".")) preOrder(list.get(0));
		if(!list.get(1).equals(".")) preOrder(list.get(1));
	}
	
	public static void inOrder(String vertex) {
		List<String> list = tree.get(vertex);
		if(!list.get(0).equals(".")) inOrder(list.get(0));
		sb.append(vertex);
		if(!list.get(1).equals(".")) inOrder(list.get(1));
	}
	
	public static void postOrder(String vertex) {
		List<String> list = tree.get(vertex);
		

		if(!list.get(0).equals(".")) postOrder(list.get(0));
		if(!list.get(1).equals(".")) postOrder(list.get(1));
		sb.append(vertex);
	}

}
