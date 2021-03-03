package Programmers.level1;

import java.io.*;
import java.util.*;
import java.util.Comparator;

public class StringMyMindSort { // ���ڿ� ������������ ��ġ�ϱ�

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
		// �ڱ��ڽŸ��� �߰� ������ �ϱ� ���ؼ� Comparator(�͸�Ŭ����) ���
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
