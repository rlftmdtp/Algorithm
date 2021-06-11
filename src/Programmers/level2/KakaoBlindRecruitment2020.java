package Programmers.level2;

import java.util.*;

public class KakaoBlindRecruitment2020 {

    public static int leftCount = 0;
    public static int rightCount = 0;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("()))((()"));

	}
	
    public static String solution(String p) {
        return recursion(0, p);
    }
   
	private static String recursion(int i, String p) {
		// TODO Auto-generated method stub
		
		if(i == p.length()) {
			return "";
		}else {
			String u = "";
			String v = "";
			
			// �� ���ڿ� u, v�� �и�
			int j;
			for(j=i; j<p.length(); j++) {
				count(p.charAt(j));
				if(countEqual()) break;
			}
			
			// j�� �������� u,v�� ������ 
			u = p.substring(i, j+1);
			v = p.substring(j+1, p.length());
			
			// �ùٸ� ��ȣ ���ڿ� 
			if(u.charAt(0) == '(') {
				return u + recursion(j+1,p);
			}else {
				String newV = recursion(j+1,p);
				StringBuilder sbV = new StringBuilder();
				sbV.append("(");
				sbV.append(newV);
				sbV.append(")");
				
				StringBuilder sbU = new StringBuilder();
				for(int z=1; z<u.length()-1; z++) { // u�� �յ� �������ŷ� 1���۰� �� -1
					if(u.charAt(z) == '(') sbU.append(")"); // �ݴ�� �ֱ�
					else sbU.append("(");
				}
				return sbV.toString() + sbU.toString();
			}
		}
	}

	public static void count(char c) {
    	if(c == '(') leftCount++;
    	else rightCount++;
    }
	
    private static boolean countEqual() {
		// TODO Auto-generated method stub
    	if(leftCount == rightCount) return true;
    	else return false;
	}

}
