package Chapter3.section4;

import java.util.Scanner;

public class Scheduler {

    /*
    oneday, duration, deadline 세가지의 이벤트에 공통 상위 클래스로 Event를 생성하여 extends(상속) 하여
    event객체의 list로 생성하여 각 칸마다 Event를 상속받고있는 다른 타입의 클래스들을 Event배열 안에 넣을 수 있다.
     */
    private int capacity = 10;
    public Event[] events = new Event[10];
    public int n = 0;
    private Scanner input;

    public void processCommand(){
        input = new Scanner(System.in);
        while (true) {
            System.out.print("$ ");
            String command = input.next();
            if(command.equals("addevent")) {
                String type = input.next();
                if(type.equalsIgnoreCase("oneday")){
                    handleAddOneDayEvent();
                }
                else if(type.equalsIgnoreCase("oneday")){
                    handleAddDurationEvent();
                }
                else if(type.equalsIgnoreCase("oneday")){
                    handleAddDeadlinedEvent();
                }
            }
            else if(command.equals("list")) {
                handleList();
            }
            else if(command.equals("show")) {
                handleShow();
            }
            else if(command.equals("exit")) {
                break;
            }
        }
        input.close();
    }

    private void handleShow() {
        String dateString = input.next();
        MyDate theDate = parseDataString(dateString);
        for (int i = 0; i < n; i++) {
            // test if events[i] is relevant to the date, then print it (events 배열안에 dataString 과 겹치는 부분이 있는지 검사, 있으면 출력)
            /*
            event배열 안에있는 객체들은 oneDay와 같은 event클래스를 extends하고 있는 객체들이 들어있지만,
            컴파일러는 그것을 알지 못하기에 event클래스 안에 isRelevant라는 메서드가 존재 하지않기에 오류가 발생
            그렇기에 event클래스 안에 isRelevant라는 추상메서드를 생성
            */
            if(events[i].isRelevant(theDate)){
                System.out.println(events[i].toString());
            }
        }
    }

    private void handleList() { // 등록되어 있는 모든 event를 화면에 출력
        for (int i = 0; i < n; i++) {
            System.out.println("     " + events[i].toString()); // dynamic binding
        }
    }

    private void handleAddDeadlinedEvent() {

    }

    private void handleAddDurationEvent() {

    }

    private void handleAddOneDayEvent() {
        System.out.print("  when: ");
        String dateString = input.next();
        MyDate date = parseDataString(dateString);
        System.out.print("  title: ");
        String title = input.next();

        OneDayEvent ev = new OneDayEvent(title, date);
        System.out.println(ev.toString());
        addProgram(ev);
        events[n++] = ev; // events는 Event타입의 객체 이지만 oneDatEvent가 Event의 서브클래스이기에 super클래스인 Event 객체의 배열 안에 넣을 수 있다.

    }

    private void addProgram(Event ev) {
        if(n >= capacity) { // 배열의 크기가 capacity와 같아지면 배열 재할당을 실행
            reallocate();
        }
        events[n++] = ev; // events는 Event타입의 객체 이지만 oneDatEvent가 Event의 서브클래스이기에 super클래스인 Event 객체의 배열 안에 넣을 수 있다.
    }

    // 배열 재할당(Array Reallocation) - 배열의 크기가 부족할 때 새로운 배열을 만들어 기존 배열의 값을 새로운 배열로 옮겨서 배열의 크기를 늘림
    private void reallocate(){
        Event[] tmpArray = new Event[capacity * 2];
        for (int i = 0; i < n; i++) {
            tmpArray[i] = events[i];
        }
        events = tmpArray;
        capacity *= 2;
    }


    private MyDate parseDataString(String dateString) { // "1995/08/20"
        /*
        split - "1995/08/20" 라는 String 객체를 "/"를 기준으로 나뉘어 "1995", "08", "20"로 나뉘어 배열로 반환해준다.(토큰화)
        "."같은 경우에는 "//."로 입력을 해야 "."으로 구분하여 나눈다. (다른 방식으로 구분하고 싶으면 정규식 표현을 참조)
         */
        String[] token = dateString.split("/");
        int year = Integer.parseInt(token[0]); // String을 int로 변환
        int month = Integer.parseInt(token[1]); // String을 int로 변환
        int day = Integer.parseInt(token[2]); // String을 int로 변환

        MyDate d = new MyDate(year, month, day);
        return d;
    }

    public static void main(String[] args) {
        Scheduler app = new Scheduler();
        app.processCommand();
    }
    
    

     
}
