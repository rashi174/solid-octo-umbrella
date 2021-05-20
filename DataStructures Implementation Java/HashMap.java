package datastructures;

public class HashMap {
	ListNode[] nodes = new ListNode[10000];

	private int get(int key) {
		int index = getIndex(key);
		ListNode prev = findElement(index, key);
		return prev.next == null ? -1 : prev.next.val;
	}

	boolean contains(int key) {
		int index = getIndex(key);
		ListNode prev = findElement(index, key);
		return prev.next == null ? false : true;

	}

	private void put(int key, int value) {
		int index = getIndex(key);
		ListNode prev = findElement(index, key);

		if (prev.next == null)
			prev.next = new ListNode(key, value);
		else
			prev.next.val = value;
	}

	private void remove(int key) {
		int index = getIndex(key);
		ListNode prev = findElement(index, key);

		if (prev.next != null)
			prev.next = prev.next.next;
	}

	void print() {
		System.out.print("{");
		for (ListNode temp : nodes) {
			if (temp != null) {
				while (temp != null) {
					if (temp.key != -1) {
						System.out.print(temp.key + ": " + temp.val + ", ");
					}
					temp = temp.next;
				}
			}
		}
		System.out.print("}");

	}

	private int size() {
		int counter = 0;
		for (ListNode temp : nodes) {
			if (temp == null) {
				continue;
			}
			counter++;
		}
		return counter;
	}

	void iterator() {
		System.out.print("{");
		for (ListNode temp : nodes) {
			if (temp != null) {
				while (temp != null) {
					if (temp.key != -1) {
						System.out.print(temp.key + ": " + temp.val + ", ");
					}
					temp = temp.next;
				}
			}
		}
		System.out.print("}");
	}

	private int getIndex(int key) {
		return Integer.hashCode(key) % nodes.length;
	}

	private ListNode findElement(int index, int key) {
		if (nodes[index] == null)
			return nodes[index] = new ListNode(-1, -1);

		ListNode prev = nodes[index];

		while (prev.next != null && prev.next.key != key) {
			prev = prev.next;
		}
		return prev;
	}

	private static class ListNode {
		int key, val;
		ListNode next;

		ListNode(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put(1, 5);
		map.put(2, 5);
		map.put(1, 15);
		map.put(3, 5);
		map.put(4, 5);
		map.print();
		int key = 1;
		boolean flag = map.contains(key);
		if (flag) {
			System.out.println("\nHashMap contains " + key);
		} else {
			System.out.println("\nHashmap doesn't contains " + key);
		}
		System.out.println("Size of HashTable is: " + map.size());
		System.out.println("Value of the key " + key +" is : " + map.get(key));
		map.remove(1);
		map.iterator();

	}
}