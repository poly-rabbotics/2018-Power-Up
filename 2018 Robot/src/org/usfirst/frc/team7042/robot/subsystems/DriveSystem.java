package org.usfirst.frc.team7042.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import org.usfirst.frc.team7042.robot.RobotMap;
import org.usfirst.frc.team7042.robot.commands.TeleopNoPID;
import org.usfirst.frc.team7042.utils.PolyPrefs;
import org.usfirst.frc.team7042.utils.MomentumPID;
import org.usfirst.frc.team7042.utils.PIDCalculator;
import org.usfirst.frc.team7042.utils.PIDFactory;

/**
 *
 */
public class DriveSystem extends Subsystem {

    private SpeedControllerGroup leftside = new SpeedControllerGroup(RobotMap.frontRight, RobotMap.backRight);
    private SpeedControllerGroup rightside = new SpeedControllerGroup(RobotMap.frontLeft, RobotMap.backLeft);
    
    
    private DifferentialDrive drive = new DifferentialDrive(leftside, rightside);
    
    
    
    public DriveSystem() {
    	super("Drive System");
    	drive.setDeadband(0);
    	addChild("Left Side", leftside);
    	addChild("Right Side", rightside);
    
    	
    	addChild(drive);
    	
    }
    
    public void initDefaultCommand() {
    	setDefaultCommand(new TeleopNoPID());
    }
    
    public void arcadeDrive(double moveRequest, double turnRequest, double speedLimiter) {
    	double m_r = speedLimiter; 
    			//clip(moveRequest, -1, 1) * speedLimiter;
    	double t_r = turnRequest;
    			//clip(turnRequest, -1, 1) * speedLimiter;
    	drive.arcadeDrive(m_r, t_r, false);
    }
    
    public void tankDrive(double leftSide, double rightSide, double speedLimiter) {
    	double l_m = clip(leftSide * speedLimiter, -1, 1);
    	double r_m = clip(rightSide * speedLimiter, -1, 1);
    	//drive.tankDrive(l_m, r_m);
    }
    
    public void stop() {
    	arcadeDrive(0,0,0);
    }
    
    
    private double clip(double val, double min, double max) {
    	return Math.max(Math.min(val, max), min);
    }
    
}

