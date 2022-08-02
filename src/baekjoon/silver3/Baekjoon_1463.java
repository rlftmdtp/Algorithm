package baekjoon.silver3;

import java.io.*;
import java.util.*;

public class Baekjoon_1463 {
	public static int operator[] = { 3, 2, 1 };
	public static int memorization[];

	public static class Point {
		int x;
		int count;

		public Point(int x, int count) {
			this.x = x;
			this.count = count;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// System.out.println(bfs(N)); bfs방식
		int dp[] = new int[N + 1];
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + 1;
			if (i % 2 == 0)
				dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
			if (i % 3 == 0)
				dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
		}
		System.out.println(dp[N]);

	}

	public static int bfs(int n) {
		Queue<Point> q = new LinkedList<Point>();
		boolean visitied[] = new boolean[n + 1];
		q.add(new Point(n, 0));
		visitied[n] = true;

		int result = 0;
		while (!q.isEmpty()) {
			Point p = q.poll();

			if (p.x == 1) {
				result = p.count;
				break;
			}
			// 연산 세가지
			for (int i = 0; i < 3; i++) {
				// System.out.println("x " + p.x + " p.count " + p.count);
				if (i == 0 && p.x % operator[i] == 0) {
					if (visitied[p.x / operator[i]] == false) {
						visitied[p.x / operator[i]] = true;
						q.add(new Point(p.x / operator[i], p.count + 1));
					}
				} else if (i == 1 && p.x % operator[i] == 0) {
					if (visitied[p.x / operator[i]] == false) {
						visitied[p.x / operator[i]] = true;
						q.add(new Point(p.x / operator[i], p.count + 1));
					}
				} else if (i == 2 && p.x - operator[i] >= 0) {
					if (visitied[p.x - operator[i]] == false) {
						visitied[p.x - operator[i]] = true;
						q.add(new Point(p.x - operator[i], p.count + 1));
					}
				}
			}
		}
		// System.out.println("정답 " + result);
		return result;
	}

}
