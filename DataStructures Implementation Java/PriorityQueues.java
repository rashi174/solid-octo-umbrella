package datastructures;

public class PriorityQueues {
	static int[] heap = new int[100];
	static int size = -1;

	// Swap function
	static void swap(int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	// returns the index of the parent of given node
	static int parent(int node) {
		return (node - 1) / 2;
	}

	static int leftChild(int node) {
		return ((2 * node) + 1);
	}

	static int rightChild(int node) {
		return ((2 * node) + 2);
	}

	// shift up

	static void shiftUp(int node) {
		while (node > 0 && heap[parent(node)] > heap[node]) {
			swap(parent(node), node);
			node = parent(node);
		}
	}

	static void shiftDown(int node) {
		int maxIndex = node;

		// Left Child
		int l = leftChild(node);

		if (l <= size && heap[l] < heap[maxIndex]) {
			maxIndex = l;
		}

		// right Child
		int r = rightChild(node);

		if (r <= size && heap[r] < heap[maxIndex]) {
			maxIndex = r;
		}

		// If node not same as maxIndex
		if (node != maxIndex) {
			swap(node, maxIndex);
			shiftDown(maxIndex);
		}
	}
	// iterator for PQs

	void iterator() {
		for (int i = 0; i <= size; i++) {
			System.out.println(heap[i]);
		}
	}

	// insert new element
	void enqueue(int element) {
		size = size + 1;
		heap[size] = element;
		shiftUp(size); // to maintain the property of heaps
	}

	// dequeue max or high priority element

	int dequeue() {
		int high = heap[0];
		heap[0] = heap[size]; // replace last value with root
		size--;
		shiftDown(0);
		return high;
	}

	// peeks highest priority element
	int peek() {
		return heap[0];
	}

	// size of the heap
	int size() {
		return size + 1;
	}

	// Print/Traverse

	void print() {
		System.out.print("Priority Queue: ");
		for (int i = 0; i <= size; i++) {
			System.out.print(heap[i] + " ");
		}
		System.out.println();
	}

	boolean contains(int value) {
		for (int i = 0; i <= size; i++) {
			if (heap[i] == value) {
				System.out.println("Priority Queue contains " + value);
				return true;
			}
		}
		System.out.println("Priority Queue doesn't contains " + value);
		return false;
	}

	void reverse() {
		// PriorityQueues rpq = new PriorityQueues();

		for (int i = 0; i <= size; i++) {
			heap[i] = -1 * heap[i];
			shiftUp(i);
		}
	}

	public static void main(String[] args) {
		PriorityQueues pq = new PriorityQueues();
		pq.enqueue(45);
		pq.enqueue(20);
		pq.enqueue(14);
		pq.enqueue(12);
		pq.enqueue(31);
		pq.enqueue(7);
		pq.enqueue(11);
		pq.enqueue(13);
		pq.enqueue(7);
		pq.print();
		System.out.println("Highest priority Element is " + pq.peek());
		pq.reverse();
		pq.print();
		System.out.println("Highest priority Element is " + -(pq.peek()));

	}
	

}
