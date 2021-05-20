package datastructures;

import java.util.Stack;

public class Queue {
	private static int front, rear, capacity;

	static int[] queue = new int[1000];
	static int size = -1;

	Queue(int c) {
		front = rear = 0;
		capacity = c;
		queue = new int[capacity];
	}

	// enqueue - pushing an element into the queue
	void enqueue(int value) {
		if (capacity == rear) {
			System.out.printf("\nQueue is full\n");
			return;
		}

		else {
			queue[rear] = value;
			rear++;
		}
		return;
	}

	// dequeue - removing an element from the queue

	void dequeue() {
		if (front == rear) {
			System.out.printf("\nQueue is empty\n");
			return;
		} else {
			for (int i = 0; i < rear - 1; i++) {
				queue[i] = queue[i + 1];
			}

			if (rear < capacity)
				queue[rear] = 0;

			rear--;
		}
		return;
	}

	void print() {
		int i;
		if (front == rear) {
			System.out.println("\nQueue is Empty\n ");
		}
		for (i = front; i < rear; i++) {
			System.out.println(queue[i]);
		}
	}

	void queueFront() { // peek
		if (front == rear) {
			System.out.printf("\nQueue is Empty\n");
			return;
		}
		System.out.printf("\nFront Element is: %d\n", queue[front]);
		return;
	}

	boolean contains(int value) {
		if (front == rear) {
			System.out.println("\nQueue is Empty \n");
			return false;
		}
		for (int i = front; i < rear; i++) {
			if (queue[i] == value) {
				System.out.println("\nQueue Contains\n " +value);
				return true;
			}
		}
		System.out.println("\nQueue doesn't Contains\n" +value);
		return false;
	}
	
	int size() {
		System.out.print("\nSize of the Queue is: " );
		return rear;
	}
	
	void reverse() {
        Stack<Integer> stack = new Stack<>();
        for(int i=front;i<rear;i++) {
        	stack.push(queue[i]);
        }
        int i=0;
        while(!stack.isEmpty()) {
        	queue[i] = stack.pop();
        	i++;
        }
	}
	
	void iterator() {
		int i = front;
		while(i<rear) {
			System.out.print(queue[i] + " ");
			i++;
		}
	}
	
	public static void main(String[] args) {
		Queue q = new Queue(4);

		// print Queue elements
		q.print();

		// inserting elements in the queue
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		System.out.println(q.size());
		System.out.println("Reverse the Queue");
		q.reverse();
		// print Queue elements
		q.print();

		// insert element in the queue
		q.enqueue(60);

		// print Queue elements
		q.iterator();

		q.dequeue();
		System.out.println("\n===================\n");
		q.print();
		q.queueFront();
		q.contains(30);

	}

}
