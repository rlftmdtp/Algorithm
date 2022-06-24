package leetcode.basic;

import java.util.*;

public class MergeIntervals_56 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int intervals[][] = {{1,4},{0,1}};
		merge(intervals);
/*		Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
				Output: [[1,6],[8,10],[15,18]]
				Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].*/
				
	}
	
	
    public static int[][] merge(int[][] intervals) {
        
    	int result[][];
    	if(intervals.length == 1) {
    		return intervals;
    	}else {
    		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
    		List<Interval> list = new ArrayList<>();
    		list.add(new Interval(intervals[0][0], intervals[0][1]));
    		for(int i=1; i<intervals.length; i++) {			
    			Interval in = list.get(list.size()-1);
    			list.remove(list.size()-1);
    			
    			if(in.end >= intervals[i][0]) {				
    				if(in.end >= intervals[i][1]) list.add(new Interval(in.start, in.end));
    				else list.add(new Interval(in.start, intervals[i][1]));
    			}else {
    				list.add(in);
    				list.add(new Interval(intervals[i][0], intervals[i][1]));
    			}
    		}
    		
    		result = new int[list.size()][2];
    		for(int i=0; i<list.size(); i++) {
    			Interval in = list.get(i);
    			result[i][0] = in.start;
    			result[i][1] = in.end;
    		}
    	}
    	
    	return result;
    }

    static class Interval{
    	int start;
    	int end;
    	
    	public Interval(int start, int end){
    		this.start = start;
    		this.end = end;
    	}
    }
}
