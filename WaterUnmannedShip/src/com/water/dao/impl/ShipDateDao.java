package com.water.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import com.water.dao.IShipDateDao;
import com.water.entity.ShipData;
import com.water.utils.JdbcUtils;



public class ShipDateDao implements IShipDateDao{

	@Override
	public ShipData getData(int id) {

		String sql = "select * from shipdata where id=?";
		QueryRunner qr = JdbcUtils.getQuertRunner();
		
		try {
			ShipData shipData = qr.query(sql, new BeanHandler<ShipData>(ShipData.class),id);
			return shipData;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void saveDate(ShipData shipData) {

		String sql = "insert into shipdata(speedShip,speedWater,scoreWater) values(?,?,?)";
		QueryRunner qr = JdbcUtils.getQuertRunner();
		Object[] params = {shipData.getSpeedShip(),shipData.getSpeedWater(),shipData.getScoreWater()};
		try {
			qr.update(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<ShipData> getAll() {
		List<ShipData> list = new ArrayList<ShipData>();
		String sql = "select * from shipdata";
		QueryRunner qr = JdbcUtils.getQuertRunner();
		
		try {
			list = qr.query(sql, new BeanListHandler<ShipData>(ShipData.class));
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
			
	}
	

}
