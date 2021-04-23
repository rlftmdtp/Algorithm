package Programmers.level2;

import java.util.*;

public class Scoville {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		System.out.println(solution(scoville, K));
	}
	
    public static int solution(int[] scoville, int K) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int s : scoville) {
        	pq.add(s);
        }
        System.out.println(pq.peek());
        int count = 0;
        while(pq.peek() < K) {
            if(pq.size() < 2) return -1; // 이 조건 하나가 없어서 런타임 에러가 났는데 솔직히 이해가 안간다...
        	int one = pq.poll();
        	int two = pq.poll();
        	int newFood = one + (two * 2);
        	pq.add(newFood);
        	count++;
        }
        // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
        if(pq.peek() < K) return -1;
        else return count;
    }
}

