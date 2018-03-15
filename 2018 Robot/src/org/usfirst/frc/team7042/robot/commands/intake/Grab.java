package org.usfirst.frc.team7042.robot.commands.intake;

import org.usfirst.frc.team7042.robot.Robot;
import org.usfirst.frc.team7042.robot.RobotMap;
import org.usfirst.frc.team7042.robot.subsystems.ArmWheels;
import org.usfirst.frc.team7042.utils.PDPWrapper;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Grab extends Command {
	
	ArmWheels intake = Robot.intake;
	
	private static final double CUTOFF_CURRENT = 8;
	private static final int CUTOFF_TIME = 500;
	
	private PDPWrapper currentChecker = new PDPWrapper();

    public Grab() {
        requires(intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	intake.intake();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return currentChecker.checkOvercurrent(new int[] {RobotMap.LEFT_INTAKE_PDP, RobotMap.RIGHT_INTAKE_PDP}, CUTOFF_CURRENT, CUTOFF_TIME);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
