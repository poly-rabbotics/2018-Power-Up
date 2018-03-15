package org.usfirst.frc.team7042.robot.commands.lift;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ZeroThenTeleop extends CommandGroup {

    public ZeroThenTeleop() {
        addSequential(new ZeroLift());
        addSequential(new TeleopLift());
    }
}
