package org.usfirst.frc.team7042.robot.commands.intake;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc.team7042.robot.Robot;

/**
 *
 */
public class PistonRelease extends InstantCommand {

    public PistonRelease() {
        super();
        requires(Robot.grabber);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.grabber.release();
    }

}
