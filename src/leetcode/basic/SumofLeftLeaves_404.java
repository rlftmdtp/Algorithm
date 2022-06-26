package leetcode.basic;

import java.util.*;

public class SumofLeftLeaves_404 {
	public static int result = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static int sumOfLeftLeaves(TreeNode root) {
    	result = 0; // �ʱ�ȭ
        inorder(root, null);
    	return result;
    }
    
    public static void inorder(TreeNode root, TreeNode parent) {
    	if(root != null) {
        	inorder(root.left, root);
            
            if(parent != null){
                // leafNode�̸鼭(�ڽ��� ����) �����ڽ��̴�
                if(root.left == null && root.right == null && root == parent.left) {
                    result += root.val;
                }   
            }
        	inorder(root.right, root);
    	}
    }
    
    public class TreeNode {
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
