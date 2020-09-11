package section01;

//상속
public class NoteBook extends Computer{

	private double screenSize;
	private double weight;
	
	public NoteBook(String manufacturer, String processor, int ramSize, int discSize, double processorSpeed, double screenSize, double weight) {
		super(manufacturer, processor, ramSize, discSize, processorSpeed);
		
		this.screenSize = screenSize;
		this.weight = weight;
	}

	public double getScreenSize() {
		return screenSize;
	}
	
	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "NoteBook [screenSize=" + screenSize + ", weight=" + weight + ", toString()=" + super.toString() + "]";
	}
	
}
