package avlTree;


import binaryTree.*;

public class AVLTree {
	BinaryNode root;
	AVLTree(){
		root=null;
	}
	public BinaryNode getRoot() {
		return root;
	}
	void insert(int value) {
		root=insert(root,value);
	}
	BinaryNode insert(BinaryNode currentNode,int value) {
		              //this is same as BST tree
		if(currentNode==null) {
			System.out.println("value "+value+" has been inserted ");
			return createNewNode(value);
		}
		else if(value<=currentNode.getValue()) {
			currentNode.setLeft(insert(currentNode.getLeft(),value));
		}
		else {
			currentNode.setRight(insert(currentNode.getRight(),value));
		}
		
		               // Now we will do AVL Tree specific code
		int balance= checkBalance(currentNode.getLeft() , currentNode.getRight() ); 					//diff b/w left and right child height
		if(balance > 1) {																				//height of left child is more
			if(checkBalance(currentNode.getLeft().getLeft(),currentNode.getLeft().getRight()) >0) {      // LL condition
				currentNode=rightRotate(currentNode);
			}
			else {              																		// LR condition
				currentNode.setLeft(leftRotate(currentNode.getLeft()));
				currentNode=rightRotate(currentNode);
			}
		}
		else if(balance<-1) {																			
			if(checkBalance(currentNode.getRight(),currentNode.getLeft())>0) {                         // RR condition
				currentNode=leftRotate(currentNode);
			}
			else {                        															  //RL condition
				currentNode.setRight(rightRotate(currentNode.getRight()));
				currentNode=leftRotate(currentNode);
			}
		}
		if(currentNode.getLeft()!=null) {
			currentNode.getLeft().setHeight(calculateHeight(currentNode.getLeft()));                  //setting height of left child
		}
		if(currentNode.getRight()!=null) {
			currentNode.getRight().setHeight(calculateHeight(currentNode.getRight()));                //setting height of right child
		}
		currentNode.setHeight(calculateHeight(currentNode));                                          //setting height of current node
		return currentNode;
}                                                                                        //end of method
	
	
	            //left Rotation
	private BinaryNode leftRotate(BinaryNode currentNode) {
		BinaryNode newNode=currentNode.getRight();
		currentNode.setRight(currentNode.getRight().getLeft());
		newNode.setLeft(currentNode);
		currentNode.setHeight(calculateHeight(currentNode));
		newNode.setHeight(calculateHeight(newNode));
		return newNode;
	}
	
	
			// Right Rotation
	private BinaryNode rightRotate(BinaryNode currentNode) {
		BinaryNode newNode=currentNode.getLeft();
		currentNode.setLeft(currentNode.getLeft().getRight());
		newNode.setRight(currentNode);
		currentNode.setHeight(calculateHeight(currentNode));
		newNode.setHeight(calculateHeight(newNode));
		return newNode;	
	}
	
	//difference between left and right child of the node
	private int checkBalance(BinaryNode rootLeft,BinaryNode rootRight) {
		if(rootLeft==null && rootRight==null) {
			return 0;
		}
		else if(rootRight==null) {
			return rootLeft.getHeight()+1;
		}
		else if(rootLeft==null) {
			return -1*( rootRight.getHeight() +1 );
		}
		else {
			return rootLeft.getHeight()-rootRight.getHeight();
		}
	}
	
	// calculating height of the node
	private int calculateHeight(BinaryNode root) {
		int l=0,r=0;
		if(root==null) {
			return 0;
		}
		if(root.getLeft()!=null) {
			l=calculateHeight(root.getLeft());
		}
		if(root.getRight()!=null) {
			r=calculateHeight(root.getRight());
		}
		return 1+Math.max(l, r);
	}
	
	// creating a new node 
	BinaryNode createNewNode(int value) {
		BinaryNode node=new BinaryNode();
		node.setValue(value);
		node.setHeight(0);                     //since it is a leaf node
		return node;
	}
	public void deleteNodeOfBST(int value) {
		System.out.println("deleting value "+value+" from the tree");
		deleteNodeOfBST(root,value);
	}
	public BinaryNode deleteNodeOfBST(BinaryNode currentNode,int value) {
		if(currentNode==null) {
			System.out.println("value does not exist");
			return null;
		}
		else if(value<currentNode.getValue()) {
			currentNode.setLeft(deleteNodeOfBST(currentNode.getLeft(),value));
		}
		else if(value>currentNode.getValue()) {
			currentNode.setRight(deleteNodeOfBST(currentNode.getRight(),value));
		}
		else {
			if(currentNode.getLeft()!=null && currentNode.getRight()!=null) {
				BinaryNode temp=currentNode;
				BinaryNode minFromRight= minNode(currentNode.getRight());
				temp.setValue(minFromRight.getValue());
				deleteNodeOfBST(currentNode.getRight(),minFromRight.getValue());
			}
			else if(currentNode.getLeft()!=null) {
				currentNode.setLeft(deleteNodeOfBST(currentNode.getLeft(), value));
			}
			else if(currentNode.getRight()!=null) {
				currentNode.setRight(deleteNodeOfBST(currentNode.getRight(), value));
			}
			else {
				currentNode=null;
			}
			return currentNode;
		}
		
		          // AVL tree specific code
		if(checkBalance(currentNode.getLeft(),currentNode.getRight())>1) {
			if( checkBalance(currentNode.getLeft().getLeft(), currentNode.getLeft().getRight() ) > 0 ) {        //LL condition
				currentNode=rightRotate(currentNode);
			}
			else {                                                                                              //LR condition 
				currentNode.setLeft(leftRotate(currentNode.getLeft()));
				currentNode=rightRotate(currentNode);
			}
		}
		else if(checkBalance(currentNode.getLeft(), currentNode.getRight()) < -1 ) {
			if(checkBalance(currentNode.getRight().getRight(), currentNode.getRight().getLeft())>0) {             // RR condition
				currentNode=leftRotate(currentNode);
			}
			else {       																					   //RL condition
				currentNode.setRight(rightRotate(currentNode.getRight()));
				currentNode=leftRotate(currentNode);
			}
		}
		if (currentNode.getLeft() != null) {                                                                 // setting height
			currentNode.getLeft().setHeight(calculateHeight(currentNode.getLeft()));
		}
		if (currentNode.getRight() != null) {
			currentNode.getRight().setHeight(calculateHeight(currentNode.getRight()));
		}
		currentNode.setHeight(calculateHeight(currentNode));
		return currentNode;			
	}
	public BinaryNode minNode(BinaryNode root) {
		if(root.getLeft()==null) {
			return root;
		}
		else {
			return minNode(root.getLeft());
		}
	}
	
	
}









