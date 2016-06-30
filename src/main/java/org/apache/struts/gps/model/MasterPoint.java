package org.apache.struts.gps.model;

public class MasterPoint {

	private double latitude;
	
	private double longitude;
	
	private double radius;
	
	private int ticket;
	
	private int allTicket;

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public int getTicket() {
		return ticket;
	}

	public void setTicket(int ticket) {
		this.ticket = ticket;
	}

	public int getAllTicket() {
		return allTicket;
	}

	public void setAllTicket(int allTicket) {
		this.allTicket = allTicket;
	}
}
