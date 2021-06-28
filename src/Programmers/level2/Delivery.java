package Programmers.level2;

import java.util.*;

public class Delivery {
	public static List<Town> list[];
	public static int d[];
	public static boolean visited[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int road[][] = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		int N = 5;
		int K = 3;
		System.out.println(solution(N, road, K));
	}
	
    public static int solution(int N, int[][] road, int K) {
        int answer = 0;

        //  road를 이용해서 인접리스트를 생성해야한다
        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
        	list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<road.length; i++) {

        		int t = road[i][0];
        		//System.out.println(t + " 에서 " +  road[i][1] + " 까지 거리 " + road[i][2]);
        		list[t].add(new Town(road[i][1], road[i][2]));
        	
        }
        
        // bfs 시작
        bfs(1);
        
        for(int i=2; i<d.length; i++) {
        	if(d[i] <= K && visited[i] == true) answer++;
        }
        
        return answer;
    }

	private static void bfs(int start) {
		// TODO Auto-generated method stub
		
		// 초기화
		d = new int[list.length];
		for(int i=1; i<d.length; i++) {
			d[i] = Integer.MAX_VALUE;
		}
		d[start] = 0;
		
		visited = new boolean[list.length];
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			int t = q.poll();
			System.out.println("q.poll " + t);
			System.out.println("list[t].size() " + list[t].size());
			for(int i=0; i<list[t].size(); i++) {
				Town town = list[t].get(i);
				System.out.println(t + "지점에서 " + town.n + "까지 거리는 " + town.distance);
				if(d[town.n] > d[t] + town.distance) {
					System.out.println("d[town.n] = d[t] + town.distance " + "d[town.n] = " + (d[t] + town.distance));
					d[town.n] = d[t] + town.distance;
					visited[town.n] = true;
					q.add(town.n);
					System.out.println(town.n);
				}
			}
		}
		
	}
    
    

}

class Town{
	int n;
	int distance;
	
	public Town(int n, int distance) {
		super();
		this.n = n;
		this.distance = distance;
	}
		
}
