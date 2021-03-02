package com.cg.em.ui;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.cg.em.exception.EventManagementException;
import com.cg.em.model.Events;
import com.cg.em.model.EventsAppMenu;
import com.cg.em.service.EventServiceImpl;
import com.cg.em.service.IEventService;

public class EventManagementUI {
	
	private static IEventService eventService;
	private static Scanner scan;
	private static DateTimeFormatter dtFormater;
	
	public static void main(String[] args) throws EventManagementException {
		eventService = new EventServiceImpl();
		
		scan = new Scanner(System.in);
		dtFormater = DateTimeFormatter.ofPattern("dd-MM-yyy");
		
		EventsAppMenu menu = null;
		
		while(menu!= EventsAppMenu.QUIT) {
			
			System.out.println("Choice / Menu Item");
			System.out.println("================================");
			for(EventsAppMenu m : EventsAppMenu .values()) {
				System.out.println(m.ordinal() + "\t" + m.name());
			}
			System.out.print("Choice: ");
			int choice = -1;
			if(scan.hasNextInt())
				choice = scan.nextInt();
			else {
				scan.next();
				System.out.println("Please choose a choice displayed ");
				continue;
			}
			
			if (choice < 0 || choice >= EventsAppMenu.values().length) {
				System.out.println("Invalid Choice");
			}else {
				menu = EventsAppMenu.values()[choice];
				switch (menu) {
				case Add_Event:
					doAdd();
					break;
				case List_Events:
					doList();
					break;
				case SEARCH:
					doSearch();
					break;
				case  Remove_Event:
					doRemove();
					break;
				case Event_in_ascending_order:
					dosortase();
					break;
				case Events_in_alphabetical_order_of_location:
					
		
				    
				
				case QUIT:
					System.out.println("Thankyou Come Again!");
					break;
				}
			}
				
		}
		scan.close();
		
	}
	
	private static void doAdd() {
		try {
			Events event = new Events();
			System.out.println("Event ID:");
			event.setEventId(scan.next());
			System.out.println("Event Title: ");
			event.setEventTitle(scan.next());
			System.out.println("SheduledDate(dd-MM-yyyy) :");
			String shedDtStr = scan.next();
			System.out.println("Event Location");
			event.setEventLocation(scan.next());
			
			try {
				event.setDateSheduled(LocalDate.parse(shedDtStr, dtFormater));
			} catch (DateTimeException exp) {
				throw new EventManagementException( " Date must be in the format day(dd)-month(MM)-year(yyyy)");
			}
			System.out.print("Cost : ");
			if (scan.hasNextDouble())
				event.setEventCost(scan.nextDouble());
			else {
				scan.next();
				throw new EventManagementException("Cost is a number");
			}

			String eventId = eventService.add(event);
			System.out.println("Event is Added with Event id: " + eventId);
		} catch (EventManagementException exp) {
			System.out.println(exp.getMessage());
		}
	}

	private static void doList() {
		List<Events> events;
		try {
			events = eventService.getALL();
			if (events.isEmpty()) {
				System.out.println("No Events To display");
			} else {
				for (Events e : events)
					System.out.println(e);
			}
		} catch (EventManagementException exp) {
			System.out.println(exp.getMessage());
		}
	}

	private static void doSearch() {
		System.out.print("Event ID: ");
		String eventId = scan.next();

		try {
		    Events event = eventService.get(eventId);
			if (event != null) {
				System.out.println(event);
			} else {
				System.out.println("No Such Event");
			}
		} catch (EventManagementException exp) {
			System.out.println(exp.getMessage());
		}
	}

	private static void doRemove() {
		System.out.print("Event ID: ");
		String eventId = scan.next();
		try {
			boolean isDone = eventService.delete(eventId);
			if (isDone) {
				System.out.println("Event is Deleted");
			} else {
				System.out.println("No Such Event");
			}
		} catch (EventManagementException exp) {
			System.out.println(exp.getMessage());
		}
	}
	
	private static void dosortase() {
		
	}

	
}
