package baekjoon.silver3;

import java.io.*;
import java.util.*;

public class Baekjoon_1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			String strSplit[] = br.readLine().split(" ");
			String strSplit2[] = br.readLine().split(" ");
			
			int size = Integer.parseInt(strSplit[0]);
			int find = Integer.parseInt(strSplit[1]);
			
			Queue<Print> q = new LinkedList<>();
			for(int j=0; j<size; j++) {
				q.add(new Print(j, Integer.parseInt(strSplit2[j])));
			}
			
			sb.append(findPrint(q, find) + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int findPrint(Queue<Print> q, int find) {
		int count = 0; // �����λ����°�
		while(!q.isEmpty()) {
			Print p = q.poll();
			
			// �ڿ� �� �߿��� ���� �ִ��� Ȯ��
			boolean flag = true;
			int size = q.size();
			// ��ü�˻�
			for(int i=0; i<size; i++) {
				Print p2 = q.poll();
				if(p.priority < p2.priority) flag = false;
				q.add(p2);
			}
			
			if(flag) {
				// ����Ʈ �μ� ����
				count++;
				if(p.index == find) return count;
			}else {
				// �� �ڷ� �̵�
				q.add(p);
			}
		}
		return -1;
	}
	
	public static class Print{
		int index;
		int priority;
		
		public Print(int index, int priority) {
			this.index = index;
			this.priority = priority;
		}
	}

}
