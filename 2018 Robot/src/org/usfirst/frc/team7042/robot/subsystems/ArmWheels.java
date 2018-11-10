package org.usfirst.frc.team7042.robot.subsystems;

import org.usfirst.frc.team7042.robot.RobotMap;
import org.usfirst.frc.team7042.robot.commands.RunElbow;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ArmWheels extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private VictorSP left = RobotMap.leftArmMotor, right = RobotMap.rightArmMotor;
	private DoubleSolenoid grabber = RobotMap.grabSolenoid;
	
	public void setIntakeSpeed(double speed) {
		left.set(speed);
		right.set(-speed);
	}
	
	public void grab() {
		grabber.set(DoubleSolenoid.Value.kForward);
	}
	
	public void open() {
		grabber.set(DoubleSolenoid.Value.kReverse);
	}
	
    public void initDefaultCommand() {
    	
    }
    
}

