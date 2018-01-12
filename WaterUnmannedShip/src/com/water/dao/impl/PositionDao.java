package com.water.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.water.dao.IPositionDao;
import com.water.entity.Position;
import com.water.utils.JdbcUtils;



public class PositionDao implements IPositionDao {

	@Override
	public void savePosition(Position p) {

		String sql = "insert into test(state,position) values(?,?)";
		
		try {
			QueryRunner qr = JdbcUtils.getQuertRunner();
			qr.update(sql,p.isState(),p.getPosition());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Position> getPosition(Boolean state) {
		// TODO Auto-generated method stub
		String sql = "select * from test where state = ?";
	    try {
			QueryRunner qr = JdbcUtils.getQuertRunner();
			return qr.query(sql, new BeanListHandler<Position>(Position.class),state);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException(e);
		
		}
	}

	@Override
	public void setPositionState(Boolean state,int id) {
		String sql = "update test set state = ? where id = ?";
		QueryRunner qr = JdbcUtils.getQuertRunner();
		try {
			qr.update(sql, state,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}
	

}
