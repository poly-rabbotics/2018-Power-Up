package org.usfirst.frc.team7042.robot.controllers;

public abstract class DriveController {
	
	/**
	 * return requested robot movement
	 * @return
	 */
	abstract public double getMoveRequest();
	/**
	 * get requested robot turn
	 * @return
	 */
	abstract public double getTurnRequest();
	/**
	 * get requested speed limit
	 * @return
	 */
	abstract public double getSpeedLimiter();
	
	/**
	 * get whether to switch front and back
	 * @return
	 */
	abstract public boolean getReverseDirection();
	/**
	 * emergency "please drive now"
	 * @return
	 */
	abstract public boolean getKillPID();
	
	/**
	 * get requested move speed of lift
	 * @return
	 */
	abstract public double getLiftSpeed();
	
	/**
	 * get to move lift forward/backwards
	 * @return
	 */
	abstract public boolean getMoveLift();
	
	/**
	 * get piston grab
	 * @return
	 */
	abstract public boolean getGrab();
	
	public double map(double val, double inmin, double inmax, double outmin, double outmax) {
    	return (((val - inmin) / (inmax - inmin)) * (outmax - outmin)) + outmin;
    }
    
    public double deadzone(double val, double deadzone) {
    	if(val < -deadzone)
    		return map(val, -1, -deadzone, -1, 0);
    	else if(val > deadzone) 
    		return map(val, deadzone, 1, 0, 1);
    	else
    		return 0;
    }
    
    public double curve(double val, double curve) {
    	if(curve == 0)
			return val;
		double powed = Math.pow(Math.abs(val), curve);
		if(val * powed > 0)
			return powed;
		else
			return -powed;
    }
    
    public double clip(double val, double min, double max) {
    	return Math.max(Math.min(val, max), min);
    }
}
