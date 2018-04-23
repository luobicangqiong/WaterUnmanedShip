package com.water.utils;

import java.util.ArrayList;
import java.util.List;

import com.MAVLink.mavlinkpython.common.ShipInformation;
import com.alibaba.fastjson.JSONObject;

public class Server2WebProtocol {

	public static JSONObject getSingleJsonObject(ShipInformation ship)
	{
		
		JSONObject json = new JSONObject();
		json.put("throttle", ship.getThrottle());
		json.put("direction", ship.getDirection());
		json.put("controlvol", ship.getControlvol());
		json.put("tractionvol", ship.getTractionvol());
		json.put("shiptemp", ship.getShiptemp());
		json.put("watertemp", ship.getWatertemp());
		json.put("ph", ship.getPh());
		json.put("latitude", ship.getLatitude());
		json.put("longitude", ship.getLongitude());
		json.put("time", DateUtilClass.getStringTime(ship.getT_date()));
		
		return json;
		
	}
	
	public static List<JSONObject> getJsonList(List<ShipInformation> list)
	{
		List<JSONObject> jsonList = new ArrayList<JSONObject>();
		for(ShipInformation ship : list)
		{
			jsonList.add(getSingleJsonObject(ship));
			
		}
		return jsonList;
	}
}
