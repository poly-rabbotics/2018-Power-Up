package org.usfirst.frc.team7042.robot.commands;

import org.usfirst.frc.team7042.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Shoot extends Command {
	
	private static final double SHOOT_SPEED = 1;
	private static final double SHOOT_TIME = 2;
	
	private Timer timer = new Timer();

    public Shoot() {
        requires(Robot.arms);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.arms.setIntakeSpeed(-SHOOT_SPEED);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.hasPeriodPassed(SHOOT_TIME);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.arms.setIntakeSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
