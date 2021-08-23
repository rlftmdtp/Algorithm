package Programmers.level2;

import java.util.*;


public class TakeGroupPicture {
	public static char group[] = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
	public static List<Character> list = new ArrayList<>();
	public static boolean visitied[] = new boolean[group.length];
	public static int result = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		String[] data = {"N~F=0", "R~T>2"};
		solution(n, data);
	}
	
    public static int solution(int n, String[] data) {
        // 순열를 한다음에 그 조건이 맞는지 검사한다
    	// 프로그래머스에서 왜인지 모르겠는데 전역변수 초기화 안하면 정답이 안나옴
    	result = 0;
        perm(0, data);
        System.out.println(result);
        return result;
    }

	private static void perm(int depth, String[] data) {
		// TODO Auto-generated method stub
		if(depth == group.length) {
			
			/* 순열 확인용
			 * for(int i=0; i<list.size(); i++) { System.out.print(list.get(i)); }
			 * System.out.println();
			 */
			
			// 조건 검사
			boolean finalFlag = true;
			for(int i=0; i<data.length; i++) {
				char left = data[i].charAt(0);
				char right = data[i].charAt(2);
				char sign = data[i].charAt(3);
				int interval = data[i].charAt(4)-'0' + 1; // 배열0부터 시작 고려해서 +1를 꼭해야한다
				
				int nLeft = 0;
				int nRight = 0;
				for(int j=0; j<list.size(); j++) {
					if(left == list.get(j)) nLeft = j;
					if(right == list.get(j)) nRight = j;
				}
				int nInterval = Math.abs(nLeft - nRight);
				
				boolean flag = false;
				switch (sign) {
				case '=': {
					if(nInterval == interval) flag = true;
					break;
				}
				case '>': {
					if(nInterval > interval) flag = true;
					break;
							}
				case '<': {
					if(nInterval < interval) flag = true;
					break;
				}
				}
				
				if(flag == false) {
					finalFlag = false;
					break;
				}
			}
			if(finalFlag) result++;
			
		}else {
			for(int i=0; i<group.length; i++) {
				if(visitied[i] == false) {
					visitied[i] = true;
					list.add(group[i]);
					perm(depth+1, data);
					
					list.remove(list.size()-1);
					visitied[i] = false;
				}
			}
		}
	}

}
