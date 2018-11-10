package org.usfirst.frc.team7042.robot.subsystems;
import org.usfirst.frc.team7042.robot.RobotMap;
import org.usfirst.frc.team7042.robot.commands.RunElbow;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Elbow extends Subsystem {

	private VictorSP motor = RobotMap.rotatemotor;
	
	
	public void rotateArms(double speed){
		motor.set(speed);
	}


	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new RunElbow());
	}
   
}

