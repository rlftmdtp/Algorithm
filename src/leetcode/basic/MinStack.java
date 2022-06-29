package leetcode.basic;

public class MinStack {
	private int list[];
	private int pointer;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Input
		["MinStack","push","push","push","getMin","pop","top","getMin"]
		[[],[-2],[0],[-3],[],[],[],[]]

		Output
		[null,null,null,null,-3,null,0,-2]
				
		Explanation
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		minStack.getMin(); // return -3
		minStack.pop();
		minStack.top();    // return 0
		minStack.getMin(); // return -2
		*/
		
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());
		// minStack.getMin(); // return -3
		minStack.pop();
		System.out.println(minStack.top());
		// minStack.top();    // return 0
		System.out.println(minStack.getMin());
		// minStack.getMin(); // return -2
	}
	
    public MinStack() {
    	list = new int[30001];
    	pointer = -1;
    }
    
    public void push(int val) {
        list[++pointer] = val;
    }
    
    public void pop() { // Á¦°Å
        pointer--;
    }
    
    public int top() {
        return list[pointer];
    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE;
    	for(int i=pointer; i>=0; i--) {
    		min = Math.min(min, list[i]);
    	}
    	return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */