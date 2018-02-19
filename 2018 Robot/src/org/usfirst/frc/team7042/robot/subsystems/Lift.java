package org.usfirst.frc.team7042.robot.subsystems;

import org.usfirst.frc.team7042.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

//import edu.wpi.first.wpilibj.Solenoid;

public class Lift extends Subsystem {
	

	private VictorSP motor = RobotMap.liftMotor;

    /**
     * For a double solenoid system
     */
    public Lift() {
    }


    public void setSpeedNoLimit(double speed) {
    	motor.set(speed);
    }

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}