package com.itctraining.dao;

import java.util.ArrayList;

import com.itctraining.events.model.Events;

public interface EventsDAO {

	public void insert(Events event);
	public Events findByEventId(int eventId);
	public String delete(int eventId);
	public ArrayList<Events> showAllEvents();
}
