package com.water.entity;

import java.sql.Date;
import java.sql.Timestamp;


public class Position {

	private int id;
	private float position;
	private boolean state;
	private Timestamp t_date;
	
	
	
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getPosition() {
		return position;
	}
	public void setPosition(float position) {
		this.position = position;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+this.id+", "+this.state + ", "+this.position + "," + this.t_date+"]";
	}
	public Timestamp getT_date() {
		return t_date;
	}
	public void setT_date(Timestamp t_date) {
		this.t_date = t_date;
	}
	
}
