/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE ATTITUDE PACKING
package com.MAVLink.mavlinkpython.common;
import java.sql.Timestamp;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import com.water.utils.DateUtilClass;
        
/**
* The attitude in the aeronautical frame (right-handed, Z-down, X-front, Y-right).
*/
public class ShipInformation extends MAVLinkMessage{

    public static final int MAVLINK_MSG_ID_ALL = 30;
    public static final int MAVLINK_MSG_LENGTH = 40;
    private static final long serialVersionUID = MAVLINK_MSG_ID_ALL;


    public int id;
    
    public int throttle;
    
    public int direction;
    
    public int controlvol;
    
	public int tractionvol;
    
    public int shiptemp;
    
    public int watertemp;
    
    public int ph;
    
    public long latitude;
    
    public long longitude;
    
    private Timestamp t_date;
    

    
    public Timestamp getT_date() {
		return t_date;
	}

	public void setT_date(Timestamp t_date) {
		this.t_date = t_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getThrottle() {
		return throttle;
	}

	public void setThrottle(int throttle) {
		this.throttle = throttle;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getControlvol() {
		return controlvol;
	}

	public void setControlvol(int controlvol) {
		this.controlvol = controlvol;
	}

	public int getTractionvol() {
		return tractionvol;
	}

	public void setTractionvol(int tractionvol) {
		this.tractionvol = tractionvol;
	}

	public int getShiptemp() {
		return shiptemp;
	}

	public void setShiptemp(int shiptemp) {
		this.shiptemp = shiptemp;
	}

	public int getWatertemp() {
		return watertemp;
	}

	public void setWatertemp(int watertemp) {
		this.watertemp = watertemp;
	}

	public int getPh() {
		return ph;
	}

	public void setPh(int ph) {
		this.ph = ph;
	}

	public long getLatitude() {
		return latitude;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}

	public long getLongitude() {
		return longitude;
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}


      
    /**
    * Timestamp (milliseconds since system boot)
    */
    public long time_boot_ms;
      
   
    /**
    * Generates the payload for a mavlink message for a message of this type
    * @return
    */
    public MAVLinkPacket pack(){
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH);
        
        packet.sysid = 255;
        packet.compid = 190;
        packet.msgid = MAVLINK_MSG_ID_ALL;
              
        packet.payload.putUnsignedInt(time_boot_ms);
              
        packet.payload.putInt(throttle);
        
        packet.payload.putInt(direction);
        
        packet.payload.putInt(controlvol);
        
        packet.payload.putInt(tractionvol);
        
        packet.payload.putInt(shiptemp);
        
        packet.payload.putInt(watertemp);
        
        packet.payload.putInt(ph);
        
        packet.payload.putLong(latitude);
        
        packet.payload.putLong(longitude);
        
        
        return packet;
    }

    /**
    * Decode a attitude message into this class fields
    *
    * @param payload The message to decode
    */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
              
        this.time_boot_ms = payload.getUnsignedInt();
        
        this.throttle = payload.getInt();
       
        this.direction = payload.getInt();
        
        this.controlvol = payload.getInt();
        
        this.tractionvol = payload.getInt();
        
        this.shiptemp = payload.getInt();
        
        this.watertemp = payload.getInt();
        
        this.ph = payload.getInt();
        
        this.latitude = payload.getLong();
        
        this.longitude = payload.getLong();
        
    }

    /**
    * Constructor for a new message, just initializes the msgid
    */
    public ShipInformation(){
        msgid = MAVLINK_MSG_ID_ALL;
    }

    /**
    * Constructor for a new message, initializes the message with the payload
    * from a mavlink packet
    *
    */
    public ShipInformation(MAVLinkPacket mavLinkPacket){
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_ALL;
        unpack(mavLinkPacket.payload);        
    }

                  
    /**
    * Returns a string with the MSG name and data
    */
    public String toString(){
        return "MAVLINK_MSG_ID_ATTITUDE - sysid:"+sysid+" compid:"+compid+" time_boot_ms:"+
            time_boot_ms+" throttle :"+throttle+" directtion:"+direction+" controvol:"+controlvol
            +" tractionvol:"+tractionvol+" shiptemp:"+shiptemp+" watertemp:"+watertemp+" PH:"+ph+
            " latitude:"+latitude+" longitude:"+longitude;
    }
}
        