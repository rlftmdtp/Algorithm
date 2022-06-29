package leetcode.basic;

public class MyStack {
    private int list[];
	private int pointer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Input
		["MyStack", "push", "push", "top", "pop", "empty"]
		[[], [1], [2], [], [], []]
		Output
		[null, null, null, 2, 2, false]

		Explanation
		MyStack myStack = new MyStack();
		myStack.push(1);
		myStack.push(2);
		myStack.top(); // return 2
		myStack.pop(); // return 2
		myStack.empty(); // return False
		*/
	}
	
    public MyStack() {
    	list = new int[101];
    	pointer = -1;
    }
    
    public void push(int x) {
        list[pointer++] = x;
    }
    
    public int pop() {
        return list[pointer--];
    }
    
    public int top() {
        return list[pointer];
    }
    
    public boolean empty() {
        if(pointer == -1) return false;
        else return true;
    }

}
