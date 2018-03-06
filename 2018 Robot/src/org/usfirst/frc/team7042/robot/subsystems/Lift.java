package org.usfirst.frc.team7042.robot.subsystems;

import org.usfirst.frc.team7042.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

//import edu.wpi.first.wpilibj.Solenoid;

public class Lift extends Subsystem {
	

	private TalonSRX motor1 = RobotMap.lift1;
	private TalonSRX motor2 = RobotMap.lift2;

    /**
     * For a double solenoid system
     */
    public Lift() {
    	super();
    }


    public void setSpeedNoLimit(double speed) {
    	motor1.set(ControlMode.PercentOutput,speed);
    	motor2.set(ControlMode.PercentOutput,speed);
    }

    public void liftUp() {
    	
    }
    
    public void liftDown() {
    	
    	}
    
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}