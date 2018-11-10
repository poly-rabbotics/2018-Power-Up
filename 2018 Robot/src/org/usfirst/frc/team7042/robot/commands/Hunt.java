package org.usfirst.frc.team7042.robot.commands;

import org.usfirst.frc.team7042.robot.Robot;
import org.usfirst.frc.team7042.robot.RobotMap;
import org.usfirst.frc.team7042.utils.PDPWrapper;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Hunt extends Command {
	
	private static final double HUNT_SPEED = 0.8;

    public Hunt() {
        requires(Robot.arms);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.arms.open();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.arms.setIntakeSpeed(HUNT_SPEED);
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
