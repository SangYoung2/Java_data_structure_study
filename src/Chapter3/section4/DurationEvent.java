package Chapter3.section4;

public class DurationEvent extends Event {
    public MyDate begin;
    public MyDate end;

    public DurationEvent(String title, MyDate begin, MyDate end) {
        super(title);
        this.begin = begin;
        this.end = end;
    }

    public boolean isRelevant(MyDate date) { // begin <= date <= end
        return begin.compareTo(date) <= 0 && end.compareTo(date) >= 0;
    }

    @Override
    public String toString() {
        return "DurationEvent{" +
                "title='" + title + '\'' +
                begin.toString() + " ~ " + end.toString() +
                '}';
    }

    @Override
    public MyDate getRepresentativeDate() {
        return begin;
    }
}
