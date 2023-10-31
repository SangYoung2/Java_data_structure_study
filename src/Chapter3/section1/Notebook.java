package Chapter3.section1;

public class Notebook extends Computer{
    /*
    - 생성자가 없을 경우 자동으로 no-parameter 생성자가 만들어진다. 생성자가 하나라도 있을 경우 자동으로 만들어 지지않는다.
    - 모든 서브 클래스의 생성자는 먼저 수퍼클래스의 생성자를 호출한다.
        > spuer(...)를 통해 명시적으로 호출
        > 그렇지 않을 경우에는 자동으로 no-parameter 생성자가 호출
    - 흔한 오류: 수퍼클래스에 no-parameter 생성자가 없는데, 서브클래스의 생성자에서 super(...) 호출을 안해주는 경우

    다형성
    - 수퍼클래스 타입의 변수(참조변수)가 서브클래스 타입의 객체를 참조할 수 있다.
        > ex) Computer theComputer = new Notebook("Bravo", "Intel", 4, 240, 2/4, 15.07.5)
        > Computer 타입의 변수 theComputer가 Notebook 타입의 객체를 참고
        > Computer와 Notebook 클래스는 둘 다 toString을 가지고 있다. 실행 시 Notebook의 toString이 실행된다 (동적 바인딩 발생)
        > Notebook test2 = new Computer로는 선언 할 수가없다.
    */
    public double screenSize;
    public double weight;

    public Notebook(String manufacturer, String processor, int ramSize, int diskSize, double processorSpeed, double screenSize, double weight) {
        super(manufacturer, processor, ramSize, diskSize, processorSpeed);
        this.screenSize = screenSize;
        this.weight = weight;
    }

    @Override // 부모 클래스의 toString을 자식 클래스에서 Override하여 자식만의 toString으로 수정할 수 있다.
    public String toString() {
        String result = super.toString() +
                ", screenSize=" + screenSize + "inch" +
                ", weight=" + weight + "kg";
        return result;
    }

    public static void main(String[] args) {

        Computer test = new Notebook("Dell", "i5", 4, 1000, 3.2, 15.6, 1.2); // 타입은 Computer이지만 참조는 Notebook을 하고있다.
        System.out.println(test.toString()); // static binding vs dynamic binding 자바는 동적바인딩(dynamic binding)

    }
}
