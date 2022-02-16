package Programmers.level1;

public class Kakao2020KeypadPush {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		solution(numbers, hand);
	}
	
	public static class Pos{
		int x;
		int y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
    public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        // �޴��� ��ǥ
        int numberX[] = {0,0,0, 1,1,1, 2,2,2, 3,3,3};
        int numberY[] = {0,1,2,  0,1,2, 0,1,2, 0,1,2};
        Pos leftHand = new Pos(3,0);
        Pos rightHand = new Pos(3,2);

        for(int i=0; i<numbers.length; i++) {
        	int number = numbers[i] == 0 ? 11 : numbers[i];
        	// �ش��ȣ�� ��ǥ ��������
        	int x = numberX[number-1];
        	int y = numberY[number-1];
        	
        	if(number == 1 || number==4 || number ==7) {
        		sb.append("L");
        		leftHand = new Pos(x,y);
        	}else if(number==3 || number==6 || number==9) {
        		sb.append("R");
        		rightHand = new Pos(x,y);
        	}else { // ��� �� ���� 2 5 8 0
            	// �հ����������� ��ǥ������ �Ÿ� ���ϱ�
            	int leftDistance = Math.abs(leftHand.x-x) + Math.abs(leftHand.y-y);
            	int rightDistance = Math.abs(rightHand.x-x) + Math.abs(rightHand.y-y);
            	
            	if(leftDistance == rightDistance) {
            		if(hand.equals("right")) {
            			sb.append("R");
            			rightHand = new Pos(x,y);
            		}else {
            			sb.append("L");
            			leftHand = new Pos(x,y);
            		}
            	}else {
            		// �� ����� �� �հ��� �̵�
            		if(leftDistance < rightDistance) {
            			sb.append("L");
            			leftHand = new Pos(x,y);
            		}else {
            			sb.append("R");
            			rightHand = new Pos(x,y);
            		}
            	}
            	
            	// System.out.println("leftDistance " + leftDistance + " rightDistance " + rightDistance);
        	}

        
        }
        
        // �����¿� 4����
        System.out.println(sb.toString());
        return sb.toString();
    }

}
