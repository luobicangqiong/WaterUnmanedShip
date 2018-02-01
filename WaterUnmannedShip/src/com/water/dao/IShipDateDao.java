package com.water.dao;

import java.util.List;

import com.water.entity.ShipData;



public interface IShipDateDao {

	/**
	 * 根据id查询船只的信息
	 * @param id
	 * @return
	 */
	public ShipData getData(int id);
	/**
	 * 保存船只的信息到数据库
	 * @param shipData
	 */
	public void saveDate(ShipData shipData);
	/**
	 *  显示所有的船只信息
	 * @return
	 */
	public List<ShipData> getAll();
}
