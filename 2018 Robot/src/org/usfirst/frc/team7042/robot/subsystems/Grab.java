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

	public DoubleSolenoid grabby = RobotMap.grabSolenoid;
	
	public boolean getGrabbed() {
		return grabby.get() == DoubleSolenoid.Value.kReverse;
	}
	public void release() {
		grabby.set(DoubleSolenoid.Value.kForward);
	}
	public void grab() {
		grabby.set(DoubleSolenoid.Value.kReverse);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
