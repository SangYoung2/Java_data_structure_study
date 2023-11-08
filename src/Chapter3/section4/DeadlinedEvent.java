package Chapter3.section4;

public class DeadlinedEvent extends Event {
    public MyDate deadline;

    public DeadlinedEvent(String title, MyDate deadline) {
        super(title);
        this.deadline = deadline;
    }

    public boolean isRelevant(MyDate date) {
        return this.deadline.compareTo(date) >= 0;
    }

    @Override
    public String toString() {
        return "DeadlinedEvent{" +
                "title='" + title + '\'' +
                ", deadline=" + deadline.toString() +
                '}';
    }

    @Override
    public MyDate getRepresentativeDate() {
        return deadline;
    }

    @Override
    public int compareTo(Object obj) {
        return super.compareTo(obj);
    }
}
