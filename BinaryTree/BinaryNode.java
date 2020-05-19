package binaryTree;

public class BinaryNode {
	private int height;
	private int value;
	private BinaryNode left;
	private BinaryNode right;
	
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getHeight() {
		return height;
	}
	public void setValue(int value) {
		this.value=value;
	}
	public int getValue() {
		return value;
	}
	public BinaryNode getLeft() {
		return left;
	}
	public void setLeft(BinaryNode left) {
		this.left=left;
	}
	public BinaryNode getRight() {
		return right;
	}
	public void setRight(BinaryNode right) {
		this.right=right;
	}
}

