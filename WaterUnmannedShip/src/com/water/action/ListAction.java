package com.water.action;

import java.util.List;

import com.MAVLink.mavlinkpython.common.ShipInformation;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.water.dao.ShipInforDao;
import com.water.dao.impl.ShipInforImpl;

public class ListAction extends ActionSupport{
	
	private static final long serialVersionUID = 12L;
	private ShipInforDao shiDao = new ShipInforImpl();
	
	public String list()
	{
		try {
			
			List<ShipInformation> list  = shiDao.getAll();
			ActionContext.getContext().getSession().put("shipdata", list);
			return "list";
		} catch (Exception e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
		
	}
	

}
