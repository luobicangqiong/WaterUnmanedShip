package com.water.test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.MAVLink.mavlinkpython.common.msg_gps_global_origin;
import com.water.dao.IGps_position;
import com.water.dao.impl.Gps_positionDao;
import com.water.utils.JdbcUtils;

public class TestGpsPositon {

	IGps_position gpsdao = new Gps_positionDao();
	
	@Test
	public void testsave() throws Exception {
		
		msg_gps_global_origin gps = new msg_gps_global_origin();
		gps.altitude = 66;
		gps.longitude = 64;
		gps.latitude = 56;
		
		gpsdao.savePosition(gps);
	}
	
	@Test
	public void testget() throws Exception {
		
		msg_gps_global_origin gps = gpsdao.getPosition(2);
		System.out.println(gps);
	}
   
	@Test
	public void testgetAll() throws Exception {
		
		List<msg_gps_global_origin> list= gpsdao.getAll();
		System.out.println(list);
	}
	
	
	@Test
	public void testGetLast() throws Exception {
		msg_gps_global_origin gps  =gpsdao.getlastPosition();
		System.out.println(gps);
		System.out.println(gps.id);
		
	}
	
	@Test
	public void testMaxId() throws Exception {
		
        int id = 0;
		String sql = "select max(id) from gps_position";
		QueryRunner qr  = JdbcUtils.getQuertRunner();
		
		
		
	}
	
}
