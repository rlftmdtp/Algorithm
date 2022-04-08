package Programmers.level2;

import java.util.*;
import java.util.regex.*;

public class Joystick {
	public static boolean visitied[];
	public static int direct[] = {-1,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "JAN";
		solution(name);
	}
	
    public static int solution(String name) {
        int answer = 0;
        
        visitied = new boolean[name.length()];
        answer = bfs(name,1); // ��������
        
        visitied = new boolean[name.length()];
        answer = Math.min(bfs(name,-1),answer); // ��������
        
        return answer;
    }
    
    public static int bfs(String name, int direct) {
    	
    	Queue<Joy> q = new LinkedList<>();
    	q.add(new Joy("A", 0, 0, 1));
    	visitied[0] = true;
    	
    	int count = 0;
    	while(!q.isEmpty()) {
    		Joy j = q.poll();
    		
    		// �� �Ʒ� ��� �̵��� �ʿ����� �˾ƺ���
    		// System.out.println("j.index " + j.index);
    		j.count += upDown(j.str.charAt(0), name.charAt(j.index));
    		
    		if(j.len_count == name.length()) {
    			System.out.println("���� j.count " + j.count);
    			count = j.count;
    			break;
    		}
    		
			// ���ʹ����̵�
			int new_index = j.index + direct;

			// ���� �̵��� ��� ������ ���ڷ� �̵�
			if (new_index == -1) new_index = name.length() - 1;

			if (new_index > 0 && new_index < name.length()) {
				if (visitied[new_index] == false) {
					if (name.charAt(new_index) != 'A')
						j.count++;
					visitied[new_index] = true;
					System.out.println("newindex " + new_index);
					q.add(new Joy("A", j.count, new_index, j.len_count + 1));
				}
			}
    		
    	}
    	System.out.println("���� ���� " + count);
    	return count;
    }
    
    public static int upDown(char ch, char ch2) {
    	System.out.println("upDonw " + ch + " " + ch2);
    	int gap = Math.abs(ch-ch2);
    	int gap2 = 'Z'-ch2+1;
    	System.out.println("gap " + gap + " gap2 " + gap2);
    	
    	return Math.min(gap, gap2);
    }
    
    public static class Joy{
    	String str;
    	int count;
    	int index;
    	int len_count;
    	
    	public Joy(String str, int count, int index, int len_count) {
    		this.str = str;
    		this.count = count;
    		this.index = index;
    		this.len_count = len_count;
    	}
    }
    

}
