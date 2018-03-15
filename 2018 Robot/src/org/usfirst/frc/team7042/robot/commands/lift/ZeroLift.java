package org.usfirst.frc.team7042.robot.commands.lift;

import org.usfirst.frc.team7042.robot.Robot;
import org.usfirst.frc.team7042.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team7042.robot.subsystems.Lift;
import org.usfirst.frc.team7042.utils.PDPWrapper;

/**
 *
 */
public class ZeroLift extends Command {
	
	private Lift lift = Robot.lift;
	
	private static final double ZERO_SPEED = 0.2;
	private static final double CUTOFF_CURRENT = 9.0;
	private static final int CUTOFF_TIME = 500;
	
	private PDPWrapper currentChecker = new PDPWrapper();

    public ZeroLift() {
        requires(lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	lift.setSpeedNoLimit(-ZERO_SPEED);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return currentChecker.checkOvercurrent(new int[] {RobotMap.LIFT_1_PDP, RobotMap.LIFT_2_PDP}, CUTOFF_CURRENT, CUTOFF_TIME);
    }

    // Called once after isFinished returns true
    protected void end() {
    	lift.setSpeed(0);
    	lift.zeroLift();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	lift.setSpeed(0);
    }
}
