package Chapter3.section2;

import java.util.Scanner;

public class Scheduler {

    /*
    oneday, duration, deadline 세가지의 이벤트에 공통 상위 클래스로 Event를 생성하여 extends(상속) 하여
    event객체의 list로 생성하여 각 칸마다 Event를 상속받고있는 다른 타입의 클래스들을 Event배열 안에 넣을 수 있다.
     */
    public Event[] events = new Event[100];
    public int n = 0;

    int n1 = 0, n2 = 0, n3 = 0;

    public void processCommand(){
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("$ ");
            String command = input.next();
            if(command.equals("addevent")) {

            }
            else if(command.equals("list")) {

            }
            else if(command.equals("show")) {

            }
            else if(command.equals("exit")) {
                break;
            }
        }
        input.close();
    }

    public static void main(String[] args) {
        Scheduler app = new Scheduler();
        app.processCommand();
    }
}
