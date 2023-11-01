package Chapter3.section2;

public class DeadlinedEvent extends Event{
    public MyDate deadline;

    public DeadlinedEvent(String title, MyDate deadline) {
        super(title);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "DeadlinedEvent{" +
                "title='" + title + '\'' +
                ", deadline=" + deadline.toString() +
                '}';
    }
}
