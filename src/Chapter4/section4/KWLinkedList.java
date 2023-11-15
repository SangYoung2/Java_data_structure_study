package Chapter4.section4;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class KWLinkedList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size;

    public static class Node<T> {
        public T data;
        public Node<T> next;
        public Node<T> prev;

        public Node(T item) {
            data = item;
            next = null;
        }
    }

    public Iterator<E> iterator() {
        return new KWListIterator(0);
    }

    public ListIterator<E> listIterator() {
        return new KWListIterator(0);
    }

    public ListIterator<E> listIterator(int index) {
        return new KWListIterator(0);
    }

    private class KWListIterator implements ListIterator<E> {
        // data member and construct
        private Node<E> nextItem;
        private Node<E> lastItemReturned;
        private int index;

        public KWListIterator(int i) {
            if( i < 0 || i > size) {
                throw new IndexOutOfBoundsException("Ivalid index" + i);
            }
            lastItemReturned = null;
            if(i == size) {
                index = size;
                nextItem = null;
            }
            else {
                nextItem = head;
                for (index = 0; index < i; index++) {
                    nextItem = nextItem.next;
                }
            }
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            lastItemReturned = nextItem;
            nextItem = nextItem.next;
            index++;
            return lastItemReturned.data;
        }

        @Override
        public boolean hasPrevious() {
            return (nextItem == null && size != 0) || nextItem.prev != null;
        }

        @Override
        public E previous() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            if(nextItem == null) {
                nextItem = tail;
            }
            else {
                nextItem = nextItem.prev;
            }
            lastItemReturned = nextItem;
            index--;
            return lastItemReturned.data;
        }

        @Override
        public int nextIndex() {
            return index;
        }

        @Override
        public int previousIndex() {
            return index-1;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(E e) {

        }

        @Override
        public void add(E e) {
            if(head == null) {
                head = new Node<>(e);
                tail = head;
            }
            else if (nextItem == head) {
                Node<E> newNode = new Node<>(e);
                newNode.next = nextItem;
                nextItem.prev = newNode;
                head = newNode;
            }
            else if (nextItem == null) {
                Node<E> newNode = new Node<>(e);
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            else {
                Node<E> newNode = new Node<>(e);
                newNode.prev = nextItem.prev;
                nextItem.prev.next = newNode;
                newNode.next = nextItem;
                nextItem.prev = newNode;
            }
            size++;
            index++;
        }
    }

    public int indexOf(E item) {
        return 0;
    }

    public void add(int index, E item) {
        listIterator(index).add(item);
    }

    public E get (int index) {
        return listIterator(index).next();
    }

    public boolean remove(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        ListIterator<E> iter = listIterator(index);
        E result = iter.next();
        iter.remove();
//        return result;
        return false;
    }

    public int size() {
        return size;
    }
}
