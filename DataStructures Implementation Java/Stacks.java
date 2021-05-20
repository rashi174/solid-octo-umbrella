package datastructures;

public class Stacks {

	int size;
	int array[];
	int top;

	Stacks(int size) {
		this.size = size;
		this.array = new int[size];
		this.top = -1;
	}

//Check if stack is full
	boolean isFull() {
		return (size - 1 == top);
	}

//check if stack is empty
	boolean isEmpty() {
		return (top == -1);
	}

//Pushing an Element into the stack
	void push(int Element) {
		if (isFull()) {
			System.out.println("Stack OverFlow (Stack is Full) ");
		} else {
			top++;
			array[top] = Element;
			System.out.println(Element + " Pushed into the Stack");
		}
	}

//Pop an Element from stack
	int pop() {
		if (isEmpty()) {
			System.out.println("Stack UnderFlow(Stack is Empty)");
			return -1;
		} else {
			int popedtop = top;
			top--;
			System.out.println(array[popedtop] + " Popped from the stack");
			return array[popedtop];
		}
	}

//Contains an Element in stack

	boolean contains(int val) {
		if (top < 0) {
			System.out.println("Stack Underflow");
			return false;
		} else {
			for (int i = 0; i < array.length; i++) {
				if (array[i] == val) {
					System.out.println("Stack contains " + val);
					return true;
				}

			}
			System.out.println("Stack doesn't contain " + val);
			return false;
		}
	}

//peek an element
	int peek() {
		if (isEmpty()) {
			System.out.println("stack is Empty");
			return -1;
		} else {
			return array[top];
		}
	}

	// size of stack
	int length() {
		return top + 1;
	}

	// Traverse/print the stack
	void print() {
		int length = top + 1;
		for (int i = 0; i < length; i++) {
			System.out.println(array[i]);
		}
	}
	// Reverse a stack

	void reverse() {
		int n = top + 1;
		int i, t;
		for (i = 0; i < n / 2; i++) {
			t = array[i];
			array[i] = array[n - i - 1];
			array[n - i - 1] = t;
		}

	}
	
	//Iterator
	void iterator() {
		for (int i=0;i<top+1;i++) {
			System.out.println(array[i]);
		}
	}

	public static void main(String[] args) {
		Stacks stack = new Stacks(10);
		System.out.println("=====================");
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println("=====================");
		stack.reverse();
		stack.print();
		System.out.println("=====================");
		System.out.println("length of stack " + stack.length());
		stack.pop();
		stack.pop();
		stack.iterator();
		System.out.println("Peeking into stack " + stack.peek());
		stack.contains(2);
		stack.contains(20);
		System.out.println("length of stack " + stack.length());

	}

}
