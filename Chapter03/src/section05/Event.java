package section05;

public abstract class Event implements Comparable{
	public String title;

	public Event(String title) {
		this.title = title;
	}
	
	public abstract boolean isReleveant(MyDate date);
	public abstract MyDate getRepresentativeDate();
	
	public int compareTo(Object other) {
		MyDate myDate = getRepresentativeDate();
		MyDate targetDate = ((Event)other).getRepresentativeDate();
		return myDate.compareTo(targetDate);
	}
}
