// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.NetworkTableClient;

/**
 * Command to update the X and Y values
 * When executed will change the X and Y values by 10 and 25 respectively.
 */
public class upXYValues extends CommandBase {
    private final NetworkTableClient ntc;

    /** Creates a new upXYValues. */
    public upXYValues(NetworkTableClient ntc) {
        this.ntc = ntc;
        addRequirements(ntc);
    }

    @Override
    public void execute() {
        ntc.incrementX(10);
        ntc.incrementY(25);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
