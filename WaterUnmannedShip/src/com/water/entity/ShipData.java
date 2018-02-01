package com.water.entity;

import java.io.Serializable;

public class ShipData implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private double speedShip;
	private double speedWater;
	private int scoreWater;
	
	
	
	public double getSpeedShip() {
		return speedShip;
	}



	public void setSpeedShip(double speedShip) {
		this.speedShip = speedShip;
	}



	public double getSpeedWater() {
		return speedWater;
	}



	public void setSpeedWater(double speedWater) {
		this.speedWater = speedWater;
	}



	public int getScoreWater() {
		return scoreWater;
	}



	public void setScoreWater(int scoreWater) {
		this.scoreWater = scoreWater;
	}



	@Override
	public String toString() {

		return "[船速： "+speedShip+" ,水速:"+speedWater+", 水质："+scoreWater+" ]";
	}
	

}
