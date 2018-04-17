package com.water.test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.MAVLink.mavlinkpython.common.ShipInformation;
import com.water.dao.ShipInforDao;
import com.water.dao.impl.ShipInforImpl;

public class ShipInforTest {

	ShipInforDao shipdaoDao = new ShipInforImpl();
	
	@Test
	public void testSave() throws Exception {
		ShipInformation ship = new ShipInformation();
		ship.throttle = 34;
		ship.direction=3;
		ship.controlvol = 3;
		ship.tractionvol = 12;
		ship.shiptemp = 232;
		ship.watertemp = 22;
		ship.ph = 52;
		ship.latitude = 321;
		ship.longitude = 7228;
		
	    shipdaoDao.saveShipInfor(ship);
		
	}
	
	@Test
	public void testUpdate() throws Exception {
		
		ShipInformation ship = new ShipInformation();
		ship.throttle = 34;
		ship.direction=333;
		ship.controlvol = 311;
		ship.tractionvol = 12;
		ship.shiptemp = 232;
		ship.watertemp = 22;
		ship.ph = 52;
		ship.latitude = 321;
		ship.longitude = 7228;
		
		shipdaoDao.updateShipInfor(1, ship);
		
	}
	
	@Test
	public void testDelete() throws Exception {
		int id = 1;
		shipdaoDao.deleteShipInfor(id);
		
	}
	
	@Test
	public void testGet() throws Exception {
		ShipInformation ship = shipdaoDao.getShipInfor(2);
		System.out.println(ship);
		
	}
	
	@Test
	public void testGetAll() throws Exception {
		
		List<ShipInformation> list = shipdaoDao.getAll();
		System.out.println(list);
		
	}
	
	@Test
	public void testGetLast() throws Exception {
		
		ShipInformation ship = shipdaoDao.getLastInfor();
		System.out.println(ship);
		
	}
	
	@Test
	public void testGet3() throws Exception {
		List<ShipInformation> list = shipdaoDao.getPre3();
		System.out.println(list);
		
	}
	@Test
	public void testDate() throws Exception {
		List<ShipInformation> list = shipdaoDao.getSpecialData("2018-03-25 10:00:00", "2018-04-01 10:00:00");
		System.out.println(list);
	}
}
