package com.itctraining.events.model;

public class Events {
   int eventId;
   String eventType;
   String eventName;
   String eventCity;
   String eventDate;
   float eventPrice;
   
   public Events() {}
   
   public Events(int eventId,String eventType ,String eventName, String eventCity, String eventDate, float eventPrice) {
	   this.eventId = eventId;
	   this.eventType = eventType;
	   this.eventName = eventName;
	   this.eventCity = eventCity;
	   this.eventDate = eventDate;
	   this.eventPrice = eventPrice;
   }

public int getEventId() {
	return eventId;
}

public void setEventId(int eventId) {
	this.eventId = eventId;
}

public String getEventType() {
	return eventType;
}

public void setEventType(String eventType) {
	this.eventType = eventType;
}

public String getEventName() {
	return eventName;
}

public void setEventName(String eventName) {
	this.eventName = eventName;
}

public String getEventCity() {
	return eventCity;
}

public void setEventCity(String eventCity) {
	this.eventCity = eventCity;
}

public String getEventDate() {
	return eventDate;
}

public void setEventDate(String eventDate) {
	this.eventDate = eventDate;
}

public float getEventPrice() {
	return eventPrice;
}

public void setEventPrice(float eventPrice) {
	this.eventPrice = eventPrice;
}

@Override
public String toString() {
	return "Events [eventId=" + eventId + ", eventType=" + eventType + ", eventName=" + eventName + ", eventCity="
			+ eventCity + ", eventDate=" + eventDate + ", eventPrice=" + eventPrice + "]";
}
   
}
 