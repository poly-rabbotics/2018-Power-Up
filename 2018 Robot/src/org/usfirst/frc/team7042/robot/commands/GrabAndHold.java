package org.usfirst.frc.team7042.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GrabAndHold extends CommandGroup {

    public GrabAndHold() {
        addSequential(new Grab());
        addSequential(new Hold());
    }
}
