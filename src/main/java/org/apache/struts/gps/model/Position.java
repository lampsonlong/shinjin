package org.apache.struts.gps.model;

import java.math.BigDecimal;

public class Position {

	private BigDecimal accuracy;
	
	private double latitude;
	
	private double longitude;
	
	private String datetime;
	
	private String ip;
	
	private double dst;

	public BigDecimal getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(BigDecimal accuracy) {
		this.accuracy = accuracy;
	}

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

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public double getDst() {
		return dst;
	}

	public void setDst(double dst) {
		this.dst = dst;
	}
}
