package com.water.service;

import java.util.List;

import com.water.entity.ShipData;



public interface IShipDataService {

	/**
	 * ֵ 根据id查询船只的信息
	 * @param id
	 * @return
	 */
	public ShipData getData(int id);
	/**
	 * 把传感器发过来的数据保存到数据库
	 * @param shipData
	 */
	public void saveDate(ShipData shipData);
	/**
	 * 显示所有的船只
	 * @return
	 */
	public List<ShipData> getAll();
}
