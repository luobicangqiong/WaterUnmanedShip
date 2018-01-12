package com.water.test;

import static org.junit.Assert.*;

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
		
		IPositionDao positionDao = new PositionDao();
		List<Position> list = positionDao.getPosition(true);
		System.out.println(list);
		for (Position position : list) {
			System.out.println(position);
		}
		//positionDao.setPositionState(false, position.getId());
		//System.out.println(position);
	}
}
