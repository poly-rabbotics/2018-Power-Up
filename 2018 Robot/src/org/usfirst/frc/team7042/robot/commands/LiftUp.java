package org.usfirst.frc.team7042.robot.commands;

import org.usfirst.frc.team7042.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftUp extends Command {
	private static final double LIFTSPEED = 1;
	private Timer timer = new Timer();
	private static final double LIFTTIME = 1;


    public LiftUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.lift.setSpeedNoLimit(LIFTSPEED);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.hasPeriodPassed(LIFTTIME);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lift.setSpeedNoLimit(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
