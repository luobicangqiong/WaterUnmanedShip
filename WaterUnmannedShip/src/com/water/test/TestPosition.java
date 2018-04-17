package com.water.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;

import com.water.dao.IPositionDao;
import com.water.dao.impl.PositionDao;
import com.water.entity.Position;


public class TestPosition {

	@Test
	public void testSave() throws Exception {
	
		Position p = new Position();
		p.setState(true);
		p.setPosition(12.0f);
		
		IPositionDao positionDao = new PositionDao();
		positionDao.savePosition(p);
	}
	
	
	@Test
	public void testGet() throws Exception {
		
		PositionDao positionDao = new PositionDao();
		List<Position> list = positionDao.getDateList("2018-04-01 00:00:00", "2018-04-05 23:59:59");
		System.out.println(list);
//		positionDao.setPositionState(false, position.getId());
//		System.out.println(position);
	}
	
	@Test
	public void testSetDate() throws Exception {
		PositionDao positionDao = new PositionDao();
		positionDao.setDate("");
	}
	
	@Test
	public void testGetDate() throws Exception {
		PositionDao positionDao = new PositionDao();
		Position position = positionDao.getDate();
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(position.getT_date());
		System.out.println(timeStamp);
		
	}
}
