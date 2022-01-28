package baekjoon.silver2;

import java.io.*;
import java.util.*;

public class Baekjoon_11279 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// , x�� 0�̶�� �迭���� ���� ū ���� ����ϰ� �� ���� �迭���� �����ϴ� ����̴�. �ԷµǴ� �ڿ����� 231���� �۴�
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if(input == 0) {
				if(pq.isEmpty()) sb.append("0 \n");
				else sb.append(pq.poll() + "\n");
			}else {
				pq.add(input);
			}
		}

		System.out.println(sb);
	}

}
