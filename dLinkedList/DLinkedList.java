package ru.hse.edu.sc.y2020.dLinkedList;

public class DLinkedList<T> implements MyList<T> {
    private DNode<T> head;
    public DNode<T> getHead() {
        return head;
    }

    private DNode<T> tail;
    public DNode<T> getTail() {
        return tail;
    }

    private int count;
    public int getCount() {
        return count;
    }

    @Override
    public T get(int index) {
        if (count == 0) {
            throw new IndexOutOfBoundsException("List if empty");
        } else if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException(String.format("Index given (%d) out of bounds [0; %d]", index, count - 1));
        } else {
            int tempIndex = 0;
            DNode<T> nodeToGet = head;

            while (tempIndex != index) {
                nodeToGet = nodeToGet.getNext();
                tempIndex++;
            }

            return nodeToGet.getValue();
        }
    }

    @Override
    public void addFirst(T value) {
        DNode<T> nodeToAdd = new DNode<>(value);

        if (count == 0) {
            head = tail = nodeToAdd;
        } else {
            DNode<T> tempNode = head;

            head = nodeToAdd;
            head.setNext(tempNode);
            tempNode.setPrev(head);
        }

        count++;
    }

    @Override
    public void addLast(T value) {
        DNode<T> nodeToAdd = new DNode<>(value);

        if (count == 0) {
            head = tail = nodeToAdd;
        } else {
            tail.setNext(nodeToAdd);
            nodeToAdd.setPrev(tail);
            tail = nodeToAdd;
        }

        count++;
    }

    @Override
    public void add(T value, int index) {
        if (index > 0 || index < count) {
            int tempIndex = 0;
            DNode<T> nodeToAdd = new DNode<>(value);
            DNode<T> prevNode = head;

            while (tempIndex != index) {
                prevNode = prevNode.getNext();
                tempIndex++;
            }

            nodeToAdd.setPrev(prevNode);
            nodeToAdd.setNext(prevNode.getNext());
            nodeToAdd.getNext().setPrev(nodeToAdd);
            nodeToAdd.getPrev().setNext(nodeToAdd);
        } else {
            throw new IndexOutOfBoundsException(String.format("Index given (%d) out of bounds [0; %d]", index, count - 1));
        }
    }

    @Override
    public void removeFirst() {
        if (count != 0) {
            head = head.getNext();
            head.setPrev(null);

            count--;

            if (count == 0) {
                head = tail = null;
            }
        } else {
            throw new IndexOutOfBoundsException("List if empty");
        }
    }

    @Override
    public void removeLast() {
        if (count != 0) {
            tail = tail.getPrev();
            tail.setNext(null);

            count--;

            if (count == 0) {
                head = tail = null;
            }
        } else {
            throw new IndexOutOfBoundsException("List if empty");
        }
    }

    @Override
    public void remove(int index) {
        if (count == 0) {
            throw new IndexOutOfBoundsException("List if empty");
        } else if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException(String.format("Index given (%d) out of bounds [0; %d]", index, count - 1));
        } else {
            int tempIndex = 0;
            DNode<T> nodeToRemove = head;

            while (tempIndex != index) {
                nodeToRemove = nodeToRemove.getNext();
                tempIndex++;
            }

            nodeToRemove.getPrev().setNext(nodeToRemove.getNext());
            nodeToRemove.getNext().setPrev(nodeToRemove.getPrev());

            nodeToRemove = null;
        }
    }

    @Override
    public boolean contains(T value) {
        if (count != 0) {
            DNode<T> currNode = head;

            while (currNode != null) {
                if (currNode.getValue().equals(value)) {
                    return true;
                }

                currNode = currNode.getNext();
            }

            return false;
        } else {
            throw new IndexOutOfBoundsException("List if empty");
        }
    }
}
