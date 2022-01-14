package baekjoon.silver5;

import java.util.*;
import java.io.*;

public class Baekjoon_11651 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		List<Position2> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			String strSplit[] = br.readLine().split(" ");
			int x = Integer.parseInt(strSplit[0]);
			int y = Integer.parseInt(strSplit[1]);
			list.add(new Position2(x, y));
		}
		
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for(Position2 p : list) {
			sb.append(p.x + " " + p.y + "\n");
		}
		System.out.println(sb);
	}

}

class Position2 implements Comparable<Position2>{
	int x;
	int y;
	public Position2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int compareTo(Position2 p) {
		// x 좌표 오름차순
		if(this.y == p.y) {
			return this.x - p.x;
		}else return this.y - p.y;
	}
}
