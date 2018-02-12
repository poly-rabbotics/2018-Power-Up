package org.usfirst.frc.team7042.robot.commands.autonomous;

import org.usfirst.frc.team7042.robot.Robot;
import org.usfirst.frc.team7042.robot.RobotMap;
import org.usfirst.frc.team7042.robot.subsystems.DriveSystem;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnDegrees extends Command {

	private AHRS angleGetter = RobotMap.ahrs;
	private double angle;
	
	private DriveSystem drive = Robot.driveSystem;
	
    public TurnDegrees(double angle) {
    	requires(drive);
    	this.angle = angle;
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	drive.turnPID.setSetpointRelative(angle);
    	drive.turnPID.enable();
    	System.out.format("Beginning turn using P:%.2f I:%.2f D:%.2f\n", drive.turnPID.getP(), drive.turnPID.getI(), drive.turnPID.getD());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.format("Current:%.2f Setpoint:%.2f Output:%.2f\n", angleGetter.getAngle(), drive.turnPID.getSetpoint(), drive.turnPID.get());
    	drive.driveTurnPID();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return drive.turnPID.onTargetForTime();
    }

    // Called once after isFinished returns true
    protected void end() {
    	drive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }

}
