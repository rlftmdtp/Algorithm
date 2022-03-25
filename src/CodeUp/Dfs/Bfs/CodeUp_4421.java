package CodeUp.Dfs.Bfs;

import java.io.*;
import java.util.*;

public class CodeUp_4421 {
	public static int MAP[][];
	public static boolean visitied[][];
	public static int direct_x[] = {0, 1, 0 , -1};
	public static int direct_y[] = {1, 0, -1, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		MAP = new int[n][n];
		visitied = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			String strSplit[] = br.readLine().split("");
			for(int j=0; j<n; j++) {
				MAP[i][j] = Integer.parseInt(strSplit[j]);
			}
		}
		
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {	
				if(MAP[i][j] == 1 && visitied[i][j] == false) list.add(bfs(i,j));
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y));
		visitied[x][y] = true;
		
		int count = 1;
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			for(int i=0; i<4; i++) {
				int new_x = n.x + direct_x[i];
				int new_y = n.y + direct_y[i];
				
				// ¸ÊÀÇ Å©±â
				if(new_x >= 0 && new_x<MAP.length && new_y >= 0 && new_y < MAP.length) {
					if(MAP[new_x][new_y] == 1 && visitied[new_x][new_y] == false) {
						visitied[new_x][new_y] = true;
						q.add(new Node(new_x, new_y));
						count++;
					}
				}
			}
		}
		
		// System.out.println(count);
		return count;
	}
	
	public static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
