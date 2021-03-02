package Programmers.level1;

import java.io.*;
import java.util.*;
import java.util.Comparator;

public class StringMyMindSort { // 문자열 내림차순으로 배치하기

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strings[] = br.readLine().split("\\s");
		int n = Integer.parseInt(br.readLine());
		
		String result[] = solution(strings, n);
		for(int i=0; i<result.length; i++) {
			System.out.println(result[i]);
		}
	}

	private static String[] solution(String[] strings, int n) {
		// TODO Auto-generated method stub
		// 자기자신만의 추가 정렬을 하기 위해서 Comparator(익명클래스) 사용
		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if(o1.charAt(n) > o2.charAt(n)) return 1;
				else if(o1.charAt(n) == o2.charAt(n)) {
					return o1.compareTo(o2);
				}else return -1;
			}
		});
		
		return strings;
	}

}
