package Chapter3.section4;

public abstract class Event { // 추상 메서드가 존재 하기에 클래스 또한 추상 클래스가 되어야 한다.
    /*
    추상 클래스
    - 추상 메서드는 선언만 있고 구현이 없는 메서드
    - 추상 메서드를 포함한 클래스는 추상 클래스
    - 추상 메서드와 추상 클래스는 키워드 abstract로 표시
    - 추상 클래스는 객체를 만들 수 없음. 따라서 서브 클래스를 만드는 용도로만 사용된다.
 */
    public String title;

    public Event(String title) {
        this.title = title;
    }

    public abstract boolean isRelevant(MyDate theDate); // 이름만 있고 내용은 없는 메서드 (추상 메서드)
}
