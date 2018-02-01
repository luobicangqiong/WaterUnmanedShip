/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE RADIO_STATUS PACKING
package com.MAVLink.mavlinkpython.common;
import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
        
/**
* Status generated by radio and injected into MAVLink stream.
*/
public class msg_radio_status extends MAVLinkMessage{

    public static final int MAVLINK_MSG_ID_RADIO_STATUS = 109;
    public static final int MAVLINK_MSG_LENGTH = 9;
    private static final long serialVersionUID = MAVLINK_MSG_ID_RADIO_STATUS;


      
    /**
    * Receive errors
    */
    public int rxerrors;
      
    /**
    * Count of error corrected packets
    */
    public int fixed;
      
    /**
    * Local signal strength
    */
    public short rssi;
      
    /**
    * Remote signal strength
    */
    public short remrssi;
      
    /**
    * Remaining free buffer space in percent.
    */
    public short txbuf;
      
    /**
    * Background noise level
    */
    public short noise;
      
    /**
    * Remote background noise level
    */
    public short remnoise;
    

    /**
    * Generates the payload for a mavlink message for a message of this type
    * @return
    */
    public MAVLinkPacket pack(){
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH);
        packet.sysid = 255;
        packet.compid = 190;
        packet.msgid = MAVLINK_MSG_ID_RADIO_STATUS;
              
        packet.payload.putUnsignedShort(rxerrors);
              
        packet.payload.putUnsignedShort(fixed);
              
        packet.payload.putUnsignedByte(rssi);
              
        packet.payload.putUnsignedByte(remrssi);
              
        packet.payload.putUnsignedByte(txbuf);
              
        packet.payload.putUnsignedByte(noise);
              
        packet.payload.putUnsignedByte(remnoise);
        
        return packet;
    }

    /**
    * Decode a radio_status message into this class fields
    *
    * @param payload The message to decode
    */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
              
        this.rxerrors = payload.getUnsignedShort();
              
        this.fixed = payload.getUnsignedShort();
              
        this.rssi = payload.getUnsignedByte();
              
        this.remrssi = payload.getUnsignedByte();
              
        this.txbuf = payload.getUnsignedByte();
              
        this.noise = payload.getUnsignedByte();
              
        this.remnoise = payload.getUnsignedByte();
        
    }

    /**
    * Constructor for a new message, just initializes the msgid
    */
    public msg_radio_status(){
        msgid = MAVLINK_MSG_ID_RADIO_STATUS;
    }

    /**
    * Constructor for a new message, initializes the message with the payload
    * from a mavlink packet
    *
    */
    public msg_radio_status(MAVLinkPacket mavLinkPacket){
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_RADIO_STATUS;
        unpack(mavLinkPacket.payload);        
    }

                  
    /**
    * Returns a string with the MSG name and data
    */
    public String toString(){
        return "MAVLINK_MSG_ID_RADIO_STATUS - sysid:"+sysid+" compid:"+compid+" rxerrors:"+rxerrors+" fixed:"+fixed+" rssi:"+rssi+" remrssi:"+remrssi+" txbuf:"+txbuf+" noise:"+noise+" remnoise:"+remnoise+"";
    }
}
        