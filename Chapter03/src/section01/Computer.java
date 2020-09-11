package section01;

public class Computer {
	
	private String manufacturer;
	private String processor;
	private int ramSize;
	private int discSize;
	private double processorSpeed;
	
	public Computer(String manufacturer, String processor, int ramSize, int discSize, double processorSpeed) {
		this.manufacturer = manufacturer;
		this.processor = processor;
		this.ramSize = ramSize;
		this.discSize = discSize;
		this.processorSpeed = processorSpeed;
	}
	
	public double computerPower() {
		return ramSize * processorSpeed;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public String getProcessor() {
		return processor;
	}
	
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	
	public int getRamSize() {
		return ramSize;
	}
	
	public void setRamSize(int ramSize) {
		this.ramSize = ramSize;
	}
	
	public int getDiscSize() {
		return discSize;
	}
	
	public void setDiscSize(int discSize) {
		this.discSize = discSize;
	}
	
	public double getProcessorSpeed() {
		return processorSpeed;
	}
	
	public void setProcessorSpeed(double processorSpeed) {
		this.processorSpeed = processorSpeed;
	}

	@Override
	public String toString() {
		return "Computer [manufacturer=" + manufacturer + ", processor=" + processor + ", ramSize=" + ramSize
				+ ", discSize=" + discSize + ", processorSpeed=" + processorSpeed + "]";
	}
	
}
