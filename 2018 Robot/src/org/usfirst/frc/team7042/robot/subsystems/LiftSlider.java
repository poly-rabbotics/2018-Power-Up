package org.usfirst.frc.team7042.robot.subsystems;

import org.usfirst.frc.team7042.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LiftSlider extends Subsystem {

	public DoubleSolenoid slider = RobotMap.liftSolenoid;
	public boolean getOut() {
		return slider.get() == DoubleSolenoid.Value.kForward;
	}
	public void putOut() {
		slider.set(DoubleSolenoid.Value.kForward);
	}
	public void putIn() {
		slider.set(DoubleSolenoid.Value.kReverse);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

