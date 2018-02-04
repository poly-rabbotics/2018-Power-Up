package org.usfirst.frc.team7042.robot.commands;

import org.usfirst.frc.team7042.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ActuateLiftPiston extends InstantCommand {

    public ActuateLiftPiston() {
        super();
        requires(Robot.lift);
    }

    // Called once when the command executes
    protected void initialize() {
    	if(Robot.lift.getIn()) {
    		Robot.lift.open();
    	} else {
    		Robot.lift.close();
    	}
    }

}
