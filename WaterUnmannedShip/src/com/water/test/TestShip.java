package com.water.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.water.entity.ShipData;
import com.water.service.IShipDataService;
import com.water.service.impl.ShipDataService;


public class TestShip {
	
	/**
	 * 测试数据连接是否正常
	 * 
	 */
	IShipDataService dataService = new ShipDataService();
	
	@Test
	public void test1() throws Exception {
		
		
		ShipData shipData = new ShipData();
		//shipData.setId(1);
		shipData.setScoreWater(29);
		shipData.setSpeedShip(8);
		shipData.setSpeedWater(20);
		
		dataService.saveDate(shipData);
		
	}
	
	@Test
	public void test2() throws Exception {
		
		ShipData shipData = dataService.getData(1);
		System.out.println(shipData);
	}
	
	@Test
	public void test3() throws Exception {
		
		List<ShipData> list = dataService.getAll();
		System.out.println(list);
		
	}

	@Test
	public void test4() throws Exception {
		float a = 3.21f;
		String string = String.valueOf(a);
		System.out.println(string);
	}
	@Test
	public void test5() throws Exception {
		
		String data = "1.23";
		float data1 = Float.parseFloat(data);
		System.out.println(data1);
	}
}
