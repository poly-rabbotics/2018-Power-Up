package org.usfirst.frc.team7042.robot.controllers;

import org.usfirst.frc.team7042.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;

public class F310Wrapper extends DriveController {
	
	private Joystick logitech = RobotMap.logitech;
	
	private static final double MOVE_CURVE = 2;
	private static final double TURN_CURVE = 1;
	private static final double LIFT_SPEED = 1;
	
	private static final double DEADZONE = 0.05;
	
	

	@Override
	public double getMoveRequest() {
		double moveRequest = logitech.getRawAxis(1);
    	moveRequest = deadzone(moveRequest, DEADZONE);
    	moveRequest = curve(moveRequest, MOVE_CURVE);
    	return moveRequest;
	}

	@Override
	public double getTurnRequest() {
		double turnRequest = logitech.getRawAxis(4);
    	turnRequest = deadzone(turnRequest, DEADZONE);
    	turnRequest = curve(turnRequest, TURN_CURVE);
    	return turnRequest;
	}

	@Override
	public double getSpeedLimiter() {
		return 1;
	}

	@Override
	public boolean getReverseDirection() {
		return logitech.getRawButtonPressed(2);
	}

	@Override
	public boolean getKillPID() {
		return logitech.getRawButton(1);
	}

	@Override
	public double getLiftSpeed() {
		if(logitech.getPOV() == 0|| logitech.getPOV() == 45 || logitech.getPOV() == 315)
			return LIFT_SPEED;
		else if(logitech.getPOV() == 180 ||logitech.getPOV() ==  135 ||logitech.getPOV() ==  215)
			return -LIFT_SPEED;
		else
			return 0;
		 
	}

	@Override
	public boolean getMoveLift() {
		return logitech.getRawButtonPressed(6);
	}
	
	@Override
	public boolean getGrab() {
		double grabTrigger = logitech.getRawAxis(2);
		boolean grab;
		if (grabTrigger < 0.1)
			grab = false;
		else 
			grab = true;
		return grab;
	}
	
	public double getArmWheels () {
		if (logitech.getRawAxis(2) < 0.1)
			return 
	}

}
