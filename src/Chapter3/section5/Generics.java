package Chapter3.section5;

public class Generics {
    /*
        Generic Programming
        - 제네릭 프로그래밍은 데이터 형식에 의존하지 않고, 하나의 값이 여러 다른 데이터 타입들을 가질 수 있는 기술에 중점을 두어 재사용성을 높일 수 있는 프로그래밍 방식
        - 자바에서 제네릭(generic)이란 데이터의 타입(data type)을 일반화한다(generalize)는 것을 의미합니다.
            제네릭은 클래스나 메소드에서 사용할 내부 데이터 타입을 컴파일 시에 미리 지정하는 방법입니다.
            이렇게 컴파일 시에 미리 타입 검사(type check)를 수행하면 다음과 같은 장점을 가집니다.
            1. 클래스나 메소드 내부에서 사용되는 객체의 타입 안정성을 높일 수 있습니다
            2. 반환값에 대한 타입 변환 및 타입 검사에 들어가는 노력을 줄일 수 있습니다.
     */
    
    public class Box<T>{ // T라는 가상의 타입에 의해서 parameterized된 클래스
        private T t;
        public void set(T t){this.t = t;}
        public T get(){return t;}
    }
}
