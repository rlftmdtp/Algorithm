package leetcode.basic;

import leetcode.basic.BinaryTreeRightSideView_199.TreeNode;

public class InsertBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

[61,46,66,43,null,null,null,39,null,null,null]
88
Output
[61,46,66,43,null,88,null,39]
Expected
[61,46,66,43,null,null,88,39]
	}
	
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
    	// 1.Àç±Í, 2.¹Ýº¹¹®
    	insert(root, null, val);
    	
    	return root;
    }
    
    public void insert(TreeNode root, TreeNode parent, int val) {
    	if(root == null && parent == null) root = new TreeNode(val);
    	else if(root == null) {
    		if(root == parent.left) parent.left = new TreeNode(val);
    		else parent.right = new TreeNode(val);
    	}else {
    		if(root.val > val) insert(root.left, root, val);
    		else insert(root.right, root, val);
    	}
    }

}
