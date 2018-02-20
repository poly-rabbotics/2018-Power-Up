package org.usfirst.frc.team7042.robot.commands;

import org.usfirst.frc.team7042.robot.Robot;
import org.usfirst.frc.team7042.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Intake extends Command {
	private static final double INTAKESPEED = 1;
	private static final double HOLDSPEED = .2;
	
	private static final double CUTOFFCURRENT = 20;
	
	private static final double CUTOFFTIME = .2;
	
	private Timer timer = new Timer();

	private boolean held = false;
    public Intake() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (!held)
    		Robot.intake.setSpeed(INTAKESPEED);
    	else
    		Robot.intake.setSpeed(HOLDSPEED);
    	
    	if (!held) {
    		if(RobotMap.pdp.getCurrent(RobotMap.armWheel1pdp) > CUTOFFCURRENT || RobotMap.pdp.getCurrent(RobotMap.armWheel2pdp) > CUTOFFCURRENT )
    			held = timer.hasPeriodPassed(CUTOFFTIME);
    		else
    			timer.reset();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
