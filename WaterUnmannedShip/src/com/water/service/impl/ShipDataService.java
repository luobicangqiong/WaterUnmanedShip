package com.water.service.impl;

import java.util.List;

import com.water.dao.IShipDateDao;
import com.water.dao.impl.ShipDateDao;
import com.water.entity.ShipData;
import com.water.service.IShipDataService;



public class ShipDataService implements IShipDataService{
	
	private IShipDateDao shipDateDao = new ShipDateDao();

	@Override
	public ShipData getData(int id) {
		// TODO Auto-generated method stub
		return shipDateDao.getData(id);
	}

	@Override
	public void saveDate(ShipData shipData) {

		shipDateDao.saveDate(shipData);
		
	}

	@Override
	public List<ShipData> getAll() {
		
		return shipDateDao.getAll();
		
	}

	
}

