package binaryTree;

public class BinarySearchTreeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// creating object of our own created binary tree
		BinarySearchTree tree =new BinarySearchTree();
		
		//testing our implementation with examples
		//inserting 6 values
		for(int i=1;i<=6;i++) {
			tree.insert(i);
		}
		tree.search(5);
		tree.deleteNode(4);
		tree.search(5);

	}

}
