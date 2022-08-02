package Programmers.level2;

import java.util.*;

public class BridgePassTruck {
	
	public static int totalWeight = 0;
	public static int limit = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bridge_length = 2;
		int weight = 10;
		int truck_weights[] = {7,4,5,6};
		
		solution(bridge_length, weight, truck_weights);
	}
	
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
    	
    	int time = 0;
    	int total_weight = 0;
    	Queue<Integer> q = new LinkedList<>();
    	for(int i=0; i<truck_weights.length; i++) {
    		int truck_weight = truck_weights[i];
    		
    		while(true) {
    			time++;
    			System.out.println("½Ã°£ " + time);
    			if(q.size() == bridge_length) {
    				total_weight -= q.poll();
    				break;
    			}else if(truck_weight + total_weight <= weight) {
    				q.add(truck_weight);
    				total_weight += truck_weight;
    				break;
    			}else {
    				q.add(0);
    			}
    		}
    	}
    	
    	System.out.println(q.size());
    	return -1;
    }
    


}


