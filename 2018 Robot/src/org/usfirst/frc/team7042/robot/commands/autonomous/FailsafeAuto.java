package org.usfirst.frc.team7042.robot.commands.autonomous;

import org.usfirst.frc.team7042.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team7042.robot.subsystems.DriveSystem;
import org.usfirst.frc.team7042.utils.PolyPrefs;

/**
 *
 */
public class FailsafeAuto extends Command {
	
	private static final double TIME = 3;
	private static final double SPEED = -0.80;
	
	private Timer timer = new Timer();
	
	private DriveSystem drive = Robot.driveSystem;
	
    public FailsafeAuto() {
        requires(drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drive.arcadeDrive(0, 0, SPEED);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.hasPeriodPassed(TIME);
    }

    // Called once after isFinished returns true
    protected void end() {
    	drive.arcadeDrive(0, 0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
