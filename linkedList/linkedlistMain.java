package linkedList;


// this is to test our implementation with examples
public class linkedlistMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//creating object of our own created Linked-list
		LinkedList<Integer> ll=new LinkedList<Integer>(); 
		
		//adding Data to LinkedList
		for(int i=0;i<10;i++) {
			ll.add(i);
		}
		
		//removing first element
		ll.remFirst();
		
		
		//printing the data of all the nodes
		ll.print();
		
		
		

		
	}

}
