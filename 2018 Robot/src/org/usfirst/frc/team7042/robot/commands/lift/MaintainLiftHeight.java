package org.usfirst.frc.team7042.robot.commands.lift;

import org.usfirst.frc.team7042.robot.Robot;
import org.usfirst.frc.team7042.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MaintainLiftHeight extends Command {

	private Lift lift = Robot.lift;
	
    public MaintainLiftHeight() {
        requires(lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	lift.pid.setSetpointRelative(0);
    	lift.pid.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	lift.drivePID();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	lift.pid.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	lift.pid.disable();
    }
}
