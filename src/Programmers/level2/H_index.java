package Programmers.level2;

import java.util.*;


public class H_index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int solution(int[] citations) {
        int answer = 0;
        
        // ������������ ����
        List<Integer> list = new ArrayList<Integer>();
        list = Arrays.asList(citations);
        
        Arrays.sort(citations, Collections.reverseOrder()); // Collections�� ��ü�� �����ϹǷ� Integer�� �������Ѵ�
        
        return answer;
    }
}
