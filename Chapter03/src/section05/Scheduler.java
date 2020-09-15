package section05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Scheduler {

//	private int capacity = 10;
//	Event [] eventList = new Event[capacity];
//	int n = 0;
	
//	MyArrayList<Event> eventList = new MyArrayList<>();
	ArrayList<Event> eventList = new ArrayList<>();
	private Scanner kb;
	public void commandProcessor() {
		kb = new Scanner(System.in);
		
		while(true) {
			System.out.print("$ ");
			String command = kb.next();
			
			if(command.equals("exit")) {
				break;
			} else if(command.equals("addevent")) {
				String eventCmd = kb.next();
				
				if(eventCmd.equalsIgnoreCase("oneday")) {
					handleAddOneDayEvent();
				} else if(eventCmd.equalsIgnoreCase("deadline")) {
					handleAddDeadLineEvent();
				} else if(eventCmd.equalsIgnoreCase("duration")) {
					handleAddDurationEvent();
				} 
				
			} else if(command.equals("list")) {
				handleEventList();
				
			} else if(command.equals("show")) {
				hadleShow();
			} else if(command.equals("sort")) {
//				Arrays.sort(eventList.toArray());
				Collections.sort(eventList);
			}
		}
		
		kb.close();
	}
	
	private void hadleShow() {
		System.out.print("   show: ");
		
		String showStr = kb.next();
		
		MyDate theDate = parseDateString(showStr);
		
		for (int i = 0; i < eventList.size(); i++) {
			if( eventList.get(i).isReleveant(theDate)) {
				System.out.println(eventList.get(i).toString());
			}
		}
	}

	private void handleEventList() {
		for (int i = 0; i < eventList.size(); i++) {
			System.out.println("   "+eventList.get(i).toString());
		}
	}

	private void handleAddDurationEvent() {
		System.out.print("   begin: ");
		String beginStr = kb.next();
		
		System.out.print("   end: ");
		String endStr = kb.next();
		
		System.out.print("   title: ");
		String title = kb.next(); 
		
		DurationEvent durationEvent = new DurationEvent(title, parseDateString(beginStr), parseDateString(endStr));
		addEvent(durationEvent);
	}

	private void handleAddDeadLineEvent() {
		System.out.print("   until: ");
		
		String untilStr = kb.next();
		
		System.out.print("   title: ");
		String title = kb.next();
		
		DeadLinedEvent deadline = new DeadLinedEvent(title, parseDateString(untilStr));
		addEvent(deadline);
	}

	private void handleAddOneDayEvent() {
		System.out.print("   When: ");
		
		String whenStr = kb.next();
		
		System.out.print("   title: ");
		String title = kb.next();
		
		OneDayEvent oneday = new OneDayEvent(title, parseDateString(whenStr));
		addEvent(oneday);
	}
	
	private MyDate parseDateString(String str) {
		String [] date = str.split("/");
		
		int year =  Integer.parseInt(date[0]);
		//월 입력 제한 없음
		int month =  Integer.parseInt(date[1]);
		
		//일 입력 제한 없음
		int day = Integer.parseInt(date[2]);
		
		return new MyDate(year, month, day);
	}
	
	private void addEvent(Event ev) {
//		if( n >= capacity) {
//			reallocate();
//		}
//		eventList[n++] = ev;
		
		eventList.add(ev);
	}
	
	
//	private void reallocate() {
//		Event [] tmp = new Event[capacity * 2];
//		for (int i = 0; i < n; i++) {
//			tmp[i] = eventList[i];
//		}
//		
//		eventList = tmp;//tmp 는 가비지 데이터,
//		capacity = capacity * 2;
//	}

	public static void main(String[] args) {
		
		Scheduler app = new Scheduler();
		app.commandProcessor();
	}
}
 