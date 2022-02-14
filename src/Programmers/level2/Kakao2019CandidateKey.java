package Programmers.level2;

import java.util.*;

public class Kakao2019CandidateKey {
	public static boolean visitied[];
	public static List<HashSet<Integer>> result = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},
				{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
		solution(relation);
	}
	
    public static int solution(String[][] relation) {

        visitied = new boolean[relation[0].length];
        // �������� �ĺ�Ű ���� �����
        for(int i=0; i<relation[0].length; i++) {
        	combi(relation, i+1, 0);
        }
        
        return result.size();
    }
    
    public static void combi(String[][] relation, int r, int depth) {
    	if(r == 0) {
    		// �ĺ�Ű �ĺ��� ���� �Ϸ�
    		HashSet<Integer> candidateKey = new HashSet<>();
    		
    		// �ּҼ� �˻縦 ���� HashSet��� 123 �ĺ�Ű��� 12�� �����ϰ� �ִ��� �˻�
    		for(int i=0; i<visitied.length; i++) {
    			if(visitied[i] == true) {
    				candidateKey.add(i);
    				System.out.print(i + ", ");
    			}
    		}
    		System.out.println();
    		
    		// ���۵� �ĺ�Ű ���� ���� �����͵��� �˻��Ѵ�
    		HashMap<String, Integer> hm = new HashMap<>();

    		for(int i=0; i<relation.length; i++) {
    			// ���� ��
    			StringBuilder sb = new StringBuilder();	
    			for(int index : candidateKey) {
    				sb.append(relation[i][index]);
    			}
    			System.out.println("sb.toString() " + sb.toString());
    			hm.put(sb.toString(), hm.getOrDefault(sb.toString(), 0) + 1);
    		}
    		
    		// ���� �Ϸ�� �ĺ�Ű�� �ߺ��Ǵ°� �ִ��� �˻� (���ϼ�)
    		for(String key : hm.keySet()) {
    			int count = hm.get(key);
    			
    			if(count >= 2) return;
    		}
    		
    		// �ּҼ� �˻�
    		for(HashSet<Integer> hs : result) {
    			if(candidateKey.containsAll(hs)) return;
    		}
    		result.add(candidateKey);
    	}else if(depth == relation[0].length){ return;
    	}else {
    		visitied[depth] = true;
    		combi(relation, r-1, depth+1);
    		
    		visitied[depth] = false;
    		combi(relation, r, depth+1);
    	}
    }

}
