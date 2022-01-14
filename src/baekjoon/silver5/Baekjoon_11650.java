package baekjoon.silver5;

import java.util.*;
import java.io.*;

public class Baekjoon_11650 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		List<Position> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			String strSplit[] = br.readLine().split(" ");
			int x = Integer.parseInt(strSplit[0]);
			int y = Integer.parseInt(strSplit[1]);
			list.add(new Position(x, y));
		}
		
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for(Position p : list) {
			sb.append(p.x + " " + p.y + "\n");
		}
		System.out.println(sb);
	}

}

class Position implements Comparable<Position>{
	int x;
	int y;
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int compareTo(Position p) {
		// x 좌표 오름차순
		if(this.x == p.x) {
			return this.y - p.y;
		}else return this.x - p.x;
	}
}
