package Chapter3.section2;

public class OneDayEvent extends Event{
    public MyDate date;

    public OneDayEvent(String title, MyDate date) {
        super(title); // 상위 클래스인 Event에 title을 전송
        this.date = date;
    }

    @Override
    public String toString() {
        return "OneDayEvent{" +
                "title='" + title + '\'' +
                ", date=" + date.toString() +
                '}';
    }
}
