package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.NetworkTableClient;

/**
 * Command for resetting the X and Y values
 */
public class ResetXYValues extends CommandBase {
    private final NetworkTableClient ntc;

    /**
     * Creates a new upXYValues.
     */
    public ResetXYValues(NetworkTableClient ntc) {
        this.ntc = ntc;
        addRequirements(ntc);
    }

    @Override
    public void execute() {
        ntc.resetX();
        ntc.resetY();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
