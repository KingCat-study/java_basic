package section04;

public abstract class Event {
	public String title;

	public Event(String title) {
		this.title = title;
	}
	
	public abstract boolean isReleveant(MyDate date);
}
