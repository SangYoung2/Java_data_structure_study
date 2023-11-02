package Chapter3.section3;

public class Test {
    /*
     - 클래스 Object는 Java에서 모든 클래스의 superclass이다.
     - class Obaject의 멤버 메서드
        > boolean equals(Object obj)
        > int hashCode()
        > String toString()
        > Class<?> getClass()
     - Java의 모든 클래스는 내가 만들어 주지 않아도 이미 equals과 toString메서드를 가지고 있다.
     - 다만 내 의도대로 작동하지는 않을 것이다.
     */

    /*
    - Java에서 primitive type 데이터와 non-primitive type 데이터, 즉 객체는 근본적으로 다르게 처리된다.
    - 가령 Object 타입의 배열에는 다형성의 우너리에 의해서 모든 종류의 객체를 저장할 수 있다.
      하지만 int, double, char등의 primitive type 데이터는 저장할 수 없다. 객체가 아니기에..
    - 때때로 primitive type 데이터를 객체로 만들어야 할 경우가 있다.
      이럴 때 Integer, Double, Character 등의 wrapper class를 이용한다.
        > wrapper class는 primitive type의 객체를 감싸서 객체로 만들어 준다.
     */

    public int a = 10;
    public double x= 1.23;

    public boolean equals(Object other){
        Test other2 = (Test)other;  // 타입 캐스팅은 기존 객체를 지정한 객체로 바꿔주는 것이다.
        return a == other2.a && x == other2.x;
    }

    public static void main(String[] args) {
//        Test test1 = new Test();
//        Test test2 = new Test();
//
//        System.out.println(test1.toString());
//
//        if( test2.equals(test1)){
//            System.out.println("Yes");
//        }
//        else {
//            System.out.println("no");
//        }

        Object[] array = new Object[100];
        int a = 20; // int로 만든 a는 array 안에 들어갈 수 없음.
        Integer age = new Integer(a); // Integer로 a를 감싸면 array안에 넣을 수 있음.
        array[0] = age;

        int b = age.intValue(); // unwrapping - 감싸고 있던 Integer를 풀어냄
        array[1] = b; // java에는 Autoboxing 과 Unboxing 기능이 있어 Java에서 자동으로 변환하여 해주기 때문에 굳이 Integer를 사용하여 감싸줄 필요는 없다.

        System.out.println(array[0]);
    }
}
