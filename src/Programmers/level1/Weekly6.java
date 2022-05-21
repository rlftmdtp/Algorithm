package Programmers.level1;

import java.util.*;

class Weekly6 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
	}
	
    public int[] solution(int[] weights, String[] head2head) {
        int[] answer = {};
        
        PriorityQueue<Player> pq = new PriorityQueue<>();
        // ���� �� �� ����� ���ض�
        // ��ü �·��� ���� ���� ��ȣ�� ������(0%)
        // �·��� ������ ��ȣ�� ��� �����ް� ���ſ� ������ �̱� Ƚ��
        // ���ſ� ���� �̱� Ƚ�� ���� �� ���  �ڽ��� �����ް� ���ſ� ������ ������
        // �ڱ� ������ ���� ������ ������ ���� ��ȣ�� ������
        for(int i=0; i<weights.length; i++){
            float winRate = 0;
            int biggerWin = 0;
            
            for(int j=0; j<head2head[i].length(); j++){
                if(i == j) continue; // �ڱ� ��ȣ�� �Ѿ��
                
                if(head2head[i].charAt(j) == 'W') {
                    winRate++;
                    if(weights[i]<weights[j]) biggerWin++;
                }   
            }

            String str = String.format("%.02f", winRate/(weights.length-1));
            winRate = Float.valueOf(str);
         System.out.println("�̱� Ƚ�� " + winRate + " �� ū�� " + biggerWin);
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