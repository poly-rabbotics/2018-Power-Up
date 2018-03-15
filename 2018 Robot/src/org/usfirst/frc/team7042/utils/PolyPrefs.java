package org.usfirst.frc.team7042.utils;

import edu.wpi.first.wpilibj.Preferences;

public class PolyPrefs {
	
	private static Preferences prefs = Preferences.getInstance();
	
	private static final double AUTO_SPEED = 0.25;
	private static final double TILT_RANGE = 2;
	private static final double ENC_TICKS = 700; // number of encoder ticks per meter of travel
	private static final double LIFT_ENC_TICKS = 10; // ticks per meter of the lift
	
	
	
	private static void checkDouble(String key, double def) {
		if(!prefs.containsKey(key)) {
			prefs.putDouble(key, def);
		}
	}
	
	private static void checkInt(String key, int def) {
		if(!prefs.containsKey(key)) {
			prefs.putInt(key, def);
		}
	}
	public static double getEncTicks() { 
	    checkDouble("ENC_TICKS", ENC_TICKS); 
	    return prefs.getDouble("ENC_TICKS", ENC_TICKS); 
	  } 
	public static double getAutoSpeed() {
		checkDouble("AUTO_SPEED", AUTO_SPEED);
		return prefs.getDouble("AUTO_SPEED", AUTO_SPEED);
	}
	public static double getTiltRange() {
		checkDouble("TILT_RANGE",TILT_RANGE);
		return prefs.getDouble("TILT_RANGE", TILT_RANGE);
	}
	public static double getLiftEncTicks() {
		checkDouble("LIFT_ENC_TICKS",LIFT_ENC_TICKS);
		return prefs.getDouble("LIFT_ENC_TICKS", LIFT_ENC_TICKS);
	}

}
