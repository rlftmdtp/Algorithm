package Programmers.level2;

import java.util.*;

public class Kakao2019CandidateKey {
	public static boolean visitied[];
	public static List<String> result = new ArrayList<>();
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
    		List<Integer> candidateKey = new ArrayList<>();
    		for(int i=0; i<visitied.length; i++) {
    			if(visitied[i] == true) {candidateKey.add(i);
    			System.out.print(i + ", ");
    			}
    		}
    		System.out.println();
    		
    		// ���۵� �ĺ�Ű ���� ���� �����͵��� �˻��Ѵ�
    		HashMap<String, Integer> hm = new HashMap<>();

    		for(int i=0; i<relation.length; i++) {
    			// ���� ��
    			StringBuilder sb = new StringBuilder();
    			for(int j=0; j<candidateKey.size(); j++) {
    				int index = candidateKey.get(j);
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
    		String key = "";
    		for(int i=0; i<candidateKey.size(); i++) {
    			int row = candidateKey.get(i);
    			key += row;
    			for(int j=0; j<result.size(); j++) {
    				String candi = result.get(j); // ������ ���� ���� �ĺ�Ű
    				for(int z=0; z<candi.length(); z++) {
    					if(Integer.parseInt(candi.charAt(z) + "") == row) return; // �̹� �ش� ���� ������ ��� �ĺ�Ű X
    				}
    			}
    		}
    		System.out.println("�ĺ�Ű Ȯ�� " + key);
    		result.add(key);
    	}else if(depth == relation[0].length){ return;
    	}else {
    		visitied[depth] = true;
    		combi(relation, r-1, depth+1);
    		
    		visitied[depth] = false;
    		combi(relation, r, depth+1);
    	}
    }

}
