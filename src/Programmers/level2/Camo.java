package Programmers.level2;

import java.util.*;

public class Camo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
		System.out.println(solution(clothes));
	}
	
    public static int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(int i=0; i<clothes.length; i++){
            hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 0) + 1); // �� ó���� put�� ��� �ʱ�ȭ�� �ȵǾ��־� null�� �����Ƿ� Default 0�� ����
        }
        
        Set<String> set = hm.keySet();
        for(String str : set) {
        	answer *= hm.get(str) + 1; // �� ������ �������� �� �Դ� ��쵵 �����Ƿ� �ϳ��� ���ϰ� ���ÿ� �Ͼ�� ���̹Ƿ� ���Ѵ� 
        }
        
        return answer-1; // ��� ������ �� �����ʴ� �Ѱ��� ��� ����
    }

}
