
public class BinarySearchTree {
	public Node rootNode;
	
	public class Node{
		int val;
		Node left;
		Node right;
		
		public Node() {};
		public Node(int val) {
			this.val = val;
		}
	}
	
	public boolean search(int val) {
		Node currentNode = rootNode;
		
		while(currentNode != null) {
			if(currentNode.val == val) return true;
			else if(currentNode.val > val) currentNode = currentNode.left;
			else currentNode = currentNode.right;
		}
		return false;
	}
	
	public void insert(int val) {
		if(rootNode == null) rootNode = new Node(val);
		else {
			Node currentNode = rootNode;
			Node parentNode = null;
			
			while(true) {
				parentNode = currentNode;
				
				if(currentNode.val > val) { // ���� �̵�
					currentNode = currentNode.left;
					
					if(currentNode == null) {
						parentNode.left = new Node(val);
						return;
					}
				}else {
					currentNode = currentNode.right;
					
					if(currentNode == null) {
						parentNode.right = new Node(val);
						return;
					}
				}
			}
		}
	}
	
	public boolean delete(int val) {
		
		// �����ؾ��ϴ� ��带 ã�´�
		Node removeNode = rootNode;
		Node removedParent = null;
		
		while(removeNode.val != val) {
			removedParent = removeNode;
			if(removeNode.val > val) removeNode = removeNode.left;
			else removeNode = removeNode.right;
			
			if(removeNode == null) return false;
		}
		
		// �ڽ� 0
		if(removeNode.left == null && removeNode.right == null) {
			 
		}else if(removeNode.right == null) {  // ���� �ڽĳ�� �ϳ� ����
			
		}else if(removeNode.left == null) { // ������ �ڽĳ�� �ϳ� ����
			
		}else { // �ڽ�2�� ����
			
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(1);
		bst.insert(2);
		bst.insert(3);
		
		System.out.println(bst.search(1));
		System.out.println(bst.search(4));
	}

}
