package leetcode.basic;

import java.util.*;

import leetcode.basic.BinaryTreeZigzag_103.TreeNode;

public class BinaryTreeRightSideView_199 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<Integer> rightSideView(TreeNode root) {
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	q.add(root);
    	
    	List<Integer> list = new ArrayList<Integer>();
        if(root == null) return list;
    	while(!q.isEmpty()) {
    		int size = q.size();
    		
    		for(int i=0; i<size; i++) {
    			TreeNode curNode = q.poll();
    			
    			if(i == 0) list.add(curNode.val);
    			if(curNode.right != null) q.add(curNode.right);
    			if(curNode.left != null) q.add(curNode.left);
    		}
    	}
    	
        return list;
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
	
	    


