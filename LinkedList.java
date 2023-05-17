import org.w3c.dom.Node;

public class LinkedList<T> {

    private class Node<T> {
        private T info;
        private Node<T> next;

        public Node(T info) {
            this.info = info;
        }

        public T getInfo() {
            return info;
        }

        public void setInfo(T info) {
            this.info = info;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
    
    private Node<T> head;

    public LinkedList() {
        head = new Node<T>(null);
    }

    public void addLast(T info) {
        Node<T> newNode = new Node<T>(info);
        Node<T> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
    }

    public Node<T> removeFirst() {
        if (head.getNext() == null) {
            return null;
        }
        Node<T> element = head.getNext();
        head.setNext(head.getNext().getNext());
        return element;
    }

}