package org.usfirst.frc.team7042.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import org.usfirst.frc.team7042.commands.TeleopNoPID;
import org.usfirst.frc.team7042.robot.RobotMap;
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
  
    public MomentumPID movePID, turnPID;
    public MomentumPID pitchPID;
    
    private PIDCalculator calc;
    
    
    
    public DriveSystem() {
    	super("Drive System");
    	drive.setDeadband(0);
    	addChild("Left Side", leftside);
    	addChild("Right Side", rightside);
    	
    	movePID = PIDFactory.getMovePID();
    	turnPID = PIDFactory.getTurnPID();
    	
    	pitchPID = PIDFactory.getTiltPID();
    	
    	calc = new PIDCalculator(new MomentumPID[] {movePID, turnPID, pitchPID});
    	calc.start();
    	
    	addChild(drive);
    	addChild(movePID);
    	addChild(turnPID);
    	addChild(pitchPID);
    	
    }
    
    public void initDefaultCommand() {
    	setDefaultCommand(new TeleopNoPID());
    }
    
    public void arcadeDrive(double moveRequest, double turnRequest, double speedLimiter) {
    	double m_r = clip(moveRequest, -1, 1) * speedLimiter;
    	double t_r = clip(turnRequest, -1, 1) * speedLimiter;
    	drive.arcadeDrive(m_r, t_r, false);
    }
    
    public void tankDrive(double leftSide, double rightSide, double speedLimiter) {
    	double l_m = clip(leftSide * speedLimiter, -1, 1);
    	double r_m = clip(rightSide * speedLimiter, -1, 1);
    	drive.tankDrive(l_m, r_m);
    }
    
    public void stop() {
    	movePID.disable();
    	turnPID.disable();
    	pitchPID.disable();
    	tankDrive(0,0,0);
    }
    
    public void driveDisplacementPID() {
    	
    	double moveRequest = 0, turnRequest = 0;
    	if(pitchPID.isEnabled() && pitchPID.get() != 0) {
    		arcadeDrive(pitchPID.get(), 0, 1);
    		System.out.println("TILTING!!!!");
    		return;
    	}
    	if(movePID.isEnabled()) {
    		moveRequest = movePID.get();
    	}
    	if(turnPID.isEnabled()) {
    		turnRequest = turnPID.get();
    	}
    	
    	System.out.println("MR: "+moveRequest+" TR: "+turnRequest);
    	
    	arcadeDrive(moveRequest, turnRequest, PolyPrefs.getAutoSpeed());
    	
    }
    
    private double clip(double val, double min, double max) {
    	return Math.max(Math.min(val, max), min);
    }
    
}

