public class Node<E> {
    // instance variables
    E element;
    Node<E> next;

    public Node(E e) {
        element = e;
        next = null;
    }

    @Override
    public String toString() {
        return "" + element;
    }
}