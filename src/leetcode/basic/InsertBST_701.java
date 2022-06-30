package leetcode.basic;

import leetcode.basic.BinaryTreeRightSideView_199.TreeNode;

public class InsertBST_701 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//[61,46,66,43,null,null,null,39,null,null,null]
//88
//Output
//[61,46,66,43,null,88,null,39]
//Expected
//[61,46,66,43,null,null,88,39]
	}
	
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
    	// 1.���, 2.�ݺ���
    	// insert(root, null, val); ��ͷ� Ǯ���� �� if(root == parent.left) ������ �Ѵ� null �̴�.
    	
    	TreeNode head = root;
    	TreeNode parent = null;
    	
    	while(true) {
    		if(head == null) return new TreeNode(val);
    		
    		// ���� �̵�
    		if(val < head.val) {
    			parent = head;
    			head = head.left;
    			
    			if(head == null) {
    				head = new TreeNode(val);
    				parent.left = head;
    				break;
    			}
    		}else {
    			parent = head;
    			head = head.right;
    			
    			if(head == null) {
    				head = new TreeNode(val);
    				parent.right = head;
    				break;
    			}
    		}
    	}
    	return root;
    }

}
