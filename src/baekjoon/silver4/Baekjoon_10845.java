package baekjoon.silver4;

import java.io.*;
import java.util.*;

public class Baekjoon_10845 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		MaekQueue q = new MaekQueue();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			String strSplit[] = br.readLine().split(" ");
			
			if(strSplit.length == 2) {
				q.push(Integer.parseInt(strSplit[1]));
			}else {
				if(strSplit[0].equals("pop")) {
					sb.append(q.pop() + "\n");
				}else if(strSplit[0].equals("size")) {
					sb.append(q.size() + "\n");
				}else if(strSplit[0].equals("empty")) {
					sb.append(q.empty() + "\n");
				}else if(strSplit[0].equals("front")) {
					sb.append(q.front() + "\n");
				}else { // back
					sb.append(q.back() + "\n");
				}
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static class MaekQueue{
		int head = 0;
		int tail = 0;
		int list[] = new int[10001];
		
		public void push(int put) {
			list[tail++] = put;
		}
		
		public int pop() {
			if(tail - head == 0) return -1;
			else return list[head++];
		}
		
		public int size() {
			return tail-head;
		}
		
		public int empty() {
			if(tail - head == 0) return 1;
			else return 0;
		}
		
		public int front() {
			if(tail - head == 0) return -1;
			else return list[head];
		}
		
		public int back() {
			if(tail - head == 0) return -1;
			else return list[tail-1];
		}
	}

}
