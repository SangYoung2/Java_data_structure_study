package Chapter4.section1;

public class MySingleLinkedList<T> {
    /*
        Single Linked(단방향), Doubley Linked(양방향)
    */

    public Node<T> head; // 첫번째 node를 head라 부른다.
    public int size;

    public MySingleLinkedList() {
        head = null;
        size = 0;
    }

    public void addFirst( T item) {
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

    public void addAfter(Node<T> before, T item){
        Node<T> temp = new Node<>(item);
        temp.next = before.next;
        before.next = temp;
        size++;
    }

    public T removeFirst(){
        if(head == null) {
            return null;
        } else {
            T temp = head.data;
            head = head.next;
            size--;
            return temp;
        }
    }

    public T removeAfter(Node<T> before){ // 단순연결리스트에 어떤 노드를 삭제할 때는 삭제할 노드의 바로 앞 녿의 주소가 필요하다. 삭제할 노드이 주소만으로는 삭제 할 수 없다.
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
            return;
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
            return null;
        }
        if(index == 0){
            return removeFirst();
        }
        else {
            Node<T> prev = getNode(index-1);
            return removeAfter(prev);
        }
    }

    public T remove(T item){
        Node<T> p = head;
        Node<T> q = null;
        while (p != null && !p.data.equals(item)){
            q = p;
            p = p.next;
        }if (p == null) {
            return null;
        }
        if(q == null) {
            return removeFirst();
        }
        else {
            return removeAfter(q);
        }
    }

    public Node<T> getNode(int index) {
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
            return null;
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
