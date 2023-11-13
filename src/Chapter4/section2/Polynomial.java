package Chapter4.section2;

import Chapter4.section1.MySingleLinkedList;
import Chapter4.section1.Node;

public class Polynomial {

    public char name;
    public MySingleLinkedList<Term> terms = new MySingleLinkedList<>();

    public Polynomial(char name) {
        this.name = name;
    }

    public void addTerm(int coef, int expo) {
        if(coef == 0) {
            return;
        }

        Node<Term>  p = terms.head, q = null;
        while (p != null && p.data.expo > expo) {
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

        Node<Term>  p = terms.head;
        while (p != null) {
            result += p.data.calc(x);
            p = p.next;
        }
        return result;
    }

    public String toString(){
        String result = "";
        Node<Term>  p = terms.head;
        while (p != null) {
            result += ("+" + p.data.toString());
            p = p.next;
        }
        return result;
    }
}
