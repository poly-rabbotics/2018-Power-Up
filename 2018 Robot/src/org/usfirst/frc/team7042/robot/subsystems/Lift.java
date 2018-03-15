package org.usfirst.frc.team7042.robot.subsystems;

import org.usfirst.frc.team7042.robot.RobotMap;
import org.usfirst.frc.team7042.utils.MomentumPID;
import org.usfirst.frc.team7042.utils.PIDFactory;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

//import edu.wpi.first.wpilibj.Solenoid;

public class Lift extends Subsystem {
	

	private VictorSP motor1 = RobotMap.lift1;
	//private TalonSRX motor2 = RobotMap.lift2;
	
	public MomentumPID pid = PIDFactory.getLiftPID();
	
	private static final double MIN_HEIGHT = 0.1; //meters
	private static final double MAX_HEIGHT = 5; //meters
	
	private Encoder encoder = RobotMap.liftEncoder;
	
    /**
     * For a double solenoid system
     */
    public Lift() {
    	super();
    	addChild(pid);
    }


    public void setSpeedNoLimit(double speed) {
    	motor1.set(speed);
    }
    
    public void setSpeed(double speed) {
    	if(encoder.getDistance() <= MIN_HEIGHT && speed < 0) {
    		motor1.set(0);
    	} else if(encoder.getDistance() >= MAX_HEIGHT && speed > 0) {
    		motor1.set(0);
    	} else {
    		motor1.set(speed);
    	}
    }
    
    public void drivePID() {
    	setSpeed(pid.get());
    }
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
