package Chapter3.section2;

public class DurationEvent extends Event {
    public MyDate begin;
    public MyDate end;

    public DurationEvent(String title, MyDate begin, MyDate end) {
        super(title);
        this.begin = begin;
        this.end = end;
    }

    @Override
    public String toString() {
        return "DurationEvent{" +
                "title='" + title + '\'' +
                begin.toString() + " ~ " + end.toString() +
                '}';
    }
}
