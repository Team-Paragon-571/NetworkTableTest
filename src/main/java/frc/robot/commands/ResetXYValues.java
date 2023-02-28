package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.NetworkTableClient;

public class ResetXYValues extends CommandBase {
    private final NetworkTableClient ntc;

    /** Creates a new upXYValues. */
    public ResetXYValues(NetworkTableClient ntc) {
        this.ntc = ntc;
        addRequirements(ntc);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        ntc.resetX();
        ntc.resetY();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
