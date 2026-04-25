package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.MecanumDrive;
import org.firstinspires.ftc.teamcode.Commands.SwerveDrive;
import org.firstinspires.ftc.teamcode.Subsystems.CommandMecanumDriveTrain;
import org.firstinspires.ftc.teamcode.Subsystems.CommandSwerveDriveTrain;
import org.firstinspires.ftc.teamcode.Subsystems.SubsystemTest;

@TeleOp(name = "2026-Michiana Tele-Op", group = "Experimental")
public class RobotContainer extends CommandOpMode {
    private SubsystemTest subsystemTest;
    // DISABLE FOR MICHIANA!!! - Brian
    private final CommandSwerveDriveTrain swerveDriveTrain = new CommandSwerveDriveTrain();
    private final CommandMecanumDriveTrain mecanumDriveTrain = new CommandMecanumDriveTrain();
    private final GamepadEx driverController = new GamepadEx(gamepad1);
    private final GamepadEx manipulatorController = new GamepadEx(gamepad2);


    SwerveDrive swerveCommand = new SwerveDrive(swerveDriveTrain, driverController);
    MecanumDrive mecanumCommand = new MecanumDrive(mecanumDriveTrain, driverController.getLeftX(), driverController.getLeftY(), driverController.getRightX());

    @Override
    public void initialize() {

        // swerve-drive commands
        // lets the driver have continuous driver control.
        swerveDriveTrain.setDefaultCommand(swerveCommand);

        // mecanum-drive commands
        mecanumDriveTrain.setDefaultCommand(mecanumCommand);
    }


}

