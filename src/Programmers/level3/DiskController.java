package Programmers.level3;

import java.util.PriorityQueue;

public class DiskController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<JOB> pq = new PriorityQueue<JOB>();
        // √ ±‚»≠
        for(int i=0; i<jobs.length; i++) {
        	pq.add(new JOB(jobs[i][0], jobs[i][1]));
        }
        
        
        
        
        return answer;
    }
    
}

class JOB implements Comparable<JOB>{
	int start;
	int runTime;
	public JOB(int start, int runTime) {
		super();
		this.start = start;
		this.runTime = runTime;
	}
	
	@Override
	public int compareTo(JOB o) {
		// TODO Auto-generated method stub
		
		if(this.start == o.start) {
			
		}
		
		return 0;
	}	
}
