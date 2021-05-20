package datastructures;

class LinkedList {

	Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static void main(String[] args) {
		LinkedList List = new LinkedList();
		insert(List, 1);
		insert(List, 2);
		insert(List, 3);
		insert(List, 4);

		insertAtPosition(List, 4, 5);
		insertAtPosition(List, 5, 6);
		insertAtPosition(List, 6, 7);
		print(List);
		System.out.println("Middle element of linkedList: " + middleElement(List));
		System.out.println("Length of linkedList: " + lengthOfList(List));
		print(List);
		deleteNode(List, 6);
		print(List);
		deleteFromPosition(List, 1);
		print(List);
		print(iterator(List, 2));
		
	}

//Print a linkedlist

	private static void print(LinkedList List) {
		Node head = List.head;
		System.out.print("LinkedList: ");
		while (head.next != null) {
			System.out.print(head.data);
			System.out.print("->");
			head = head.next;
		}
		System.out.println(head.data);
	}

//insert in a linkedlist at the end

	private static LinkedList insert(LinkedList List, int data) {

		Node New_Node = new Node(data);
		New_Node.next = null;
		// check if linkedlist is empty

		if (List.head == null) {
			List.head = New_Node;
		}

		// Traverse till end of the linkedlist and insert the node at the end.
		else {
			Node temp = List.head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = New_Node;
		}
		return List;

	}

//insert at the specific position

	private static LinkedList insertAtPosition(LinkedList List, int position, int data) {
		Node New_Node = new Node(data);
		New_Node.next = null;

		// check if head is poinitng to null

		if (List.head == null) {
			List.head = New_Node;

		} else if (position == 0) {
			New_Node.next = List.head;
			List.head = New_Node;
		} else {
			Node temp = List.head;
			for (int i = 0; i < position - 1; i++) {
				temp = temp.next;
			}
			Node nextval;
			nextval = temp.next;
			temp.next = New_Node;
			New_Node.next = nextval;

		}
		// System.out.println("After Inserting in Linked List at position " + position);
		return List;

	}

//Get Middle Node of the LinkedList
	private static int middleElement(LinkedList List) {
		// Turtle Hare or floyd warshalls algorithm
		Node turtle = List.head;
		Node hare = List.head;
		while (hare.next != null && hare.next.next != null) {
			turtle = turtle.next;
			hare = hare.next.next;
		}
		return turtle.data;
	}

// Get size or length of the linked list

	private static int lengthOfList(LinkedList List) {
		Node temp = List.head;
		int size = 0;
		while (temp != null) {
			size++;
			temp = temp.next;
		}
		return size;
	}

//delete node from the linkedlist with given value -- assuming node to be deleted is surely present in linkedlist

	private static LinkedList deleteNode(LinkedList List, int value) {

		// if head is to be deleted
		if (List.head.data == value) {
			List.head = List.head.next;
		}

		// search for node to be deleted
		else {
			Node temp = List.head;
			while (temp.next.data != value) {
				temp = temp.next;
			}
			temp.next = temp.next.next;
		}
		return List;
	}

//Delete node at a specific position

	private static LinkedList deleteFromPosition(LinkedList List, int position) {
		if (position == 0) {
			List.head = List.head.next;
		} else {
			Node temp = List.head;
			for (int i = 0; i < position - 1; i++) {
				temp = temp.next;
			}
			temp.next = temp.next.next;
		}
		return List;
	}

//Iterator in a Linkedlist

	private static LinkedList iterator(LinkedList List, int position) {
		LinkedList iteratedList = new LinkedList();
		Node temp = List.head;
		for (int i = 0; i < position; i++) {
			temp = temp.next;
		}
		iteratedList.head = temp;
		return iteratedList;

	}
}