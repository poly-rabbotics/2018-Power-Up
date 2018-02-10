package org.usfirst.frc.team7042.robot;

import edu.wpi.first.wpilibj.Preferences;

public class PolyPrefs {
	private static Preferences prefs = Preferences.getInstance();
	
	private static final double MOVE_P = 0;
	private static final double MOVE_I = 0;
	private static final double MOVE_D = 0;
	private static final double TURN_P = 0;
	private static final double TURN_I = 0;
	private static final double TURN_D = 0;
	private static final double MOVE_ERR_GAIN = 0;
	private static final double WHEEL_DIST = 0;
	private static final double ENC_TICKS = 761.854104;
	private static final double AUTO_SPEED = 0.25;
	
	
	private static void checkDouble(String key, double value) {
		if(!prefs.containsKey(key))
			prefs.putDouble(key, value);
	}
	
	public static double getMoveP() {
		checkDouble("MOVE_P", MOVE_P);
		return prefs.getDouble("MOVE_P", MOVE_P);
	}
	public static double getMoveI() {
		checkDouble("MOVE_I", MOVE_I);
		return prefs.getDouble("MOVE_I", MOVE_I);
	}
	public static double getMoveD() {
		checkDouble("MOVE_D", MOVE_D);
		return prefs.getDouble("MOVE_D", MOVE_D);
	}
	public static double getTurnP() {
		checkDouble("TURN_P", TURN_P);
		return prefs.getDouble("TURN_P", TURN_P);
	}
	public static double getTurnI() {
		checkDouble("TURN_I", TURN_I);
		return prefs.getDouble("TURN_I", TURN_I);
	}
	public static double getTurnD() {
		checkDouble("TURN_D", TURN_D);
		return prefs.getDouble("TURN_D", TURN_D);
	}
	public static double getMoveErrGain() {
		checkDouble("MOVE_ERR_GAIN", MOVE_ERR_GAIN);
		return prefs.getDouble("MOVE_ERR_GAIN", MOVE_ERR_GAIN);
	}
	public static double getWheelDist() {
		checkDouble("WHEEL_DIST", WHEEL_DIST);
		return prefs.getDouble("WHEEL_DIST", WHEEL_DIST);
	}
	public static double getEncTicks() {
		checkDouble("ENC_TICKS", ENC_TICKS);
		return prefs.getDouble("ENC_TICKS", ENC_TICKS);
	}
	public static double getAutoSpeed() {
		checkDouble("AUTO_SPEED", AUTO_SPEED);
		return prefs.getDouble("AUTO_SPEED", AUTO_SPEED);
	}
}
