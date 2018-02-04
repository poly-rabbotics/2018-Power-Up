package org.usfirst.frc.team7042.robot.subsystems;

import org.usfirst.frc.team7042.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

//import edu.wpi.first.wpilibj.Solenoid;

public class Lift extends Subsystem {
	
	private DoubleSolenoid solenoid = RobotMap.liftSolenoid;

    /**
     * For a double solenoid system
     */
    public Lift() {
    }

    /** 
     * Extends the solenoid
     */
    public void open() {
    	solenoid.set(DoubleSolenoid.Value.kForward);
    }

    /**
     * Retracts the solenoid
     */
    public void close() {
    	solenoid.set(DoubleSolenoid.Value.kReverse);
    }

    /**
     * Gets if the lift is retracted
     */
    public boolean getIn() {
    	return solenoid.get() == DoubleSolenoid.Value.kReverse;
    }

    /**
     * Gets if the lift is extended
     */
    public boolean getOut() {
    	return solenoid.get() == DoubleSolenoid.Value.kForward;
    }

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}