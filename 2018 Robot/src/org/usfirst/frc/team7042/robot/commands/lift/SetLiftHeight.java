package org.usfirst.frc.team7042.robot.commands.lift;

import org.usfirst.frc.team7042.robot.Robot;
import org.usfirst.frc.team7042.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetLiftHeight extends Command {
	
	private Lift lift = Robot.lift;
	
	private int height = 0;	
    
	public SetLiftHeight(int height) {
        requires(lift);
        this.height = height;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	lift.pid.setSetpoint(height);
    	lift.pid.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	lift.drivePID();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return lift.pid.onTargetForTime();
    }

    // Called once after isFinished returns true
    protected void end() {
    	lift.pid.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
