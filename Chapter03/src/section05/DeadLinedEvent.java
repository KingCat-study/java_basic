package section05;

public class DeadLinedEvent  extends Event{
	public MyDate deadLine;
	
	public DeadLinedEvent(String title, MyDate deadLine) {
		super(title);
		this.deadLine = deadLine;
	}

	public boolean isReleveant(MyDate date) {
		return deadLine.compareTo(date) >= 0;
	}
	
	@Override
	public String toString() {
		return "DeadLinedEvent [title=" + title + ", deadLine=" + deadLine.toString() + "]";
	}

	@Override
	public MyDate getRepresentativeDate() {
		return deadLine;
	}
}
