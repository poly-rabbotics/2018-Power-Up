package org.usfirst.frc.team7042.robot.subsystems;
import org.usfirst.frc.team7042.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Grab extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public DoubleSolenoid grabber = RobotMap.grabSolenoid;
	
	public boolean getGrabbed() {
		return grabber.get() == DoubleSolenoid.Value.kReverse;
	}
	public void release() {
		grabber.set(DoubleSolenoid.Value.kForward);
	}
	public void grab() {
		grabber.set(DoubleSolenoid.Value.kReverse);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
