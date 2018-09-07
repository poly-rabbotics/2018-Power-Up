package org.usfirst.frc.team7042.robot.commands.autonomous;

import org.usfirst.frc.team7042.robot.RobotMap;
import org.usfirst.frc.team7042.robot.subsystems.Grab;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Eject extends Command {
	
	grab = Robot.;
	
    Eject (boolean drop) {
    	super();
    	requires(grabby);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(drop == true)
    		grab.release();
    	else
    		break;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
