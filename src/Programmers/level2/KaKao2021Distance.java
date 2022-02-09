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
        
        // �� P�� ��ġ���� ���� ����Ʈ
        List<Pos> list = new ArrayList<>();
        
        for(int i=0; i<places.length; i++) {
        	String place[] = places[i];
        	
        	int result = 0;
        	for(int j=0; j<place.length; j++) {
        		for(int z=0; z<place[j].length(); z++) {
        			if(place[j].charAt(z) == 'P') {
        		        // �� P�� ��ġ���� bfs�� ������ �� �� ������ �������� �Ÿ��� ����غ���
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
    		
    		for(int i=0; i<4; i++) { // 4���� ����
    			int new_x = p.x + directX[i];
    			int new_y = p.y + directY[i];
    			// ���� ��
    			if(new_x >= 0 && new_x <5 && new_y >= 0 && new_y <5) {
    				if(visitied[new_x][new_y] == false){
    					if(place[new_x].charAt(new_y) == 'O') {
    						visitied[new_x][new_y] = true;
    						q.add(new Pos(new_x, new_y));
    					}
    					
    					if(place[new_x].charAt(new_y) == 'P') { // ���� ������ �ɾ��ִ� ���
    				        // ���� ������ �ִ� ����� �Ÿ��α⸦ �ΰ��ִٸ� �������� �� �ʿ䵵 ����
    						// System.out.println("����� �ɾ� �ִ� �ڸ� " + new_x + " " + new_y);
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
