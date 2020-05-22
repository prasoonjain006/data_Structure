package binaryTree;

public class BinaryTreeByArray {
	int arr[];
	int lastUsedIndex;
	
	BinaryTreeByArray(int size) {                   //constructor
		arr=new int[size+1];
		this.lastUsedIndex=0;
		System.out.println("tree has been created");
	}
	
	boolean isFull() {                             //method to check array is full or not
		if(arr.length-1==lastUsedIndex) 
			return true;
		else
			return false;
	}
	void insert(int value) {                      //method to insert value in a tree 
		if(!isFull()) {
			arr[lastUsedIndex+1]=value;
			lastUsedIndex++;
			System.out.println("value "+value+" has been inserted");
		}
		else {
			System.out.println("tree is full");
		}
	}
	
	//level order traversal of binary tree
	void levelOrder() {
		for(int i=1;i<=lastUsedIndex;i++) {
			System.out.println(arr[i]);
		}
	}//end of method
	
	// PRE- Order traversal of Binary Tree 
	//i.e  Root => Left Child => Right child
	void preOrder(int index) {
		if(index>lastUsedIndex)
			return;
		else if(index<=0) {
			System.out.println("enter value greater than 0");
			return;
		}
		else {
			System.out.println(arr[index]+" ");
			preOrder(index*2);
			preOrder(index*2+1);
		}
	}
	
	
	// POST- Order traversal of Binary Tree 
	//i.e Left Child => Right child => Root 
	void postOrder(int index) {
		if(index>lastUsedIndex)
			return;
		else {
			postOrder(index*2);
			postOrder(index*2+1);
			System.out.println(arr[index]+" ");
		}
	}
	
	
	
	// IN- Order traversal of Binary Tree 
	//i.e Left Child => Root => Right child
	void inOrder(int index) {
		if(index>lastUsedIndex)
			return;
		else {
			inOrder(index*2);
			System.out.println(arr[index]+" ");
			inOrder(index*2+1);
		}
	}
	
	
	// to search for a given value in a tree
	int search(int value) {
		for(int i=1;i<=lastUsedIndex;i++) {
			if(arr[i]==value) {
				System.out.println("the value "+ value+" has been found at location "+i);
				return i;
			}
		}
		System.out.println("value "+value+" does not exists in the tree");
		return -1;
		
	}
	void deleteNode(int value) {
		for(int i=1;i<=lastUsedIndex;i++) {
			if(arr[i]==value) {
				arr[i]=arr[lastUsedIndex];
				lastUsedIndex--;
				return;
			}
		}
		System.out.println("value not found");
	}
	void deleteTree() {
		arr=null;
		System.out.println("tree has been deleted");
	}
	

}



























