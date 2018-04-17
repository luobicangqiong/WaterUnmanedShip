package com.water.dao.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.water.dao.IPositionDao;
import com.water.entity.Position;
import com.water.utils.JdbcUtils;



public class PositionDao implements IPositionDao {

	@Override
	public void savePosition(Position p) {

		String sql = "insert into test(state,position,t_date) values(?,?,?)";
		SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = fomat.parse(fomat.format(new Date()));
			p.setT_date(new Timestamp(date.getTime()));
			QueryRunner qr = JdbcUtils.getQuertRunner();
			qr.update(sql,p.isState(),p.getPosition(), p.getT_date());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Position> getPosition(Boolean state) {
		
		String sql = "select * from test where state = ?";
	    try {
			QueryRunner qr = JdbcUtils.getQuertRunner();
			return qr.query(sql, new BeanListHandler<Position>(Position.class),state);
		} catch (SQLException e) {

			throw new RuntimeException(e);
		
		}
	}
	
	public List<Position> getDateList(String begin, String end) {
			
		    SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    
		    String sql = "select * from test where t_date >= ? and t_date <=? ";
		    try {
				QueryRunner qr = JdbcUtils.getQuertRunner();
				return qr.query(sql, new BeanListHandler<Position>(Position.class),
						new Timestamp(fomat.parse(begin).getTime()), new Timestamp(fomat.parse(end).getTime()));
			} catch (Exception e) {
	
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
	public void setDate(String date){
		
		date = "2018-4-4 10:05: 00";
		SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date t_date = null;
		try {
			t_date = fomat.parse(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = "update test set t_date=? where id=?";
		
		QueryRunner qr = JdbcUtils.getQuertRunner();
		try {
			qr.update(sql, t_date,1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Position getDate(){
		
		String sql = "select * from test where id = ?";
		QueryRunner qr = JdbcUtils.getQuertRunner();
		try {
			return qr.query(sql, new BeanHandler<Position>(Position.class), 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	

}
