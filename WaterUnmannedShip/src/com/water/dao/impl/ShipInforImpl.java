package com.water.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.MAVLink.mavlinkpython.common.ShipInformation;
import com.sun.org.apache.bcel.internal.generic.Select;
import com.water.dao.ShipInforDao;
import com.water.utils.JdbcUtils;

public class ShipInforImpl implements ShipInforDao{

	@Override
	public void saveShipInfor(ShipInformation shipinfor) {

		String sql = "insert into shipinfo(throttle, direction, controlvol, tractionvol,"
	        + "shiptemp, watertemp, ph, latitude, longitude) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		QueryRunner qr  = JdbcUtils.getQuertRunner();
		try {
			qr.update(sql, shipinfor.throttle, shipinfor.direction, shipinfor.controlvol, shipinfor.tractionvol, 
			    shipinfor.shiptemp, shipinfor.watertemp, shipinfor.ph, shipinfor.latitude, shipinfor.longitude);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ShipInformation getShipInfor(int id) {

		String sql = "select * from shipinfo where id = ?";
	    QueryRunner qr = JdbcUtils.getQuertRunner();
	   
	    try {
			return qr.query(sql, new BeanHandler<ShipInformation>(ShipInformation.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	    
		
	}

	@Override
	public List<ShipInformation> getAll() {

		String sql = "select * from shipinfo";
	    QueryRunner qr = JdbcUtils.getQuertRunner();
	    
	    try {
			return qr.query(sql, new BeanListHandler<ShipInformation>(ShipInformation.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	   
	}

	@Override
	public void deleteShipInfor(int id) {
		
		String sql = "delete from shipinfo where id = ?";
		QueryRunner qr = JdbcUtils.getQuertRunner();
		
		try {
			qr.update(sql,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateShipInfor(int id, ShipInformation shipinfor) {
		
		String sql = "update shipinfo set throttle=?, direction=?, controlvol=?, tractionvol=?,"
	        + "shiptemp=?, watertemp=?, ph=?, latitude=?, longitude=? where id=?";
		QueryRunner qr = JdbcUtils.getQuertRunner();
		try {
			qr.update(sql, shipinfor.throttle, shipinfor.direction, shipinfor.controlvol, shipinfor.tractionvol, 
			    shipinfor.shiptemp, shipinfor.watertemp, shipinfor.ph, shipinfor.latitude, shipinfor.longitude, id); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ShipInformation getLastInfor() {
		
		String sql = "select * from shipinfo where id=(select max(id) from shipinfo)";
		QueryRunner qr = JdbcUtils.getQuertRunner();
		
		try {
			return qr.query(sql, new BeanHandler<ShipInformation>(ShipInformation.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
