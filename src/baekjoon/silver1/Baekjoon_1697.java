package baekjoon.silver1;

import java.util.*;
import java.io.*;

public class Baekjoon_1697 {
	public static int N;
	public static int K;
	public static int LIMIT = 0;
	public static int visitied[];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strSplit[] = br.readLine().split(" ");
		N = Integer.parseInt(strSplit[0]);
		K = Integer.parseInt(strSplit[1]);
		LIMIT = Math.max(N, K);
		visitied = new int[LIMIT+1];
		// �����̰� ������ ã�� �� �ִ� ���� ���� �ð�
		// 1�� �Ŀ� X-1 �Ǵ� X+1�� �̵��ϰ� �ȴ�. �����̵��� �ϴ� ��쿡�� 1�� �Ŀ� 2*X�� ��ġ�� �̵�
		System.out.println(bfs(N));
	}
	
	public static int bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visitied[start] = 1;

		while (!q.isEmpty()) {
			int index = q.poll();

			if (index == K)
				return visitied[index]-1;

			for (int i = 0; i < 3; i++) {
				int next_index = 0;
				if (i == 0)
					next_index = index + 1;
				else if (i == 1)
					next_index = index - 1;
				else
					next_index = index * 2;

				// ���� Ȯ��
				if (next_index >= 0 && next_index <= LIMIT){
					if (visitied[next_index] == 0) {
						System.out.println("next_index " + next_index);
						visitied[next_index] = visitied[index] + 1;
						q.add(next_index);
					}
				}
			}
		}
		return -1;
	}
	
}

