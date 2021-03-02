package com.cg.em.service;

import java.util.Comparator;

import com.cg.em.model.Events;

public class LocationComparator implements Comparator<Events> {
	
	@Override 
	public int compare(Events e1 , Events e2) {
		String firstEvent = e1.getEventLocation();
		String secondEvent = e2.getEventLocation();
		return firstEvent.compareTo(secondEvent);
		
	}

	
}
