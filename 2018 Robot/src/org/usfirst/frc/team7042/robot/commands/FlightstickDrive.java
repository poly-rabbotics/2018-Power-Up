package org.usfirst.frc.team7042.robot.commands;

import org.usfirst.frc.team7042.robot.PolyPrefs;
import org.usfirst.frc.team7042.robot.Robot;
import org.usfirst.frc.team7042.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FlightstickDrive extends Command {
	
	private final double DEADZONE = 0.05;
	private final double CURVE = 1;
	
	private Joystick flightstick = RobotMap.flightStick;

    public FlightstickDrive() {
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double m_r = deadzone(flightstick.getY(), DEADZONE);
    	m_r = curve(m_r, CURVE);
    	
    	double t_r = deadzone(flightstick.getTwist(), DEADZONE);
    	t_r = curve(t_r, CURVE);
    	
    	double s_l = (-flightstick.getThrottle() + 1) / 2;
    	
    	Robot.drive.arcadeDrive(m_r, t_r, s_l);
    	
    	if(flightstick.getRawButton(5)) {
    		RobotMap.leftEncoder.reset();
    		RobotMap.rightEncoder.reset();
    	}
    	double angle = 180*(RobotMap.leftEncoder.getRate() - RobotMap.rightEncoder.getRate()) / (Math.PI * PolyPrefs.getWheelDist());
    	System.out.format("Move: %.2f m/s Turn: %.2f degrees / sec\n", (RobotMap.leftEncoder.getRate() + RobotMap.rightEncoder.getRate()) / 2, angle);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.arcadeDrive(0, 0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
    private double deadzone(double value, double deadzone) {
    	if(Math.abs(value) < deadzone)
    		return 0;
    	else
    		return value;
    }
    
    private double curve(double value, double curve) {
    	if(curve == 0)
			return value;
		double powed = Math.pow(Math.abs(value), curve);
		if(value * powed > 0)
			return powed;
		else
			return -powed;
    }
}
