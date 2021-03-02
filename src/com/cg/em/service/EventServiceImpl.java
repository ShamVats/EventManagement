package com.cg.em.service;

import java.util.List;

import com.cg.em.dao.EventDAOIOStreamImpl;
import com.cg.em.dao.IEventDAO;
import com.cg.em.exception.EventManagementException;
import com.cg.em.model.Events;

public class EventServiceImpl implements IEventService {

	private IEventDAO eventDao;
	
	public IEventDAO getDAO() {
		return eventDao;
	}
	
	public EventServiceImpl() throws EventManagementException {
		eventDao = new EventDAOIOStreamImpl();
	}

	@Override
	public String add(Events event) throws EventManagementException {
		String eventId = null;
		if(event != null ) {
			eventId = eventDao.add(event);
		}
		return eventId;
	}

	@Override
	public boolean delete(String eventId) throws EventManagementException {
		boolean isDone = false;
		if(eventId != null) {
			eventDao.delete(eventId);
			isDone = true;
		}
		return isDone;
	}

	@Override
	public Events get(String eventId) throws EventManagementException {
		return eventDao.get(eventId);
	}

	@Override
	public List<Events> getALL() throws EventManagementException {
		return eventDao.getALL();
	}

	@Override
	public boolean update(Events event) throws EventManagementException {
		boolean isDone = false;
		if(event!= null) {
			isDone = eventDao.update(event);
		}
		return isDone;
	}
	
	

	
}
