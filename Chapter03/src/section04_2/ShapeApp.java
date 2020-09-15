package section04_2;

import java.util.Arrays;
import java.util.Scanner;

public class ShapeApp {

	private int capacity = 100;
	private Shape [] shapes = new Shape[capacity];
	private int n = 0;
	private Scanner kb = new Scanner(System.in);
	
	private void processorCommand() {
		String command = kb.next();
		
		while(true) {
			System.out.print("$ ");
			if(command.equals("exit")) {
				break;
			} else if(command.equals("show") || command.equals("showdetail")) {
				handleShow(command.equals("showdetail"));
			} else if(command.equals("add")) {
				handleAdd();
			} else if(command.equals("sort")) {
//				bubbleSort();
//				bubbleSort(shapes, n);
				Arrays.sort(shapes, 0 , n); // generic 하며 배열의 객체인 Shape 은 Comparable 을 implement 하고 있어야 하며
											// Comparable 를 implement 한 Shape compareTo 를 정의 해놓고 있어야  Arrays.sort 가 
				                            // Shape의 compareTo 를 이용해서 정렬 가능
//				MyUtil.bubbleSort(shapes, n);
			}
		}
		
		kb.close();
	}
	
//	private void bubbleSort() {
//		for (int i = n-1; i > 0; i--) {
//			for (int j = 0; j < i; j++) {
//				if(shapes[j].computeArea() > shapes[j+1].computeArea()) {
//					Shape tmp = shapes[j];
//					shapes[j] = shapes[j+1];
//					shapes[j+1] = tmp;
//				}
//			}
//		}
//	}
	
	private void handleAdd() {
		String shapeType = kb.next();
		
		switch(shapeType) {
		case "R" : 
			int width = kb.nextInt();
			int height = kb.nextInt();
			
			Rectangle rect = new Rectangle(width, height);
			addShape(rect);
			
			break;
		case "C" :
			
			int radius = kb.nextInt();
			
			Circle circle = new Circle(radius);
			addShape(circle);
			
			break;
		case "T" :
			
			int tWidth = kb.nextInt();
			int tHeight = kb.nextInt();
			
			Triangle tr = new Triangle(tWidth, tHeight);
			addShape(tr);
			
			break;
		default :
			System.out.println("입력 받을 수 없는 도형 형태입니다.");
			break;
		}
	}
	
	
	private void addShape(Shape shape) {
		if(n >= capacity ) {
			arrayReallocate();
		}
		
		shapes[n++] = shape;
	}

	private void handleShow(boolean isDetail) {
		for (int i = 0; i < n; i++) {
			System.out.println((i+1) + ". " + shapes[i].toString());
			if(isDetail) {
				System.out.println("         the Area is " + shapes[i].computeArea());
				System.out.println("         the Perimeter is " + shapes[i].computePerimeter());
			}
		}
	}
	
	private void arrayReallocate() {
		capacity = capacity * 2;
		Shape [] tmp = new Shape[capacity];
		
//		for (int i = 0; i < n; i++) {
//			tmp[i] = shapes[i];
//		}
		
		System.arraycopy(shapes, 0, tmp, 0, shapes.length);
		
		shapes = tmp;
	}
	
	public static void main(String[] args) {
		ShapeApp app = new ShapeApp();
		app.processorCommand();
	}
}
