package baekjoon.silver1;

import java.util.*;
import java.io.*;

public class Baekjoon_1697 {
	public static int N;
	public static int K;
	public static int TIME = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strSplit[] = br.readLine().split(" ");
		N = Integer.parseInt(strSplit[0]);
		K = Integer.parseInt(strSplit[1]);
		// 수빈이가 동생을 찾을 수 있는 가장 빠른 시간
		// 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동
		bfs(N);
		System.out.println(TIME);
	}
	
	public static void bfs(int start) {
		Queue<Hidden> q = new LinkedList<>();
		q.add(new Hidden(start, 0));
		
		while(!q.isEmpty()) {
			Hidden h = q.poll();
			
			if(h.index == K) {
				TIME = Math.min(h.time, TIME);
			}
			
			for(int i=0; i<3; i++) {
				if(i == 0) {
					h.index -= 1;
				}else if(i == 1) {
					h.index += 1;
				}else { // i == 2
					h.index *= 2;
				}
				
				// 범위 확인
				if(N<K) {
					if(h.index >-1 && h.index<=K) q.add(new Hidden(h.index, h.time+1)); 
				}else { // N>K
					if(h.index>-1 && h.index<=N) q.add(new Hidden(h.index, h.time+1)); 
				}
			}	
		}
	}

}

class Hidden{
	int index;
	int time;
	public Hidden(int index, int time) {
		this.index = index;
		this.time = time;
	}
}
