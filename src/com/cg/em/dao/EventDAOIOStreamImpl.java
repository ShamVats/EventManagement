package com.cg.em.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import com.cg.em.exception.EventManagementException;
import com.cg.em.model.Events;


public class EventDAOIOStreamImpl implements IEventDAO {
	
	public static final String DATA_STORE_FILE_NAME= "events.dat";
	
	private Map<String , Events> events;
	
	public EventDAOIOStreamImpl() throws EventManagementException {
		File file = new File(DATA_STORE_FILE_NAME);if(!file.exists()) {
			events= new TreeMap<>();
		}else {
			try(ObjectInputStream fin = new ObjectInputStream(new FileInputStream(DATA_STORE_FILE_NAME))){
				
				Object obj = fin.readObject();
				
				if(obj instanceof Map) {
					events = (Map<String, Events>) obj;
				}else {
					throw new EventManagementException("Not a valid event");
				}
			} catch (IOException | ClassNotFoundException exp) {
				throw new EventManagementException("Loading Data Failed ");
			}
		}
	}

	@Override
	public String add(Events event) throws EventManagementException {
		String eventId = null;
		if(event != null) {
			eventId = event.getEventId();
			System.out.println(eventId + "hello");
			events.remove(eventId);
		}
		return eventId;
	}

	@Override
	public boolean delete(String eventId) throws EventManagementException {
		boolean isDone = false;
		if(eventId != null) {
			events.remove(eventId);
			isDone = true;
		}
			
		return isDone;
	}

	@Override
	public Events get(String eventId) throws EventManagementException {
		return events.get(eventId);
	
	}

	@Override
	public List<Events> getALL() throws EventManagementException {
		return new ArrayList<>(events.values());
	}

	@Override
	public boolean update(Events event) throws EventManagementException {
		boolean isDone = false;
		if(event != null) {
			String eventId= event.getEventId();
			events.replace(eventId,event);
		}
	
		return isDone;
	}

	@Override
	public void persist() throws EventManagementException {
		try (ObjectOutputStream fout = new ObjectOutputStream(
				new FileOutputStream(DATA_STORE_FILE_NAME))) {
			fout.writeObject(events);
		} catch (IOException exp) {
			throw new EventManagementException("Saving Data Failed" + exp.getMessage());
		}
		
	}

	@Override
	public List<Events> listAllEvents(String location) {
		
		return null;
	}

	@Override
	public List<Events> listAllEvents(LocalDate datesheduled) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
//	@Override 
//	public List<Events> listAllEvents(String location){
//		return new ArrayList<>(location.values());
//	}
//	
//	
//	@Override
//	public List<Events> listAllEvents(LocalDate datesheduled){
//		return new ArrayList<>()
//	}

}
