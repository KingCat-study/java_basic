package section02;

public class OneDayEvent extends Event{
	public MyDate date;
	
	public OneDayEvent(String title, MyDate date) {
		super(title);
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "OneDayEvent [title=" + title + ", date=" + date.toString() + "]";
	}
}
