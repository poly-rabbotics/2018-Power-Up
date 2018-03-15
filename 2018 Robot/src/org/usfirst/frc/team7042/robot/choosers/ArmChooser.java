package org.usfirst.frc.team7042.robot.choosers;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class ArmChooser extends SendableChooser<Arm> {
	
	public ArmChooser() {
		super();
		addDefault("Piston arms", Arm.PISTON);
		addObject("Wheel arms", Arm.WHEELS);
	}
	
}
