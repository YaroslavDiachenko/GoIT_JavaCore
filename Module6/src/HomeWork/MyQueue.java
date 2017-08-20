package HomeWork;


public class MyQueue<E> {
    private int size = 0;
    private Node<E> first;
    private Node<E> last;

    public MyQueue() {}

    public void add(E value) {
        final Node<E> oldLast = last;
        final Node<E> addedNode = new Node(oldLast,value,null);
        last = addedNode;
        if(first == null) first = addedNode;
        else oldLast.next = addedNode;
        size++;
    }

    public void remove() {
        if (size == 0) System.out.println("List is empty");
        else {
            if (first.prev == null) first = last = null;
            else {
                first.next.prev = null;
                first.item = null;
                first = first.next;
            }
            size--;
        }
    }

    public void clear() {
        if (size == 0) System.out.println("List is already empty");
        Node<E> element = first;
        do {
            Node<E> next = element.next;
            element.item = null;
            element.next = null;
            element.prev = null;
            element = next;
        } while (element != null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        Node<E> node = findNodeByIndex(index);
        if (node != null) return node.item;
        return null;
    }

    public E pick() {
        if (size == 0) System.out.println("List is empty");
        else return first.item;
        return null;
    }

    public E poll() {
        E element = pick();
        if (element != null) remove();
        return element;
    }

    public Node<E> findNodeByIndex(int index) {
        Node<E> searchedElement = first;

        if (index < 0) System.out.println("Illegal index");
        else if (size == 0) System.out.println("List is empty");
        else if (index >= size) System.out.println("Missing element");
        else {

            // define element by sequence number
            if (index < size / 2) {
                searchedElement = first;
                for (int i = 0; i < index; i++) {
                    searchedElement = searchedElement.next;
                }
            } else {
                searchedElement = last;
                for (int i = size - 1; i < index; i--) {
                    searchedElement = searchedElement.prev;
                }
            }
            return searchedElement;
        }
        return null;
    }

    public void show() {
        if (size == 0) System.out.println("List is empty");
        else {
            Node<E> element = first;
            do {
                if(element.next != null) System.out.print(element.item + ", ");
                else System.out.println(element.item);
                element = element.next;
            } while (element != null);
        }
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
