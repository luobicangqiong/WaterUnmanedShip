package com.water.entity;

public class Position {

	private int id;
	private float position;
	private boolean state;
	
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
		return "["+this.id+", "+this.state + ", "+this.position;
	}
	
}
