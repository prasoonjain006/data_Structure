package binaryTree;
import java.util.*;

public class BinaryTreeByLinkedList {
	BinaryNode root;
	//constructor
	public BinaryTreeByLinkedList() {   
		this.root=null;
	}
	// inserting a value in the tree
	void insert(int value) {
		BinaryNode node=new BinaryNode();
		node.setValue(value);
		if(root==null) {
			root=node;
			System.out.println("Node has been inserted ");
			return;
		}
		else {
			Queue<BinaryNode> queue=new LinkedList<BinaryNode>();     // creating object of Linked List 
			queue.add(root);										  // adding the root element in the queue
			while(!queue.isEmpty()) {
				BinaryNode presentNode=queue.remove();
				if(presentNode.getLeft()==null) {
					presentNode.setLeft(node);
					System.out.println("root inserted suucessfully");
					break;
				}
				else if(presentNode.getRight()==null) {
					presentNode.setRight(node);
					System.out.println("root inserted suucessfully");
					break;
				}
				else {
					queue.add(presentNode.getLeft());
					queue.add(presentNode.getRight());
				}	
			}	
		}
	}
	
	// to search for a given value in a tree
	void search(int value) {
		Queue<BinaryNode> queue=new LinkedList<BinaryNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryNode presentNode =queue.remove();
			if(presentNode.getValue()==value) {
				System.out.println("value "+ value +" has been found");
				return;
			}
			else {
				if(presentNode.getLeft()!=null) {
					queue.add(presentNode.getLeft());
				}
				if(presentNode.getRight()!=null) {
					queue.add(presentNode.getRight());
				}
			}	
		}
		System.out.println("value "+ value+ "not found");
	}
	
	// this will return the deepest node of the tree
	public BinaryNode getDeepestNode() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		BinaryNode presentNode=null;
		while(!queue.isEmpty()) {
			presentNode = queue.remove();
			if(presentNode.getLeft()!=null) {
				queue.add(presentNode.getLeft());
			}
			else if(presentNode.getRight()!=null) {
				queue.add(presentNode.getRight());
			}
		}
		return presentNode;
	}
	
	public void deleteDeepestNode() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		BinaryNode presentNode = null;
		while(!queue.isEmpty()) {
			presentNode = queue.remove();
			if(presentNode.getLeft()!=null) {
				queue.add(presentNode.getLeft());
			}
			else if(presentNode.getRight()!=null) {
				queue.add(presentNode.getRight());
			}
		}
		System.out.println(presentNode.getValue());
		presentNode=null;
	}
	
	
	// to delete the node of binary tree of the given value
	public void deleteNode(int value) {
		Queue<BinaryNode> queue= new LinkedList<BinaryNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryNode presentNode=queue.remove();
			if(presentNode.getValue()==value) {
				presentNode.setValue(getDeepestNode().getValue());
				deleteDeepestNode();
				System.out.println("deleted the node");
				return;
			}
			else {
				if(presentNode.getLeft()!=null) {
					queue.add(presentNode.getLeft());
				}
				if(presentNode.getRight()!=null) {
					queue.add(presentNode.getRight());
				}
			}
		}
		System.out.println("value not found ");
	}
	
	
	// PRE- Order traversal of Binary Tree 
	//i.e  Root => Left Child => Right child
	void preorder(BinaryNode node) {
		if(node==null) {
			return;
		}
		System.out.println(node.getValue()+" ");
		preorder(node.getLeft());
		preorder(node.getRight());
	}
	
	
	
	// POST- Order traversal of Binary Tree 
	//i.e Left Child => Right child => Root 
	void postorder(BinaryNode node) {
		if(node==null) {
			return;
		}
		preorder(node.getLeft());
		preorder(node.getRight());
		System.out.println(node.getValue()+" ");	
	}
	
	// IN- Order traversal of Binary Tree 
	//i.e Left Child => Root => Right child 
	void inorder(BinaryNode node) {
		if(node==null) {
			return;
		}
		preorder(node.getLeft());
		System.out.println(node.getValue()+" ");
		preorder(node.getRight());	
	}
	
	
	// LEVEL - Order traversal of the tree
	// traversing by horizontal level , starting from the top 
	void levelorder() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			System.out.println(presentNode.getValue());
			if(presentNode.getLeft()!=null) {
				queue.add(presentNode.getLeft());
			}
			if(presentNode.getRight()!=null) {
				queue.add(presentNode.getRight());
			}
		}	
	}
	void deleteTree() {
		root=null;
		System.out.println("tree has been deleted successfully");
	}
		

	
	
	
	
	
	
	
}




























