package linkedlist;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        System.out.println("Initialising linked list...");
        System.out.println("List: " + Arrays.toString(list.asArray()));
        list.append(3);
        System.out.println("Appended 3.");
        System.out.println("List: " + Arrays.toString(list.asArray()));
        list.append(5);
        System.out.println("Appended 5.");
        System.out.println("List: " + Arrays.toString(list.asArray()));
        list.insert(7,0);
        System.out.println("Inserted 7 at position 0.");
        System.out.println("List: " + Arrays.toString(list.asArray()));
        System.out.println("Is the list empty? " + list.isEmpty());
        System.out.println("Does the list contain 7? " + list.search(7));
        System.out.println("What's the index of the first 7 in the list? " + list.index(7));
        System.out.println("Popped the lowest element (" + list.pop() + ") from the list.");
        System.out.println("List: " + Arrays.toString(list.asArray()));
        System.out.println("Does the list contain 7? " + list.search(7));
        System.out.println("Popped the element at position 1 (" + list.pop(1) + ") from the list.");
        System.out.println("List: " + Arrays.toString(list.asArray()));
        list.remove(3);
        System.out.println("Removed the first element of value 3 from the list.");
        System.out.println("List: " + Arrays.toString(list.asArray()));
        System.out.println("Is the list empty? " + list.isEmpty());
    }
}