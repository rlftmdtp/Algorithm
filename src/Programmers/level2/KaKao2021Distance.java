package Programmers.level2;

import java.util.*;

public class KaKao2021Distance {
	public static int directX[] = {1,0,-1,0};
	public static int directY[] = {0,1,0,-1};
	public static class Pos{
		int x;
		int y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
				{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		
		solution(places);
	}
	
    public static int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        // 각 P의 위치들을 담은 리스트
        List<Pos> list = new ArrayList<>();
        
        for(int i=0; i<places.length; i++) {
        	String place[] = places[i];
        	
        	int result = 0;
        	for(int j=0; j<place.length; j++) {
        		for(int z=0; z<place[j].length(); z++) {
        			if(place[j].charAt(z) == 'P') {
        		        // 각 P의 위치에서 bfs를 실행한 후 그 도달한 지점에서 거리를 계산해본다
        				result += bfs(j,z,place);
        			}
        		}
        	}
        	
        	if(result == 0) answer[i] = 1;
        	else answer[i] = 0;
        	System.out.print(answer[i] + ", ");
        }
       
        return answer;
    }
    
    public static int bfs(int x, int y, String[] place) {
    	Queue<Pos> q = new LinkedList<>();
    	q.add(new Pos(x,y));
    	boolean visitied[][] = new boolean[5][5];
    	visitied[x][y] = true;
    	
    	while(!q.isEmpty()) {
    		Pos p = q.poll();
    		
    		for(int i=0; i<4; i++) { // 4가지 방향
    			int new_x = p.x + directX[i];
    			int new_y = p.y + directY[i];
    			// 범위 안
    			if(new_x >= 0 && new_x <5 && new_y >= 0 && new_y <5) {
    				if(visitied[new_x][new_y] == false){
    					if(place[new_x].charAt(new_y) == 'O') {
    						visitied[new_x][new_y] = true;
    						q.add(new Pos(new_x, new_y));
    					}
    					
    					if(place[new_x].charAt(new_y) == 'P') { // 가장 가까이 앉아있는 사람
    				        // 가장 가까이 있는 사람이 거리두기를 두고있다면 나머지는 볼 필요도 없다
    						// System.out.println("사람이 앉아 있는 자리 " + new_x + " " + new_y);
    						int result = Math.abs(x-new_x) + Math.abs(y-new_y);
    						// System.out.println("result " + result);
    						
    						if(result <= 2) return 1;
    						else return 0;
    					}
    				}
    			}
    		}
    	}
    	return 0;
    }

}
