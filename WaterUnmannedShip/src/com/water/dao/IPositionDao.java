package com.water.dao;

import java.util.List;

import com.water.entity.Position;


public interface IPositionDao {

	/**
	 * ���浱ǰλ����Ϣ�����ݿ�
	 * @param p
	 */
	public void savePosition(Position p);
	/**
	 * �õ���ǰλ����Ϣ
	 * @return
	 */
	public List<Position> getPosition(Boolean state);
	
	public void setPositionState(Boolean state,int id);
	
}
