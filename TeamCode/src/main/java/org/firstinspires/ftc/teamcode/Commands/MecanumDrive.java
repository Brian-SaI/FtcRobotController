package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.Subsystem;

import org.firstinspires.ftc.teamcode.Subsystems.CommandMecanumDriveTrain;

public class MecanumDrive extends CommandBase {
    private final CommandMecanumDriveTrain mecanum;

    private final double forward;
    private final double right;
    private final double rotate;
    public MecanumDrive(CommandMecanumDriveTrain mecanum, double forward, double right, double rotate) {
        this.mecanum = mecanum;
        this.forward = forward;
        this.right = right;
        this.rotate = rotate;

        addRequirements((Subsystem) mecanum);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        // run the driver motors
        mecanum.driveFieldRelative(forward, right, rotate);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        // do noting?
    }
}