package Chapter2.Section1;

public class Code1 {
    public static void main(String[] args) {
        Person1 first = new Person1(); // Person1타입의 데이터 타입을 선언 사용자 정의 타입은 new를 늘 사용해야한다.
        // first 객체의 name필드와 number 필드에 이름과 전화번호를 각각 저장
        first.name = "John";
        first.number = "0102483120";

        System.out.println("Name: " + first.name + ", Number: " + first.number);

        Person1 [] members = new Person1 [100]; // Person1타입의 배열도 만들 수 있다.
        members[0] = first;
        members[1] = new Person1();
        members[1].name = "David";
        members[1].number = "287354832748";

        System.out.println("Name: " + members[1].name + ", Number: " + members[1].number);
    }
}
