package com.cg.em.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Events implements Serializable , Comparable<Events>{
	
	private String eventId;
	private String eventTitle;
	private String eventLocation;
	private LocalDate dateSheduled;
	private double eventCost;
	
	
	
	public Events() {
		/* default constructor*/
	}


	public Events(String eventId, String eventTitle, String eventLocation, LocalDate dateSheduled, double eventCost) {
		super();
		this.eventId = eventId;
		this.eventTitle = eventTitle;
		this.eventLocation = eventLocation;
		this.dateSheduled = dateSheduled;
		this.eventCost = eventCost;
	}


	public String getEventId() {
		return eventId;
	}


	public void setEventId(String eventId) {
		this.eventId = eventId;
	}


	public String getEventTitle() {
		return eventTitle;
	}


	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}


	public String getEventLocation() {
		return eventLocation;
	}


	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}


	public LocalDate getDateSheduled() {
		return dateSheduled;
	}


	public void setDateSheduled(LocalDate dateSheduled) {
		this.dateSheduled = dateSheduled;
	}


	public double getEventCost() {
		return eventCost;
	}


	public void setEventCost(double eventCost) {
		this.eventCost = eventCost;
	}


	@Override
	public String toString() {
		StringBuilder ouput = new StringBuilder("Event ID :");
		ouput.append (eventId);
		ouput.append("\tEvent Title  :");
		ouput.append(eventTitle);
		ouput.append("\tEvent Date :");
		ouput.append(dateSheduled);
		ouput.append("\tEvent Location");
		ouput.append(eventLocation);
		ouput.append("\t Event Cost");
		ouput.append(eventCost);
		return ouput.toString();
			
	}


	@Override
	public int compareTo(Events event) {
		String firsteventId = this.eventId;
		String secondeventId = event.eventId;
		return firsteventId.compareTo(secondeventId);
	}


	
	@Override
	public int hashCode() {
		int hashCode =0;

		char[] chars = eventId.toCharArray();
		for(int i=1;i<=chars.length;i++){
			hashCode += ((int)chars[i-1])*i;
		}
		
		return hashCode;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean flag = false;

		if (obj instanceof Events) {
			Events event = (Events)obj;
			String firsteventId = this.eventId;
			String secondeventId = event.eventId;
			flag= firsteventId.equals(secondeventId);
		}
		
		return flag;		
	}


	 
	
	
	
	
	
	
	
	

	
		

	

}
