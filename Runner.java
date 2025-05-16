import java.util.*;

public class Runner {

    public static void main(String[] args) {

        CircularSinglyLinkedList list = new CircularSinglyLinkedList();
        for (int i = 11; i < 40; i += 2) {
            list.add(i);
        }

        System.out.println(list);

        System.out.println("\nTesting distanceFrom");
        System.out.println("distanceFromHead(11) = " + list.distanceFromHead(11));  // 1
        System.out.println("distanceFromHead(33) = " + list.distanceFromHead(33));  // 12
        System.out.println("distanceFromHead(39) = " + list.distanceFromHead(39));  // 15
        System.out.println("distanceFromHead(10) = " + list.distanceFromHead(10));  // -1

        System.out.println("\nTesting remove");
        System.out.println("remove(17) = " + list.remove(17)); // true
        System.out.println("remove(11) = " + list.remove(11)); // true
        System.out.println("remove(11) = " + list.remove(11)); // false
        System.out.println("remove(39) = " + list.remove(39)); // true
        System.out.println("remove(20) = " + list.remove(20)); // false

        System.out.println();
        System.out.println(list);

        // create a circular, nonCircular, and cycle
        CircularSinglyLinkedList circular = new CircularSinglyLinkedList();
        CircularSinglyLinkedList nonCircular = new CircularSinglyLinkedList();
        CircularSinglyLinkedList cycle = new CircularSinglyLinkedList();

        int size = 20;
        Node middleNode = null, nonCircularTail, cycleTail;
        for (int i = 1; i <= size; i++) {
            circular.add(i);

            if (i == size / 2) {
                middleNode = cycle.add(i);
            } else if (i == size) {
                nonCircularTail = nonCircular.add(i);
                nonCircularTail.next = null;
                cycleTail = cycle.add(i);
                cycleTail.next = middleNode;
            } else {
                nonCircular.add(i);
                cycle.add(i);
            }
        }

        System.out.println("\nTesting hasCycle");
        System.out.print("Circular list:    ");
        System.out.println(circular.hasCycle(circular.head));        // true
        System.out.print("nonCircular list: ");
        System.out.println(nonCircular.hasCycle(nonCircular.head));  // false
        System.out.print("list with cycle:  ");
        System.out.println(cycle.hasCycle(cycle.head));              // true


		CircularSinglyLinkedList list2 = new CircularSinglyLinkedList();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.remove(1);
		list2.remove(2);
		list2.remove(3);

		System.out.println(list2);
    }
}
