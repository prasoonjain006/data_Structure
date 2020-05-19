package binaryTree;

public class BinaryTreeByLinkedListMain {
	

	public static void main(String[] args) {
		
		// creating object of class BinaryTreeByLinkedList
		BinaryTreeByLinkedList tree = new BinaryTreeByLinkedList();
		System.out.println("inserting 10 Nodes");
		for(int i=1;i<=5;i++) {
			tree.insert(i);
		}
		tree.levelorder();
		tree.preorder(tree.root);
	
		
	

	}

}
