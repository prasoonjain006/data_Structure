package binaryTree;



public class BinarySearchTree {
	BinaryNode root;
	public BinarySearchTree() {
		root=null;
	}
	public BinaryNode getRoot() {
		return root;
	}
	
	
	//function to create new node in BST
	BinaryNode createNode(int value) {
		BinaryNode node=new BinaryNode();
		node.setValue(value);
		return node;
	}
	
	//helper function to insert value in a node
	void insert(int value) {
		root=insert(root,value);
	}
	
	//function to insert a value in a binary search tree
	BinaryNode insert(BinaryNode currentNode,int value) {
		if(currentNode==null) {
			System.out.println("successfully inserted value "+value);
			return createNode(value);
		}
		else if(value<=currentNode.getValue()) {							//if the value to be deleted is less than node value we move to left child
			currentNode.setLeft(insert(currentNode.getLeft(),value));
			return currentNode;
		}
		else{
			currentNode.setRight(insert(currentNode.getRight(),value));		//if the value to be deleted is more than node value we move to right child
			return currentNode;
		}
	}
	
	
	
	public void deleteNode(int value) {
		System.out.println("deleting "+value+" from the tree");
		deleteNodeFromTree(root,value);
	}
	//function to delete the given node 
	public BinaryNode deleteNodeFromTree(BinaryNode root,int value) {
		if(root==null) {
			System.out.println("value not found ");
			return null;
		}
		if(value<root.getValue()) {
			root.setLeft(deleteNodeFromTree(root.getLeft(), value));
		}
		else if(value>root.getValue()) {
			root.setRight(deleteNodeFromTree(root.getRight(), value));
		}
		
		// three cases
		else {
			if(root.getLeft()!=null && root.getRight()!=null) {                 //when node has both the child ## case 1               
			//	BinaryNode temp =root;
				BinaryNode MinFromRightNode=minNode(root.getRight());
				root.setValue(MinFromRightNode.getValue());
				root.setRight(deleteNodeFromTree(root.getRight(), MinFromRightNode.getValue()));	
			}
			if(root.getLeft()!=null) {                                         //when node has only left child ## case 2
				root=root.getLeft();
			}
			if(root.getRight()!=null) {
				root=root.getRight();                                          //when root has only right child ## case 2
			}
			else {
				root=null;
			}		
		}
		return root;
	}
	
	//this will return the node with minimum value
	public BinaryNode minNode(BinaryNode root) {
		if(root.getLeft()==null) {
			return root;
		}
		else {
			return minNode(root.getLeft());
		}
	}
	
	void search(int value) {
		search(root,value);
	}
	
	public BinaryNode search(BinaryNode root,int value) {
		if(root==null) {
			System.out.println("value "+value+" not found in tree");
			return null;
		}
		else if(value<root.getValue()) {
			return search(root.getLeft(),value);
		}
		else if(value>root.getValue()) {
			return search(root.getRight(),value);
		}
		else {
			System.out.println(value+" has been found");
			return root;
		}
	}
	
	
	
	
	
	
	
	
	

}
