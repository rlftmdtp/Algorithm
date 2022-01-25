package Programmers.level2;

import java.util.*;

public class Kakao2022Arrow {
	public static PriorityQueue<Arrow> pq = new PriorityQueue<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int n = 5;
//		int[] info = {2,1,1,1,0,0,0,0,0,0,0};
		
//		int n = 9;
//		int[] info = {0,0,1,2,0,1,1,1,1,1,1};
		
//		int n =1;
//		int[] info = {1,0,0,0,0,0,0,0,0,0,0};
		
		int n = 10;
		int[] info = {0,0,0,0,0,0,0,0,3,4,3};
		solution(n, info);
	}
	
    public static int[] solution(int n, int[] info) {
        int[] answer = {};
        
        combi(info, n, 0, new int[11]);
        
        Arrow a = pq.poll();
        // System.out.println("a.gap " + a.gap);
        if(pq.isEmpty() || pq.peek().gap == 0) { // 0점은 비기는 경우
        	answer = new int[1];
        	answer[0] = -1;
        }else {
        	System.out.println("정답 ");
        	for(int i=0; i<a.list.length; i++) {
        		System.out.print(a.list[i] + ", ");
        	}
        	answer = a.list.clone();
        }
        return answer;
    }
    
    public static void combi(int[] info, int n, int depth, int lion[]) {
    	if(n == 0) {
    		// 점수 계산
    		calGrade(info, lion);
    	}else if(depth == info.length) {
    		// System.out.println("남아 있는 화살 수 " + n);
    		if(n>0) {
    			// 0점에 화살을 맞추는 경우
    			lion[lion.length - 1] = n;
    			calGrade(info, lion);
    			lion[lion.length - 1] = 0;
    		}
    		return;
    	}else {
    		// 라이언 승
    		lion[depth] = info[depth] + 1;
    		combi(info, n-lion[depth], depth+1, lion);
    		
    		lion[depth] = 0;
    		// 어피치가 승리하거나 무승부 일 경우
    		combi(info, n, depth+1, lion);
    	}
    }
    
    public static void calGrade(int[] info, int[] lion) {
		int lion_sum = 0;
		int apech_sum = 0;
		for(int i=0; i<lion.length; i++) {
			if(lion[i] > 0) {
				// System.out.println("라이언 점수 획득 " + (10-i));
				lion_sum += (10-i);
			}
			else if(info[i] > 0){
				// System.out.println("어피치 점수 획득 " + (10-i));
				apech_sum += (10-i);
			}
		}
		//System.out.println("-------------------------------------");
		// 라이언이 총합 점수를 어피치를 이겼을 경우에 정답 중 하나도 넣는다
		if(lion_sum >= apech_sum) { // 비기는 경우도 존재 하기 떄문에 = 포함시킨다
			pq.add(new Arrow(lion_sum - apech_sum, lion.clone()));
		}
    }

}

class Arrow implements Comparable<Arrow>{
	int gap;
	int list[];
	
	public Arrow(int gap, int list[]) {
		this.gap = gap;
		this.list = list;
		System.out.println("gap " + gap);
		for(int i=0; i<list.length; i++) {
			System.out.print(list[i] + ", ");
		}
		System.out.println();
	}
	
	public int compareTo(Arrow a) {
		if(this.gap == a.gap) {
			// 가장 낮은 점수를 더 많이 맞힌 경우를 return
			for(int i=list.length-1; i>=0; i--) {
				if(this.list[i] == a.list[i]) continue;
				else return this.list[i] - a.list[i];
			}
		}
		
		return a.gap - this.gap;
	}
}