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
        
        // 초기화
        HashMap<String, HashSet<String>> report_list = new HashMap<>(); // 신고한 사람 리스트
        HashMap<String, Integer> report_count = new HashMap<>(); // 신고 당한 사람 촛 누적 횟수
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
        	
        	// 신고한 사람들의 결과
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
