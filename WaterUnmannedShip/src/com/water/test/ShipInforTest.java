package com.water.test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.MAVLink.mavlinkpython.common.ShipInformation;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.water.dao.ShipInforDao;
import com.water.dao.impl.ShipInforImpl;
import com.water.utils.DateUtilClass;
import com.water.utils.Server2WebProtocol;

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
		ship.latitude = 3018794360l;
		ship.longitude = 12020246780l;
		
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
		JSONObject singleJsonObject = Server2WebProtocol.getSingleJsonObject(ship);
		String dataString = new String(singleJsonObject.toString().getBytes("UTF-8"), "utf-8");
		System.out.println(dataString);
		System.out.println(singleJsonObject.toJSONString());
	}
	
	@Test
	public void testGetAll() throws Exception {
		
		List<ShipInformation> list = shipdaoDao.getAll();
		List<JSONObject> jsonList = Server2WebProtocol.getJsonList(list);
		System.out.println(jsonList);
		String sb  = "";
		for(JSONObject jsonObject : jsonList)
		{
			sb += jsonObject.toJSONString();
			
		}
		System.out.println(sb);
		
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
	
	@Test
	public void testGetSpecial() throws Exception {
		List<ShipInformation> specialData = shipdaoDao.getSpecialData("2018-3-23", "2018-04-05");
		
		System.out.println(specialData);
	}
	@Test
	public void testLong() throws Exception {
		long l1 = 3018794360l;
	}
}
