package org.usfirst.frc.team7042.robot.subsystems;

import org.usfirst.frc.team7042.robot.RobotMap;
import org.usfirst.frc.team7042.robot.commands.intake.StopIntake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ArmWheels extends Subsystem {

	private TalonSRX wheel1 = RobotMap.armWheels1;
	private TalonSRX wheel2 = RobotMap.armWheels2;
    
	private static final double INTAKE_SPEED = 1;
	private static final double HOLD_SPEED = 0.1;
	private static final double EJECT_SPEED = 1;
    
    public ArmWheels() {
		super();
		
		//RobotMap.armWheels1.setInverted(true);
		
		
		
		
	}
    public void setSpeed(double speed) {
    	wheel1.set(ControlMode.PercentOutput,speed);
    	wheel2.set(ControlMode.PercentOutput,speed);
    }
    
    
    public void intake() {
    	System.out.format("LC: %.2f RC:%.2f\n",RobotMap.pdp.getCurrent(RobotMap.LEFT_INTAKE_PDP),RobotMap.pdp.getCurrent(RobotMap.RIGHT_INTAKE_PDP));
		setSpeed(INTAKE_SPEED);
    }
    
    public void hold() {
    	setSpeed(HOLD_SPEED);
    }
    
    public void eject() {
    	setSpeed(-EJECT_SPEED);
    }
    
    public void stop() {
    	setSpeed(0);
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new StopIntake());
    }
}

