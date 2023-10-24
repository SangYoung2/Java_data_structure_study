package Chapter2.section3;

public class Test {
    /*
     클래스는 타입이다. 설계도일뿐 실체가 없다.
     클래스의 데이터 필드에 데이터를 저장할 수는 없으며, 클래스의 멤버 메서드를 실행할 수도 없다.
     new명령으로 해당클래스 타입의 객체를 생성 후, 해당 객체에 데이터를 저장하고, 그 객체의 멤버 메서드를 실행하는 것
     허나 static을 선언시에는 예외로 취급한다. static멤버는 클래스 안에 실재로 존재
     static 멤버의 용도
     - main 메서드
     - 상수 혹은 클래스 당 하나만 유지하고 있으면 되는 값 (혹은 객체)
        ex) Math.Pi, System.out
     - 순수하게 기능만으로 정의되는 메서드. 대표적인 예로 수학함수들
        ex) Math.abs(), Math.sqrt(n), Math.min(a,b)
    */

    public static int s = 0; // static을 선언하였기에 실체가 존재 (class 멤버) ex) Test.s = 100;
    public int t = 0; // Test객체를 생성하여 객체(object)내에서 사용 (object 멤버) ex) Test test1 = new Test() -> test1.t = 100

    public static void print1() {
        System.out.println("s = " + s);
//        System.out.println("t = " + t); // non-static이기 때문에 Test 객체를 생성해야만 사용할 수 있다.
    }

    public void print2() { // Test객체를 선언하여 객체를 생성 후 print2가 생성 되는 것이기에 오류가 발생하지 않는다. (설계도일뿐 실체x)
        System.out.println("s = " + s);
        System.out.println("t = " + t);
    }

    public static void main(String[] args) {
        s = 100;
//        t = 100;
        print1();
//        print2(); 객체를 생성하지 않았기에 오류 발생

        Test test1 = new Test();
        test1.t = 100;
        test1.print2();
    }
}
