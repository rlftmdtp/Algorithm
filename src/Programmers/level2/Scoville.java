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
            if(pq.size() < 2) return -1; // �� ���� �ϳ��� ��� ��Ÿ�� ������ ���µ� ������ ���ذ� �Ȱ���...
        	int one = pq.poll();
        	int two = pq.poll();
        	int newFood = one + (two * 2);
        	pq.add(newFood);
        	count++;
        }
        // ��� ������ ���ں� ������ K �̻����� ���� �� ���� ��쿡�� -1�� return �մϴ�.
        if(pq.peek() < K) return -1;
        else return count;
    }
}

