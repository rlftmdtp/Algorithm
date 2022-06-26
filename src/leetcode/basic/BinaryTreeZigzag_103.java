package leetcode.basic;

import java.util.*;

public class BinaryTreeZigzag_103 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Input: root = [3,9,20,null,null,15,7] 
		 * Output: [[3],[20,9],[15,7]]
		 */
	}
	
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
    	Queue<TreeNode> q = new LinkedList<>();
    	q.add(root);
    	
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(root == null) return result;
    	// 첫 시작 오른쪽에서 왼쪽
    	boolean right = false;
    	while(!q.isEmpty()) {
    		int size = q.size();
    		List<Integer> list = new ArrayList<Integer>();
    		Stack<Integer> st = new Stack<Integer>();
    		for(int i=0; i<size; i++) {
    			TreeNode curNode = q.poll();
    			if(right) list.add(curNode.val);
    			else {
    				// 거꾸로 처리
    				st.add(curNode.val);
    			}
    			
				if(curNode.right != null) q.add(curNode.right);
				if(curNode.left != null) q.add(curNode.left);

    		}
    		
    		while(st.size() != 0) list.add(st.pop());
    		if(right) right = false;
    		else right = true;
    		
    		result.add(list);
    	}
    
    	return result;
    }
    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
