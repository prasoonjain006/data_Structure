package Stack;


//importing the linkedlist package which we have created earlier
import linkedList.LinkedList;

public class stackbyLinkedList {
	LinkedList<Integer> list;
	
	public stackbyLinkedList() {
		list =new LinkedList<Integer>();
	}
	void push(int value) {
		list.addFirst(value);
		System.out.println("pushed "+ value+" to the stack");
		
	}
	int pop() {
		return list.remFirst();

	}
	
		
}


