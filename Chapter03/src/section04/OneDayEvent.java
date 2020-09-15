package section04;

public class OneDayEvent extends Event{
	public MyDate date;
	
	public OneDayEvent(String title, MyDate date) {
		super(title);
		this.date = date;
	}
	
	public boolean isReleveant(MyDate date) {
		return this.date.compareTo(date) == 0;
	}
	
	@Override
	public String toString() {
		return "OneDayEvent [title=" + title + ", date=" + date.toString() + "]";
	}

	@Override
	public MyDate getRepresentativeDate() {
		return date;
	}
}
