package Programmers.level2;

import java.util.*;


public class H_index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int solution(int[] citations) {
        int answer = 0;
        
        // 내림차순으로 정렬
        List<Integer> list = new ArrayList<Integer>();
        list = Arrays.asList(citations);
        
        Arrays.sort(citations, Collections.reverseOrder()); // Collections가 객체만 지원하므로 Integer로 만들어야한다
        
        return answer;
    }
}
