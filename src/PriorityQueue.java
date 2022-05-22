
public class PriorityQueue {
	// MIN HEPIFY
	public int heap[] = new int[10000];
	public int SIZE = 0;
	
	public void insert(int val) {
		// 끝에 삽입 후 루트노드까지 hefipy
		heap[++SIZE] = val;
		
		int index = SIZE;
		int parent = index/2;
		
		while(heap[parent] > heap[index] && index > 1) {
			// 값 교환
			int tmp = heap[parent];
			heap[parent] = heap[index];
			heap[index] = tmp;
			
			index = parent;
			parent = index / 2;
		}
	}
	
	public int pop() {
		if(SIZE == 0) return -1;
		else {
			int result = heap[1];
			heap[1] = heap[SIZE--]; // 끝에 값을 루트로 이동
			
			int index = 1;
			int left = index * 2;
			int right = index * 2 + 1;
			while(left <= SIZE) {
				int min_child = left;
				
				if(right <= SIZE && heap[right] < heap[left]) min_child = right;
				
				if(heap[index] <= heap[min_child]) break;
				
				int tmp = heap[min_child];
				heap[min_child] = heap[index];
				heap[index] = tmp;
				
				index = min_child;
				left = index*2;
				right = index*2+1;
			}
			return result;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue pq = new PriorityQueue();
		
		pq.insert(9);
		pq.insert(5);
		pq.insert(11);
		
		System.out.println(pq.pop());
	}

}
