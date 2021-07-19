package Programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DiskController {
	public static int endTime = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		System.out.println(solution(jobs));
	}
	
    public static int solution(int[][] jobs) {
    	
        PriorityQueue<JOB> pq = new PriorityQueue<JOB>();
        
        int endTime = 0;
        int average = 0;
        
        List<JOB> list = new ArrayList<JOB>();
        for(int i=0; i<jobs.length; i++) {
        	list.add(new JOB(jobs[i][0], jobs[i][1], jobs[i][1]-jobs[i][0]));
        }
        // 시작 시간기준으로 오름차순 정렬
        Collections.sort(list, new Comparator<JOB>() {

			@Override
			public int compare(JOB o1, JOB o2) {
				// TODO Auto-generated method stu
				return o1.start - o2.start;
			}
		});
        
        for(int i=0; i<list.size(); i++) {
        	if(list.get(i).start <= endTime) {
        		pq.add(list.get(i));
        	}
        	else {
        		while(!pq.isEmpty()) {
        			JOB job = pq.poll();
        			//System.out.println(" 점검 " + job.start + "  " + job.runTime);
        			endTime += job.runTime;
        			average += endTime - job.start;
        		}
        		pq.add(list.get(i));
        	}
        }
        
        // 나머지 처리
		while(!pq.isEmpty()) {
			JOB job = pq.poll();
			//System.out.println(" 점검 " + job.start + "  " + job.runTime);
			endTime += job.runTime;
			average += endTime - job.start;
		}
        return average/jobs.length;
    }
    
}

class JOB implements Comparable<JOB>{
	int start;
	int runTime;
	int gapTime;
	
	public JOB(int start, int runTime, int gapTime) {
		super();
		this.start = start;
		this.runTime = runTime;
		this.gapTime = gapTime;
	}
	
	@Override
	public int compareTo(JOB o) {
		// TODO Auto-generated method stub		
		return this.gapTime - o.gapTime;
	}	
}
