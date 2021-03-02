package com.cg.em.service;

import java.util.List;

import com.cg.em.exception.EventManagementException;
import com.cg.em.model.Events;

public interface IEventService {
	String add(Events event) throws EventManagementException; 
	boolean delete(String eventId) throws EventManagementException;
	Events get(String eventId) throws EventManagementException;
	List<Events> getALL() throws EventManagementException;
	boolean update(Events event) throws EventManagementException;
}
	