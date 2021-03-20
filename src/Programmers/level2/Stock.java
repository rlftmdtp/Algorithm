package Programmers.level2;

import java.util.*;

public class Stock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prices[] = {1, 2, 3, 2, 3};
		solution(prices);
	}
	
    public static int[] solution(int[] prices) {
     	int[] answer = new int[prices.length];
   	 
        List<Integer> list = new ArrayList<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0; i<prices.length; i++) {
        	q.add(prices[i]);
        }
        
        int i=0;
        while(!q.isEmpty()) {
        	int price = q.peek();
        	
        	int time = -1;
        	int n = 0;
        	for(int pri : q) {
        		time++;
        		n++;
        		if(pri < price) {
        			answer[i] = time;
        			break;
        		}
        		if(n == q.size()) {
        			answer[i] = time;
        		}
        	}
        	i++;
        	q.poll();
        }
        return answer;
    }

}
