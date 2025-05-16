public class CircularSinglyLinkedList {

   /**
    * Node head is the only instance variable 
    * you should have.
    */
    public Node head = null;

   /**
     * Adds a new Node at the end of the circular 
     * Linked List. There is no tail or prev 
     * references so you will need to loop through
     * the list to find the last Node that points
     * to back to head. The new Node's next field
     * should refer to the head. Return the new
     * Node added to the linked list.
     */
    public Node add(int num) {
		// if list is empty
		if (head == null) {
			head = new Node(num);
			head.next = head;
			return head;
		}

		Node current = head;
		while (current.next != head) {
			current = current.next;
		}

		Node newNode = new Node(num);

		current.next = newNode;
		newNode.next = head;

		return newNode;
    }

    /**
     * Returns the distance from head to the 
     * next Node containing the given value. 
     * For example, if the value of num is 
     * at the head then 1 is returned. 
     * Returns -1 if num is not found.
     */
    public int distanceFromHead(int num) {
		// if empty
		if (head == null) {
			return -1;
		}

		// if head.data == num
		if (head.data == num) {
			return 1;
		}

		int count = 0;

		Node current = head.next;
		while (current != head) {
			count++;
			if (current.data == num) {
				return count + 1;
			}
			current = current.next;
		}

		return -1;
    }

    /**
     * Removes the first occurrence of the 
     * given num and returns true otherwise
     * returns false.
     */
    public boolean remove(int num) {
		// if empty
		if (head == null) {
			return false;
		}

		Node current = head;

		// if head matches
		if (head.data == num) {
			// go to the last node
			while (current.next != head) {
				current = current.next;
			}
			if (head.next == head) {
				head = null;
				return true;
			}
			head = head.next;
			current.next = head;
			return true;
			
		}

		// if head doesn't match
		while (current.next != head) {
			// if num matches
			if (current.next.data == num) {
				current.next = current.next.next;
				return true;
			}

			current = current.next;
		}

		return false;
    }

    /**
     * Returns true if the given linked list is 
     * circular or has a cycle. A circular 
     * linked list has the last node referring
     * to the head. A linked list containing a 
     * cycle has a node referring to a previous
     * node (other than head) in the linked list. 
     */
    public static boolean hasCycle(Node otherHead) {
		// if empty
		if (otherHead == null) {
			return false;
		}
		
		Node slow = otherHead;
		Node fast = otherHead;

		while (slow.next != null && fast.next != null && fast.next.next != null) {
			if (slow == null || fast == null) {
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;

			// if both equal
			if (slow == fast) {
				return true;
			}
		}

		return false;
    }

    /**
     * The toString method should return a String 
     * containing all of the integers in the list
     * in the correct order staring with the value
     * at the head. For example.  [7, 23, 17, 19]
     */
    public String toString() {
		// if empty
		if (head == null) {
			return "[]";
		}

		String text = "[";

		Node current = head;
		while (current.next != head) {
			text += current.data + ", ";
			current = current.next;
		}

		text += current.data + "]";

		return text;
    }


}
