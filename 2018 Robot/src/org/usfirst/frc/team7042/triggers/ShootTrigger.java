package org.usfirst.frc.team7042.triggers;

import org.usfirst.frc.team7042.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class ShootTrigger extends Trigger {

    public boolean get() {
        return Robot.controlChooser.getSelected().getShoot();
    }
}
