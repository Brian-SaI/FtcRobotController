package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.Subsystems.CommandMecanumDriveTrain;
import java.util.function.DoubleSupplier;

public class MecanumDrive extends CommandBase {
    private final CommandMecanumDriveTrain mecanum;
    private final DoubleSupplier forward;
    private final DoubleSupplier right;
    private final DoubleSupplier rotate;

    // Use DoubleSupplier so the values update every single frame
    public MecanumDrive(CommandMecanumDriveTrain mecanum, DoubleSupplier forward, DoubleSupplier right, DoubleSupplier rotate) {
        this.mecanum = mecanum;
        this.forward = forward;
        this.right = right;
        this.rotate = rotate;

        addRequirements(mecanum); // No need for manual casting anymore
    }

    @Override
    public void execute() {
        // Grab the freshest live values from the controller
        mecanum.driveFieldRelative(forward.getAsDouble(), right.getAsDouble(), rotate.getAsDouble());
    }

    @Override
    public boolean isFinished() {
        return false; // Stays active as the default state
    }

    @Override
    public void end(boolean interrupted) {
        mecanum.drive(0, 0, 0); // Safe stop if interrupted
    }
}