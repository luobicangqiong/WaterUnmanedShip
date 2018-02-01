package com.water.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.MAVLink.mavlinkpython.common.msg_gps_global_origin;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.water.dao.IGps_position;
import com.water.utils.JdbcUtils;

public class Gps_positionDao implements IGps_position {

	@Override
	public void savePosition(msg_gps_global_origin gps) {
		
		String sql = "insert into gps_position(latitude,longitude,altitude) values(?,?,?)";
	    QueryRunner qr = JdbcUtils.getQuertRunner();
	    
	    try {
			qr.update(sql, gps.latitude,gps.longitude,gps.altitude);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public msg_gps_global_origin getPosition(int id) {
		
		String sql = "select * from gps_position where id = ?";
		QueryRunner qr = JdbcUtils.getQuertRunner();
		
		try {
			return qr.query(sql, new BeanHandler<msg_gps_global_origin>(msg_gps_global_origin.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<msg_gps_global_origin> getAll() {
		
		List<msg_gps_global_origin> list = new ArrayList<msg_gps_global_origin>();
		String sql  = "select * from gps_position";
		QueryRunner qr = JdbcUtils.getQuertRunner();
		
		try {
			return qr.query(sql,new BeanListHandler<msg_gps_global_origin>(msg_gps_global_origin.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public msg_gps_global_origin getlastPosition() {
		
		String sql = "select * from gps_position where id = (select max(id) from gps_position)";
		QueryRunner qr  = JdbcUtils.getQuertRunner();
		
		try {
			return qr.query(sql, new BeanHandler<msg_gps_global_origin>(msg_gps_global_origin.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
