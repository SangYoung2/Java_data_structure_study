package Chapter3.section4_2;

public interface MyComparable {
    /*
    인터페이스
    - 추상 메서드만을 가진 순수한 추상 클래스
    - 다른 클래스에서 interface를 사용할 때에는 extends(상속)이 아닌 implements(구현)을 사용한다.
    - 자바에서는 다중 extends을 허용하지 않지만 여러개를 implements하는 것은 가능하다.
    */
    int compareTo(Object obj);
}
