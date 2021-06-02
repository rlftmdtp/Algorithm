import java.util.*;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int progresses[] = {95, 90, 99, 99, 80, 99};
		int speeds[] = {1, 1, 1, 1, 1, 1};
		
		solution(progresses, speeds);
	}
	
    public static int[] solution(int[] progresses, int[] speeds) {        
		// 초기화
    	Queue<Work> q = new LinkedList<Work>();
		for(int i=0; i<progresses.length; i++) {
			q.add(new Work(progresses[i], speeds[i]));
		}
		
		List<Integer> results = new ArrayList<Integer>();
		while(!q.isEmpty()) {
			int result = 1;
			
			Work work = q.poll();
			// 소요되는 일 계산
			int day = 0;
			int mod = 100 - work.progress;
			if(mod%work.speed == 0) day = mod/work.speed;
			else day = mod/work.speed + 1;
			
			while(!q.isEmpty()) {
				if(q.peek().speed * day >= 100-q.peek().progress) {
					result++;
					q.poll();
				}else
					break;
			}
			
			results.add(result);
		}

		int[] answer = new int[results.size()];
		for (int i = 0; i < results.size(); i++) {
			answer[i] = results.get(i);
			System.out.println(answer[i]);
		}

		return answer;
    }
}

class Work{
	int progress;
	int speed;
	
	public Work(int progress, int speed) {
		super();
		this.progress = progress;
		this.speed = speed;
	}
	
}
