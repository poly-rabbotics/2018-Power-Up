package org.usfirst.frc.team7042.robot.controllers;

import org.usfirst.frc.team7042.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;

public class F310Wrapper extends DriveController {
	
	private Joystick logitech = RobotMap.logitech;
	
	private static final double MOVE_CURVE = 2;
	private static final double TURN_CURVE = 1;
	private static final double ROTATE_SPEED = .2; //no more than .4
	
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
		return logitech.getRawButton(4);
	}
	
	@Override
	public boolean getGrab() {
		return logitech.getRawButton(6);
	}
	
	@Override
	public boolean getShoot() {
		return logitech.getRawButton(5);
	}
	
	public double getRotateArms() {
		if(logitech.getRawButton(1)){ //x
			return -ROTATE_SPEED;
		}
		else if(logitech.getRawButton(3)){ //a
			return ROTATE_SPEED;
		}
		return 0;
	}
	
	

}
