package Stack;

public class StackByArray {
	int topOfStack;                                          //declaring variables
	int arr[];
	
	public StackByArray(int size) {                           //constructor 
		this.arr=new int[size];
		this.topOfStack=-1;
		System.out.println("created an array of size "+size);
	}
	
	//Adding element at the top of stack
	public void push(int value) {
		if(isfullStack())
			System.out.println("array is full, cannot push at position "+topOfStack);
		else {
			arr[topOfStack+1]=value;
			topOfStack++;
			System.out.println("Successfully inserted "+value+" at position "+topOfStack);	
		}
	}
	// Remove Top element from stack
	public void pop() {
		if(isemptyStack())
			System.out.println("Stack is empty cannot remove a element ");
		else {
			topOfStack--;
			System.out.println("successfully removed element "+arr[topOfStack+1]);
		}
	}
	public boolean isemptyStack() {
		if(topOfStack==-1)
			return true;
		else
			return false;
	}
	public boolean isfullStack() {
		if(topOfStack==arr.length-1)
			return true;
		else
			return false;
	}
	//Return top element of the stack
	public void peek() {
		if(isemptyStack())
			System.out.println("cannot peek empty stack");
		else
			System.out.println("element at top is: "+arr[topOfStack]);
	}
	public void deleteStack() {
		arr=null;
		System.out.println("successfully  deleted the entire stack");
	}
	

}













