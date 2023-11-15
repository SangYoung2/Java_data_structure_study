package Chapter4.section4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

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
    public LinkedList<Term> terms;

    public Polynomial(char name) {
        this.name = name;
    }

    public void addTerm(int coef, int expo) {
        if(coef == 0) {
            return;
        }
        // LinkedList를 활용환 간략화
        ListIterator<Term>  iter = terms.listIterator();
        while (iter.hasNext()) {
            Term t = iter.next();
            if(t.expo == expo) {
                t.coef += coef;
                if(t.coef == 0) {
                    iter.remove();
                }
            }
            else if (t.expo < expo) {
                iter.previous(); // 한칸 앞으로 전진 후
                iter.add(new Term(coef, expo)); // 새로운 항을 추가
                return;
            }
        }
        iter.add(new Term(coef, expo)); // 새로운 항을 추가
    }

    public int calc(int x) {
        int result = 0;
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
        while (iter.hasNext()) {
            Term t = iter.next();
            result += ("+" + t.toString());
        }
        return result;
    }
}
