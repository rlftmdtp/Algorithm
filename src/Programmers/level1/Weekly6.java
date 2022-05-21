package Programmers.level1;

import java.util.*;

class Weekly6 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
	}
	
    public int[] solution(int[] weights, String[] head2head) {
        int[] answer = {};
        
        PriorityQueue<Player> pq = new PriorityQueue<>();
        // 정렬 한 후 결과를 구해라
        // 전체 승률이 높은 복서 번호가 앞으로(0%)
        // 승률이 동일한 번호의 경우 몸무메가 무거운 복서를 이긴 횟수
        // 무거운 복서 이긴 횟수 동일 할 경우  자신의 몸무메가 무거운 복서가 앞으로
        // 자기 몸무게 까지 동일한 복서는 작은 번호가 앞으로
        for(int i=0; i<weights.length; i++){
            float winRate = 0;
            int biggerWin = 0;
            
            for(int j=0; j<head2head[i].length(); j++){
                if(i == j) continue; // 자기 번호는 넘어간다
                
                if(head2head[i].charAt(j) == 'W') {
                    winRate++;
                    if(weights[i]<weights[j]) biggerWin++;
                }   
            }

            String str = String.format("%.02f", winRate/(weights.length-1));
            winRate = Float.valueOf(str);
         System.out.println("이긴 횟수 " + winRate + " 더 큰몸 " + biggerWin);
         pq.add(new Player(i+1, (weights.length-1)/winRate, biggerWin, weights[i]));
        }
        return answer;
    }
}

class Player {
    int index;
    float winRate;
    int biggerWin;
    int weight;
    
    public Player(int index, float winRate, int biggerWin, int weight){
        this.index = index;
        this.winRate = winRate;
        this.biggerWin = biggerWin;
        this.weight = weight;
    }
}