package com.itctraining.EventsHapping;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itctraining.dao.EventsDAO;
import com.itctraining.events.model.Events;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		EventsDAO eventsDAO = (EventsDAO) context.getBean("eventsDAO");

		//inserting events
//		Events events = new Events();
//		events.setEventType("Sports");
//		events.setEventName("India v/s West Indies");
//		events.setEventCity("Sabina Park");
//		events.setEventDate("25-08-2019");
//		events.setEventPrice(300);
//		eventsDAO.insert(events);

		///select particular event
//		Events eventSelect = eventsDAO.findByEventId(3);
//		System.out.println(eventSelect.getEventId() + " " + eventSelect.getEventType() + " "
//				+ eventSelect.getEventName() + " " + eventSelect.getEventCity() + " " + eventSelect.getEventDate() + " "
//				+ eventSelect.getEventPrice());
//		
//		//delete event
//		String deleteEvent = eventsDAO.delete(2); 
		
		//display all events
		ArrayList<Events> evensts = eventsDAO.showAllEvents();
		System.out.println(evensts);
	}
	
}
