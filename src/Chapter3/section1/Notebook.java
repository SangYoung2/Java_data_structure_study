package Chapter3.section1;

public class Notebook extends Computer{
    /*
    - 생성자가 없을 경우 자동으로 no-parameter 생성자가 만들어진다. 생성자가 하나라도 있을 경우 자동으로 만들어 지지않는다.
    - 모든 서브 클래스의 생성자는 먼저 수퍼클래스의 생성자를 호출한다.
        > spuer(...)를 통해 명시적으로 호출
        > 그렇지 않을 경우에는 자동으로 no-parameter 생성자가 호출
    - 흔한 오류: 수퍼클래스에 no-parameter 생성자가 없는데, 서브클래스의 생성자에서 super(...) 호출을 안해주는 경우
    */

    public double screenSize;
    public double weight;

    public Notebook(String manufacturer, String processor, int ramSize, int diskSize, double processorSpeed, double screenSize, double weight) {
        super(manufacturer, processor, ramSize, diskSize, processorSpeed);
        this.screenSize = screenSize;
        this.weight = weight;
    }

    public Notebook() {}


    public static void main(String[] args) {
        Notebook test = new Notebook();
        test.manufacturer = "Dell";
        test.processor = "i5";
        test.ramSize = 4;
        test.diskSize = 1000;
        test.processorSpeed = 3.2;

        test.screenSize = 15.6;
        test.weight = 1.2;


    }
}
