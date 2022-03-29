package Programmers.level3;

import java.util.*;

public class ToothbrushSeller {
	
	public static class Node{
		String parent;
		int result;
		
		public Node(String parent, int result) {
			this.parent = parent;
			this.result = result;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};
		solution(enroll, referral, seller, amount);
	}
	
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // �ʱ�ȭ ����
        HashMap<String, Node> hm = new HashMap<>();
        for(int i=0; i<enroll.length; i++) {
        	hm.put(enroll[i], new Node(referral[i], 0));
        }
        
        for(int i=0; i<seller.length; i++) {
        	// �Ǹž��� 10%�� ����� ���� �ְ� �������� �ڱⰡ ������
        	int price = amount[i] * 100;
        
        	String parent = seller[i];
        	while(!parent.equals("-")) {
            	Node n = hm.get(parent);
            	int rate = (int) (price * 0.1);
            	
            	n.result += price - rate;
            	// System.out.println(price - rate);
            	// System.out.println(parent  +" �� �Ѱ� " + n.result);
            	parent = n.parent;
            	price = rate;
            	
            	if(price < 1) break;
        	}
        	// System.out.println("---");
        }
        
        // ������
        int result[] = new int[enroll.length];
        for(int i=0; i<enroll.length; i++) {
        	result[i] = hm.get(enroll[i]).result;
        	// System.out.println(result[i]);
        }
        return result;
    }

}
