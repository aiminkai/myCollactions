package org.trashy;

public class LinkedFakeList<T> {

    int size = 0;
    int index = 0;
    Node <T> firstNode = null;

    public boolean add(T object) {
        if (size == 0) {
            firstNode= new Node<T>(object, null, null);
            size = 1;
            return true;
        } else {
            Node <T> lastNode = getNode(size);
            Node <T> node = new Node<T>(object, lastNode, null);
            lastNode.setNextNode(node);
            size++;
            return true;
        }
    }

    public T get(int index) {
        return getNode(index).object;
    }

    private Node<T> getNode(int index) {
        if (index == 0 && firstNode != null) {
            return firstNode;
        }
        Node<T> current = firstNode;
        for(int i = 0; i < index; i++){
            if (current.nextNode == null) {
                return current;
            }
            current = current.nextNode;
        }
        return current;
    }



    private static class Node <T> {
        T object;
        private Node<T> prevNode;
        private Node<T> nextNode;


        public Node(T object, Node<T> prevNode, Node<T> nextNode) {
           this.object = object;
            this.prevNode = prevNode;
            this.nextNode = nextNode;
        }

        public T getObject() {
            return object;
        }

        public void setObject(T object) {
            this.object = object;
        }

        public Node<T> getPrevNode() {
            return prevNode;
        }

        public void setPrevNode(Node<T> prevNode) {
            this.prevNode = prevNode;
        }

        public Node<T> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<T> nextNode) {
            this.nextNode = nextNode;
        }

    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < size; i++) {
            result.append("[").append(getNode(i).getObject().toString()).append("]");
            if(i != index-1) {
                result.append(",");
            }
        }
        return result.toString();
    }
}
