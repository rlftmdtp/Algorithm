package Programmers.level2;

import java.util.*;

public class Kakao2020GemShoping {
	public static String[] GEMS;
	public static PriorityQueue<Result> pq = new PriorityQueue<>();
	
	public static class Result implements Comparable<Result>{
		int start;
		int end;
		int length;
		
		public Result(int start, int end, int length) {
			this.start = start;
			this.end = end;
			this.length = length;
		}

		public int compareTo(Result r) {
			if(this.length == r.length) return this.start - r.start;
			else return this.length - r.length;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] gems = {"AA", "AB", "AC", "AA", "AC"};
		solution(gems);
	}
	
    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        GEMS = gems;
        // 보석의 종류 생성
        HashSet<String> hs = new HashSet<>();
        for(int i=0; i<gems.length; i++) {
        	hs.add(gems[i]);
        }
        
        // dfs 탐색
        for(int i=0; i<gems.length; i++) {
        	HashSet<String> gemHs = (HashSet<String>) hs.clone();
        	dfs(i, gemHs, i);
        }
        
        Result result = pq.poll();
        answer[0] = result.start;
        answer[1] = result.end;
        System.out.println(answer[0] + " " + answer[1]);
        return answer;
    }
    
    public static void dfs(int start, HashSet<String> gemHs, int depth) {
    	if(gemHs.size() == 0) {
    		// 최소 하나씩 모두 다 골랐을 경우
    		// System.out.println("start " + (start+1) + " end " + (depth));
    		pq.add(new Result(start+1, depth, depth-(start+1)));
    	}else if(depth == GEMS.length) {
    		return;
    	}
    	else {
    		if(gemHs.contains(GEMS[depth])) gemHs.remove(GEMS[depth]);
    		dfs(start, gemHs, depth+1);
    	}
    }

}
