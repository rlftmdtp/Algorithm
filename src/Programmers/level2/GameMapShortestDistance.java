package Programmers.level2;

import java.util.*;

public class GameMapShortestDistance {
	public static int d[][];
	public static int m;
	public static int n;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		System.out.println(solution(maps));
	}
	
    public static int solution(int[][] maps) {
        int answer = 0;
        
        Node startNode = new Node(0, 0);
    	m = maps.length;
    	n = maps[0].length;
    	System.out.println("m " + m + " " + n);
        bfs(maps, startNode);
        
        return d[m-1][n-1];
    }
    
    private static void bfs(int[][] maps, Node startNode) {

		// 최단거리 변수
    	d = new int[m][n];
    	
    	// 초기화
    	for(int i=0; i<m; i++) {
    		for(int j=0; j<n; j++) {
    			d[i][j] = -1;
    		}
    	}
    	d[startNode.x][startNode.y] = 1;
    	Queue<Node> q = new LinkedList<>();
    	q.add(startNode);
    	
    	int x[] = {-1,0,1,0};
    	int y[] = {0,1,0,-1};
   
    	while(!q.isEmpty()) {
    		Node node = q.poll();
    		for(int i=0; i<4; i++) { // 4개 방향 탐색
    			if(node.x+x[i]<0 || node.y+y[i]<0 || node.x+x[i]>=m || node.y+y[i]>=n) continue; // 지도 밖을 벗어날 경우
    			else if(d[node.x+x[i]][node.y+y[i]] == -1 && maps[node.x+x[i]][node.y+y[i]] != 0 ) { // 방문한 적이 없으며 막힌 지도가 아닐 경우
    				d[node.x+x[i]][node.y+y[i]] = d[node.x][node.y] + 1;
    				q.add(new Node(node.x+x[i], node.y+y[i]));
    			}

    		}
    	}
	}
}

class Node{
	int x;
	int y;
	public Node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
