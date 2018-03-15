package org.usfirst.frc.team7042.robot.choosers;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class StartChooser extends SendableChooser<StartPos> {
	
	public StartChooser() {
		addObject("Left", StartPos.LEFT);
		addObject("Middle", StartPos.MIDDLE);
		addObject("Right", StartPos.RIGHT);
		SmartDashboard.putData(this);
	}

}
