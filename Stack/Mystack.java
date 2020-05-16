package Stack;

public class Mystack {

	public static void main(String[] args) {

		System.out.println("creating a stack");
		StackByArray stackObj =new StackByArray(6);   //creating a new object of array
		stackObj.push(1);
		stackObj.push(2);
		stackObj.push(3);
		stackObj.push(4);
		stackObj.push(5);
		stackObj.push(6);
		stackObj.peek();
		stackObj.pop();
		stackObj.peek();
		stackObj.deleteStack();
		stackObj.push(6);
		
		
		
		
		
		
		
	}

}
