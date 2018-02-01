package com.water.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.water.entity.ShipData;
import com.water.service.IShipDataService;
import com.water.service.impl.ShipDataService;

public class UserAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private IShipDataService dataService = new ShipDataService();
	private ShipData shipData = new ShipData();

	public ShipData getShipData() {
		return shipData;
	}

	public void setShipData(ShipData shipData) {
		this.shipData = shipData;
	}
	
	/***添加数据******/
	public String add(){
		
		System.out.println(shipData);
		dataService.saveDate(shipData);
		return SUCCESS;
	}
	/**********显示数据*******/
	public String list()
	{
		try {
			List<ShipData> list = dataService.getAll();
			//System.out.println(list);
			ActionContext.getContext().getSession().put("shipdata", list);
			return "list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
