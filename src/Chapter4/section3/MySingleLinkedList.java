package Chapter4.section3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class MySingleLinkedList<T> {
    /*
        Single Linked(단방향), Doubley Linked(양방향)

        인터페이스와 구현의 분리
        - 연결 리스트는 "리스트"라는 추상적인 데이터 타입을 구현하는 한 가지 방법일 뿐이다. (가령 배열 혹은 ArrayList는 또 다른 구현 방법의 예시이다.)
        - 사용자는 리스트에 데이터를 삽입, 삭제, 검색할 수 있으면 된다. 그것의 구현에 대해서는 세부적으로 알 필요가 없다.
            # 사용자가 필요로 하는 이런 기능들을 public method들로 제공한다. 이 public method들은 가능한 한 내부 구현과 독립적이여야 한다.
        - 인터페이스와 구현을 분리하면 코드의 모듈성(modularity)가 증가하며, 코드의 유지/보수, 코드의 재사용이 용이해진다.
    */

    private Node<T> head; // 첫번째 node를 head라 부른다.
    private int size;

    // inner class
    private static class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data) {
            this.data = data;
            next = null;
        }
    }

    public Iterator<T> iterator(){
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private Node<T> nextNode;
        public MyIterator() {
            nextNode = head;
        }

        @Override
        public void remove() {

        }

        @Override
        public boolean hasNext() {
            return (nextNode != null);
        }

        @Override
        public T next() {
            if(nextNode == null) {
                throw new NoSuchElementException();
            }
            T val = nextNode.data;
            nextNode = nextNode.next;
            return val;
        }
    }

    public MySingleLinkedList() {
        head = null;
        size = 0;
    }

    private void addFirst( T item) {
        Node<T> newNode = new Node<T>(item); // T : type parameter, OK
        newNode.next = head; // 새로운 노드의 다음 주소를 현재 head로 되어있는 노드의 주소를 입력
        head = newNode; // head의 주소를 새로운 노드로 지정
        size++; // 리스트의 길이를 1추가
        /*  NOT OK (문법적 오류)
            T t = new T();
            T [] array = new T [100];
            Node<T> [] arr = new Node<T>[100];
        */

    }

    private void addAfter(Node<T> before, T item){
        Node<T> temp = new Node<>(item);
        temp.next = before.next;
        before.next = temp;
        size++;
    }

    private T removeFirst(){
        if(head == null) {
            return null;
        } else {
            T temp = head.data;
            head = head.next;
            size--;
            return temp;
        }
    }

    private T removeAfter(Node<T> before){ // 단순연결리스트에 어떤 노드를 삭제할 때는 삭제할 노드의 바로 앞 녿의 주소가 필요하다. 삭제할 노드이 주소만으로는 삭제 할 수 없다.
        if(before.next == null) {
            return null;
        } else {
            Node<T> temp = before.next;
            before.next = before.next.next;
            size--;
            return temp.data;
        }
    }


    public void add(int index, T item) { // insert
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if(index == 0) {
            addFirst(item);
        }
        else {
            Node<T> node = getNode(index-1);
            addAfter(node, item);
        }
    }

    public T remove(int index) { // delete
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            return removeFirst();
        }
        else {
            Node<T> prev = getNode(index-1);
            return removeAfter(prev);
        }
    }

    public boolean remove(T item){
        Node<T> p = head, q = null;
        while (p != null && !p.data.equals(item)){
            q = p;
            p = p.next;
        }if (p == null) {
            return false;
        }
        if(q == null) {
            T tmp =  removeFirst();
            return (tmp != null);
        }
        else {
            T tmp =  removeAfter(q);
            return (tmp != null);
        }
    }

    private Node<T> getNode(int index) {
        if(index < 0 || index >= size) {
            return null;
        }else {
            Node<T> p = head;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
            return p;
        }
    }

    public T get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).data;
    }

    public int indexOf(T item) { // search
        Node<T> p = head;
        int index = 0;
        while (p != null) { // 연결리스트를 순회(traverse)
            if(p.data.equals(item)) {
                return index;
            }
            p = p.next;
            index++;
        }
        return -1;
    }

    public int size(){
        return size;
    }

    public static void main(String[] args) {
        MySingleLinkedList<String> list = new MySingleLinkedList<>();
        list.add(0,"Saturday");
        list.add(1, "Friday");
        list.add(0, "Monday");
        list.add(2,"Tuesday");

        String str = list.get(2); // str = "Tuesday"
        list.remove(2);
        int pos = list.indexOf("Friday");
    }
}
