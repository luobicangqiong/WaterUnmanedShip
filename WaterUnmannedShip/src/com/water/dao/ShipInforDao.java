package com.water.dao;

import java.util.List;

import com.MAVLink.mavlinkpython.common.ShipInformation;

public interface ShipInforDao {

	/**
	 * 保存数据到数据库
	 * @param shipinfor
	 */
	void saveShipInfor(ShipInformation shipinfor);
	
	/**
	 * 根据id得到船体的数据
	 * @param id
	 */
	ShipInformation getShipInfor(int id);
	/**
	 * 得到船体的所有数据
	 * @return
	 */
	List<ShipInformation> getAll();
	/**
	 * 删除船体的数据
	 * @param id
	 */
	void deleteShipInfor(int id);
	/**
	 * 更新船体的数据
	 * @param id
	 * @param shipinfor
	 */
	void updateShipInfor(int id, ShipInformation shipinfor);
	/**
	 * 得到最新的记录
	 * @return
	 */
	ShipInformation getLastInfor();
	
	
}
