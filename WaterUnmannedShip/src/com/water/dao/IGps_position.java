package com.water.dao;

import java.util.List;

import com.MAVLink.mavlinkpython.common.msg_gps_global_origin;


public interface IGps_position {

	/**
	 * 存储当前的位置信息，海拔信息
	 * @param gps
	 */
	public void savePosition(msg_gps_global_origin gps);
	
	/**
	 * 根据id得到位置信息
	 * @param id
	 * @return
	 */
	public msg_gps_global_origin getPosition(int id);
	
	/*
	 * 得到所有的位置信息
	 */
	public List<msg_gps_global_origin>  getAll();
	/**
	 * 得到表的最后一个记录
	 * @return
	 */
	public msg_gps_global_origin getlastPosition();
	
}
