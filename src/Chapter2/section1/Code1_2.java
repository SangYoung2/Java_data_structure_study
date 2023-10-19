package Chapter2.section1;

public class Code1_2 {
    public static void main(String[] args) {
        Person1 first = new Person1(); // Person1타입의 데이터 타입을 선언 사용자 정의 타입은 new를 늘 사용해야한다.
        // first 객체의 name필드와 number 필드에 이름과 전화번호를 각각 저장
        first.name = "John";
        first.number = "0102483120";

        Person1 second = first; // new Person()이 아닌 first를 입력함으로 써 second의 주소는 first의 주소를 복사한다. (동일한 객체의 주소를 가진다.)
        second.name = "Tom"; // 그러므로 second라는 새로운 Person객체가 아니고 first의 주소를 가지고 있기에 first의 name 값에 "Tom"이 입력된다.

        System.out.println("Name: " + first.name + ", Number: " + first.number);

        Person1 [] members = new Person1 [100]; // Person1타입의 배열도 만들 수 있다. (Person[i]에 name 이나 number 값을 직접 넣을수는 없으며 객체의 주소를 저장 할 수 있다.)
        members[0] = first;
        members[1] = second;

        System.out.println("Name: " + members[0].name + ", Number: " + members[0].number);
        System.out.println("Name: " + members[1].name + ", Number: " + members[1].number);
    }
}
