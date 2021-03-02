package com.cg.em.service;

import java.time.LocalDate;
import java.util.Comparator;

import com.cg.em.model.Events;

public class DateScheduledComparator implements Comparator<Events> {
	
	@Override
	public int compare(Events e1, Events e2) {
		LocalDate firstDate = e1.getDateSheduled();
		LocalDate secondDate = e2.getDateSheduled();
		
	    return firstDate.compareTo(secondDate);
	
		}

}
