package org.usfirst.frc.team7042.robot.subsystems;

import org.usfirst.frc.team7042.robot.RobotMap;
import org.usfirst.frc.team7042.robot.commands.FlightstickDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveSystem extends Subsystem {
	

    private SpeedControllerGroup left = new SpeedControllerGroup(RobotMap.frontRight, RobotMap.backRight);
    private SpeedControllerGroup right = new SpeedControllerGroup(RobotMap.frontLeft, RobotMap.backLeft);
    private DifferentialDrive drive = new DifferentialDrive(left,right);
    public Encoder leftEnc = RobotMap.leftEncoder;
    public Encoder rightEnc = RobotMap.rightEncoder;
    
    
    public void arcadeDrive(double moveRequest, double turnRequest, double speedLimiter) {
    	double m_r = clip(moveRequest * speedLimiter, -1, 1);
    	double t_r = clip(turnRequest * speedLimiter, -1, 1);
    	drive.arcadeDrive(m_r, t_r, false);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new FlightstickDrive());
    }
    
    private double clip(double value, double min, double max) {
    	value = Math.max(value, min);
    	value = Math.min(value, max);
    	return value;
    }
    
 
}

