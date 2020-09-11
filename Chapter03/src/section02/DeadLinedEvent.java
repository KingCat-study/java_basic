package section02;

public class DeadLinedEvent  extends Event{
	public MyDate deadLine;
	
	public DeadLinedEvent(String title, MyDate deadLine) {
		super(title);
		this.deadLine = deadLine;
	}

	@Override
	public String toString() {
		return "DeadLinedEvent [title=" + title + ", deadLine=" + deadLine.toString() + "]";
	}
	
}
