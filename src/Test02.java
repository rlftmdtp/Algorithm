import java.util.*;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// [93, 30, 55]	[1, 30, 5]	[2, 1]
		int bridge_length = 2;
		int weight = 10;
		int truck_weights[] = {7,4,5,6};
		
		System.out.println(String.format("%.2f", 0.42345));
		
		solution(bridge_length, weight, truck_weights);
	}
	
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
    	
    	// 2	10	[7,4,5,6]	8
    	// ��� Ʈ���� �ٸ��� �ǳʷ��� �ּ� �� ��
    	int total_weight = 0;
    	int time = 0;
    	Queue<Integer> q = new LinkedList<>();
    	for(int i=0; i<truck_weights.length; i++) {
    		int truck_weight = truck_weights[i];
    		
    		if(q.isEmpty()) {
    			time++;
    			total_weight += truck_weight;
    			q.add(truck_weight);
    		}
    		else {
    			// �뷮 �ʰ��� �� �ö󰣴�

				// �ٸ����� Ʈ���� ���� �� ���� ����ؼ� ����
				while(total_weight + truck_weight >= weight) {
					t
				}


    		}
    	}
    	
    	
    	return -1;
    }
	
}
