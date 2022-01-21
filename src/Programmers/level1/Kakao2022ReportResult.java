package Programmers.level1;

import java.util.*;

import javax.swing.text.html.StyleSheet.ListPainter;

public class Kakao2022ReportResult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		solution(id_list, report, k);
	}
	
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // �ʱ�ȭ
        HashMap<String, HashSet<String>> report_list = new HashMap<>(); // �Ű��� ��� ����Ʈ
        HashMap<String, Integer> report_count = new HashMap<>(); // �Ű� ���� ��� �� ���� Ƚ��
        for(int i=0; i<id_list.length; i++) {
        	report_list.put(id_list[i], new HashSet<>());
        }
       
        for(int i=0; i<report.length; i++) {
        	String strSplit[] = report[i].split(" ");
        	
        	HashSet<String> hs = report_list.get(strSplit[0]);
        	if(!hs.contains(strSplit[1])) report_count.put(strSplit[1], report_count.getOrDefault(strSplit[1], 0) + 1);
        	hs.add(strSplit[1]);
        	report_list.put(strSplit[0], hs);
        }
        
        for(int i=0; i<id_list.length; i++) {
        	String name = id_list[i];
        	
        	// �Ű��� ������� ���
        	int count = 0;
        	HashSet<String> hs = report_list.get(name);
        	for(String str : hs) {
        		if(k <= report_count.get(str)) count++;
        	}
        	
        	answer[i] = count;
        	// System.out.println(count);
        }
        return answer;
    }

}
