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
    	
        Queue<Truck> q = new LinkedList<>();
        limit = bridge_length;
        
        int current_time = 0;
        int totalWeight = 0;
        for(int i=0; i<truck_weights.length; i++) {
        	int truck_weight = truck_weights[i];
        	current_time++;
        	
        	while(q.size() == bridge_length || totalWeight + truck_weight >= weight) {
        		if(passTheBridge(q, current_time)) break;
        		else current_time++;
        	}
        	
        	q.add(new Truck(current_time, truck_weight));
        	totalWeight += truck_weight;
        	System.out.println("I " + i);
        	passTheBridge(q, current_time);
        }
        
        while(!q.isEmpty()) {
    		if(passTheBridge(q, current_time)) break;
    		else current_time++;
        }
        System.out.println(current_time);
        return current_time;
    }
    
    public static boolean passTheBridge(Queue<Truck> q, int current_time) {
    	
    	Truck truck = q.peek();
    	System.out.println("다리를 건너는 트럭 " + truck.weight + " 시간 " + current_time);
    	if(current_time - truck.startTime == limit) {
    		System.out.println("다리를 건너는 트럭 " + truck.weight + "빠져나온 시간 " + current_time);
    		totalWeight -= truck.weight;
    		q.poll();
    		return true;
    	}
    	return false;
    }

}

class Truck{
	int startTime;
	int weight;
	
	public Truck(int startTime, int weight) {
		this.startTime = startTime;
		this.weight = weight;
	}
}


