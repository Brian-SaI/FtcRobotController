package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.Subsystem;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.Subsystems.CommandSwerveDriveTrain;

public class SwerveDrive extends CommandBase {
    private final CommandSwerveDriveTrain swerve;

    GamepadEx controller;

    public SwerveDrive(CommandSwerveDriveTrain swerve, GamepadEx driverController) {
        this.swerve = swerve;
        this.controller = driverController;

        addRequirements((Subsystem) swerve);
    }

    @Override
    public void initialize() {
        // run the driver motors
        swerve.drive(controller);
        // run the steer servos
        swerve.steer(controller);
    }

    @Override
    public void execute() {
        // You could add logic here if the power needed to change over time
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