package com.water.dao;

import java.util.List;

import com.water.entity.ShipData;



public interface IShipDateDao {

	/**
	 * ����id��ѯ����ֻ���ڵ�ֵ
	 * @param id
	 * @return
	 */
	public ShipData getData(int id);
	/**
	 * �Ѵ����������������ݱ��浽���ݿ�
	 * @param shipData
	 */
	public void saveDate(ShipData shipData);
	/**
	 * ��ʾ���еĴ�ֻ
	 * @return
	 */
	public List<ShipData> getAll();
}
