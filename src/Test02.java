import java.util.*;

public class Test02 {
	
	public static class Search implements Comparable<Search>{
		String log;
		int count;
		
		public Search(String log, int count) {
			this.log = log;
			this.count = count;
		}
		
		public int compareTo(Search s) {
			
			if(this.count == s.count) return this.log.compareTo(s.log);
			else return s.count - this.count;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String research[] = {"yxxy", "xxyyy", "yz"};
		int n = 2;
		int k = 1;
		System.out.println(solution(research, n, k));
	}
	
	public static String solution(String[] research, int n , int k) {
		
		HashMap<String, int[]> hm = new HashMap<>();
		for(int i=0; i<research.length; i++) {
			String log = research[i];

			for(int j=0; j<log.length(); j++) {
				String search = log.charAt(j) + "";
				if(hm.get(search) == null) hm.put(search, new int[research.length]);
				
				int[] count = hm.get(search);
				count[i]++;
			}
		}
		
		// n일 연속 최소 k번
		PriorityQueue<Search> pq = new PriorityQueue<>();
		for(String key : hm.keySet()) {
			int list[] = hm.get(key);
			int max = 0;
			int isuue_count = 0;
			// 연속된 n일 동안 최소 k번이상
			for(int i=0; i<=list.length-n; i++) {
				int sum = 0;
				boolean flag = true;
				for(int j=0; j<n; j++) {
					if(list[i+j] < k) flag = false;
					sum += list[i+j];
				}
				// sum에 대해서 처리
				if(flag == true && n*k*2 <= sum) isuue_count++;
				
			}
			System.out.println(key + " 의 isuue_count = " + isuue_count);
			if(isuue_count != 0) pq.add(new Search(key, isuue_count));
		}
		
		if(pq.isEmpty()) return "None";
		else return pq.poll().log;
	}
	
}
