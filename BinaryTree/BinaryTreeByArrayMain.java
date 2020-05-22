package binaryTree;

public class BinaryTreeByArrayMain {

	public static void main(String[] args) {
		
		//creating a blank array to store tree
		BinaryTreeByArray tree=new BinaryTreeByArray(10);
		
		System.out.println("inserting 5 values");
		for(int i=1;i<=5;i++) {
			tree.insert(i);
		}
		tree.search(5);
		tree.search(6);
		//tree.levelOrder();
		tree.preOrder(0);
		tree.deleteNode(4);
		tree.search(4);

	}

}
