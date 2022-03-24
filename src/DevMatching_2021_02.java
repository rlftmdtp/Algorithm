import java.io.*;
import java.util.*;
import java.util.regex.*;


public class DevMatching_2021_02 {
	public static HashMap<String, Integer> hm = new HashMap<>();
	
	public static class Order implements Comparable<Order>{
		int index;
		int time;
		
		public Order(int index, int time){
			this.index = index;
			this.time = time;
		}

		@Override
		public int compareTo(Order o) {
			// TODO Auto-generated method stub
			return o.index - this.index;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n = 3;
//		String[] recipies = {"A 3", "B 2"};
//		String[] orders = {"A 1", "A 2", "B 3", "B 4"};
		
		String[] recipies = {"S 3", "F 2", "P 8"};
		String[] orders = {"P 1", "F 2" , "S 4", "S 6", "P 7", "S 8"};
		solution(n, recipies, orders);
	}
	
	public static int solution(int n, String[] recipes, String[] orders){
		
		for(int i=0; i<recipes.length; i++){
			String strSplit[] = recipes[i].split(" ");
			hm.put(strSplit[0], Integer.parseInt(strSplit[1]));
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		PriorityQueue<Order> result = new PriorityQueue<>();
		int delayTime = 0;
		for(int i=0; i<orders.length; i++){
			String strSplit[] = orders[i].split(" ");
			String recipie = strSplit[0];
			
			int orderTime = Integer.parseInt(strSplit[1]);
			
			if(pq.isEmpty()){
				pq.add(delayTime + orderTime + cooking(recipie));
			}else{
				// 주문들어온 시간과 pq의 가장 빨리 끝나는 시간과 비교
				while(pq.peek() <= orderTime && !pq.isEmpty()){
					pq.poll();
				}
				
				// 만약에 빠진 시간이 없다
				// delay 증가 후  제거를 하고 넣는다
				if(pq.size() == n){
					delayTime = pq.poll() - orderTime;
				}
				System.out.println(i + " delayTime " + delayTime + " orderTime " + (delayTime + orderTime + cooking(recipie)));
				pq.add(delayTime + orderTime + cooking(recipie));
			}
			result.add(new Order(i, delayTime + orderTime + cooking(recipie)));
		}
		
		int lastTime = result.poll().time;
		System.out.println(lastTime);
		return lastTime;
	}
	
	public static int cooking(String recipie){
		return hm.get(recipie);
	}
	
	
}


