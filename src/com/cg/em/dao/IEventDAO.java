package com.cg.em.dao;

import java.time.LocalDate;
import java.util.List;


import com.cg.em.exception.EventManagementException;
import com.cg.em.model.Events;

public interface IEventDAO {
	String add(Events event) throws EventManagementException; 
	boolean delete(String eventId) throws EventManagementException;
	Events get(String eventId) throws EventManagementException;
	List<Events> getALL() throws EventManagementException;
	boolean update(Events event) throws EventManagementException;
	void persist() throws EventManagementException;
	List<Events> listAllEvents(String location);
	List<Events> listAllEvents(LocalDate datesheduled);

}
