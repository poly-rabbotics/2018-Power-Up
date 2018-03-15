package org.usfirst.frc.team7042.robot.commands.intake;

import org.usfirst.frc.team7042.robot.Robot;
import org.usfirst.frc.team7042.robot.subsystems.ArmWheels;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Eject extends Command {

	ArmWheels intake = Robot.intake;
	
	private static final double EJECT_TIME = 1;
	
	Timer time = new Timer();
	
    public Eject() {
        requires(intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	time.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	intake.eject();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return time.hasPeriodPassed(EJECT_TIME);
    }

    // Called once after isFinished returns true
    protected void end() {
    	new StopIntake().start();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
