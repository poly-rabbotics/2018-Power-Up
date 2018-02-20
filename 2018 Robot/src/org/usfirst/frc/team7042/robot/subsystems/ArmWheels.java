package org.usfirst.frc.team7042.robot.subsystems;

import org.usfirst.frc.team7042.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ArmWheels extends Subsystem {

	private TalonSRX wheel1 = RobotMap.armWheels1;
	private TalonSRX wheel2 = RobotMap.armWheels2;
    
    
    public ArmWheels() {
		super();
		
		RobotMap.armWheels1.setInverted(true);
		
		
		
		
	}
    public void setSpeed(double speed) {
    	wheel1.set(speed);
    	wheel2.set(speed);
    }
    
    
    public void intake() {
    	
    }
    
    public void eject() {
    	
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

