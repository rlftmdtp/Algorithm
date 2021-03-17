package Programmers.level2;

import java.util.*;

public class FunctionDevelope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int progresses[] = {95, 90, 99, 99, 80, 99};
		int speeds[] = {1, 1, 1, 1, 1, 1};
		
		solution(progresses, speeds);
	}
	
    public static int[] solution(int[] progresses, int[] speeds) {        
		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 0; i < progresses.length; i++) {
			int restTime = 100 - progresses[i];
			// �ҿ�ð� ���ϱ�
			int j = 1;
			while (true) {
				if (restTime <= speeds[i] * j)
					break;
				j++;
			}
			q.add(j);
		}

		// ������ �ҿ�Ǵ��� ť�� �ְ� �� ���� �۾��� �ϼ����� ������ ���� ���� ����
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (!q.isEmpty()) {
			int temp = q.poll();
			int result = 1;
			while (!q.isEmpty() && q.peek() <= temp) {
					q.poll();
					result++;
			}
			list.add(result);
		}

		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
			System.out.println(answer[i]);
		}

		return answer;
    }
}
