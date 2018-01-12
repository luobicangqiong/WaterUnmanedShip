package com.water.dao;

import java.util.List;

import com.water.entity.Position;


public interface IPositionDao {

	/**
	 * 保存当前位置信息
	 * @param p
	 */
	public void savePosition(Position p);
	/**
	 * 得到当前所有的位置信息
	 * @return
	 */
	public List<Position> getPosition(Boolean state);
    /**
     * 设置位置信息
     * @param state
     * @param id
     */
	public void setPositionState(Boolean state,int id);
	
}
