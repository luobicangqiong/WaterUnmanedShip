/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE HIL_ACTUATOR_CONTROLS PACKING
package com.MAVLink.mavlinkpython.common;
import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
        
/**
* Sent from autopilot to simulation. Hardware in the loop control outputs (replacement for HIL_CONTROLS)
*/
public class msg_hil_actuator_controls extends MAVLinkMessage{

    public static final int MAVLINK_MSG_ID_HIL_ACTUATOR_CONTROLS = 93;
    public static final int MAVLINK_MSG_LENGTH = 81;
    private static final long serialVersionUID = MAVLINK_MSG_ID_HIL_ACTUATOR_CONTROLS;


      
    /**
    * Timestamp (microseconds since UNIX epoch or microseconds since system boot)
    */
    public long time_usec;
      
    /**
    * Flags as bitfield, reserved for future use.
    */
    public long flags;
      
    /**
    * Control outputs -1 .. 1. Channel assignment depends on the simulated hardware.
    */
    public float controls[] = new float[16];
      
    /**
    * System mode (MAV_MODE), includes arming state.
    */
    public short mode;
    

    /**
    * Generates the payload for a mavlink message for a message of this type
    * @return
    */
    public MAVLinkPacket pack(){
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH);
        packet.sysid = 255;
        packet.compid = 190;
        packet.msgid = MAVLINK_MSG_ID_HIL_ACTUATOR_CONTROLS;
              
        packet.payload.putUnsignedLong(time_usec);
              
        packet.payload.putUnsignedLong(flags);
              
        
        for (int i = 0; i < controls.length; i++) {
            packet.payload.putFloat(controls[i]);
        }
                    
              
        packet.payload.putUnsignedByte(mode);
        
        return packet;
    }

    /**
    * Decode a hil_actuator_controls message into this class fields
    *
    * @param payload The message to decode
    */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
              
        this.time_usec = payload.getUnsignedLong();
              
        this.flags = payload.getUnsignedLong();
              
         
        for (int i = 0; i < this.controls.length; i++) {
            this.controls[i] = payload.getFloat();
        }
                
              
        this.mode = payload.getUnsignedByte();
        
    }

    /**
    * Constructor for a new message, just initializes the msgid
    */
    public msg_hil_actuator_controls(){
        msgid = MAVLINK_MSG_ID_HIL_ACTUATOR_CONTROLS;
    }

    /**
    * Constructor for a new message, initializes the message with the payload
    * from a mavlink packet
    *
    */
    public msg_hil_actuator_controls(MAVLinkPacket mavLinkPacket){
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_HIL_ACTUATOR_CONTROLS;
        unpack(mavLinkPacket.payload);        
    }

            
    /**
    * Returns a string with the MSG name and data
    */
    public String toString(){
        return "MAVLINK_MSG_ID_HIL_ACTUATOR_CONTROLS - sysid:"+sysid+" compid:"+compid+" time_usec:"+time_usec+" flags:"+flags+" controls:"+controls+" mode:"+mode+"";
    }
}
        