package Chapter4.section3;

import Chapter4.section1.Node;

import java.util.Iterator;

public class Polynomial {

    /*
        연결리스트에서의 Iterator
        - Iterator는 개념적으로는 연결리스트의 노드와 노드 사이를 가리킨다.
        - 초기상태의 iterator는 첫 번째 노드의 앞 위치를 가리킨다.
        - next()메서드는 한 칸 전진하면서 방금 지나친 노드의 데이터를 반환
        - haseNext() 메서드는 다음 노드가 존재하면 true, 그렇지 않으면 false를 반환한다.
        - remove() 메서드는 가장 최근에 next() 메서드로 반환한 노드를 삭제한다.
     */

    public char name;
    public MySingleLinkedList<Term> terms = new MySingleLinkedList<>();

    public Polynomial(char name) {
        this.name = name;
    }

    public void addTerm(int coef, int expo) {
        if(coef == 0) {
            return;
        }

        Iterator<Term>  p = terms.iterator(), q = null;
        Term t = null;
        int index = 0;
        while (p.hasNext()) {
            q = p; // p의 이전 노드
            p = p.next;
        }

        if( p != null && p.data.expo == expo) {
            p.data.coef += coef;
            if(p.data.coef == 0){ // data의 coef 값과 입력된 coef값을 더했을 때 0이 되면 node를 삭제
                if(q == null) {
                    terms.removeFirst();
                }
                terms.removeAfter(q);
            }
        } else { // add after q
            Term t = new Term(coef, expo);
            if(q == null) { // 맨 앞일 경우에는 맨 앞에 추가
                terms.addFirst(t);
            }else {
                terms.addAfter(q, t); // q뒤에 t 객체를 추가
            }
        }
    }

    public int calc(int x) {
        int result = 0;

//        Node<Term>  p = terms.head;
//        while (p != null) {
//            result += p.data.calc(x);
//            p = p.next;
//        }
        Iterator<Term> iter = terms.iterator(); // iterator를 사용해 LinkedList의 다음 값이 있는지 확인하여 그 값의 정보를 가져온다.
        while (iter.hasNext()){
            Term t = iter.next();
            result += t.calc(x);
        }
        return result;
    }

    public String toString(){
        String result = "";
        Iterator<Term> iter = terms.iterator();
//        Node<Term>  p = terms.head;
//        while (p != null) {
//            result += ("+" + p.data.toString());
//            p = p.next;
//        }
        while (iter.hasNext()) {
            Term t = iter.next();
            result += ("+" + t.toString());
        }
        return result;
    }
}
