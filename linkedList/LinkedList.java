package linkedList;


//Implemantation of linked List 
public class LinkedList<E>{
	Node<E> head;
	
	// this will add the node to the end of Linked-List
	void add(E data) {
		Node<E> toAdd = new Node<E>(data);
		Node<E> temp=head;							
		if(head==null) {
			head=toAdd;
			return;
		}
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=toAdd;
	}
	
	//to add new Node at the starting i.e before the head node
	public void addFirst(E data) {
		Node<E> toAdd = new Node<E>(data);
		toAdd.next=head;
		head=toAdd;
	}
	
	//printing the data of all the node starting from head node
	void print() {
		Node<E> temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}
	
	//to remove head node
	public int remFirst() {
		Node<E> temp=head;
		if(head==null) {
			System.out.println("cannot remove from empty list");
			return 0;
		}
		else {
			head=head.next;	
			return (int) temp.data;
		}
		
	}



}
